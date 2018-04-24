package com.gduf.sbcms.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gduf.sbcms.Util.CalculationUtil;
import com.gduf.sbcms.entity.Bicycle;
import com.gduf.sbcms.entity.Feedback;
import com.gduf.sbcms.entity.Riding;
import com.gduf.sbcms.entity.Transactions;
import com.gduf.sbcms.entity.User;
import com.gduf.sbcms.service.BicycleService;
import com.gduf.sbcms.service.FeedbackService;
import com.gduf.sbcms.service.RidingService;
import com.gduf.sbcms.service.TransService;
import com.gduf.sbcms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	TransService transService;
	@Autowired
	FeedbackService fdService;
	@Autowired
	BicycleService bicycleService;
	@Autowired
	RidingService ridingService;

	@RequestMapping("/regist")
	public String regist(@RequestBody User user) throws Exception {
		userService.regist(user);
		return "success";
	}

	@RequestMapping("/login")
	public Map<String, String> login(@RequestBody User User, HttpSession session) throws Exception {
				 
		session.removeAttribute("loginUser");//每次登陆都会先清空登陆信息	
					
		User loginUser = userService.login(User);//执行登陆
		
		if (loginUser != null) { // 登陆成功
			session.setAttribute("loginUser", loginUser); // 登陆信息存进session备用
			Map<String, String> userInfo = new HashMap<String, String>();
			userInfo.put("name", loginUser.getName());
			userInfo.put("vip", loginUser.getVip());
			userInfo.put("number", "" + transService.sumMoney(loginUser.getUserid())); // 算出余额
			return userInfo;//收集要回传到前端的信息
		}		
		return null; // 登陆失败
	}

	@RequestMapping("/deposit")
	public String deposit(HttpSession session) throws Exception {

		User loginUser = (User) session.getAttribute("loginUser");
		String sign="";
		if (loginUser != null) { // 先判断是否已登陆
			if (loginUser.getVip().equals("1")) { // 每次做更新操作时必须先检查操作是否有效
				sign = "UD2"; // UD2为已经缴纳押金的标志，UD1为未缴纳
			} else {
				loginUser.setVip("1");
				userService.deposit(loginUser);
				sign = "success";
			}

		} else {
			sign = "UL1";
		}
		return sign;
	}

	@RequestMapping("/refund")
	public String refund(HttpSession session) throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser != null) { // 安全保证，再次判断是否已登陆
			if (loginUser.getVip().equals("0")) { // 每次做更新操作时必须先检查操作是否有效
				return "UD1"; // UD2为已经缴纳押金的标志，UD1为未缴纳
			} else {
				loginUser.setVip("0");
				userService.refund(loginUser);
				return "success";
			}

		} else {
			return "UL1";
		}
	}

	@RequestMapping("/recharge")
	public int recharge(@RequestBody Transactions trans, HttpSession session) throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser != null) { // 安全保证，再次判断是否已登陆
			trans.setTdate(new Date());
			trans.setType("3");
			trans.setUid(loginUser.getUserid());
			transService.insert(trans);
			int number = transService.sumMoney(loginUser.getUserid());
			return number;
		} else {
			return -1;
		}
	}

	@RequestMapping("/feedback")
	public String feedback(@RequestBody Feedback fd, HttpSession session) throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser != null) { // 先判断是否已登陆
			if (fd.getBicycleId() != null && bicycleService.selectByPrimaryKey(fd.getBicycleId()) == null) {
				return "nobike";
			} else {
				fd.setUserId(loginUser.getUserid());
				fd.setFeedbackStatus("1");
				fdService.insertSelective(fd);
				return "success";
			}
		} else {
			return "fail";
		}

	}

	@RequestMapping("/checkPay")
	public Map<String, String> checkPay(HttpSession session) throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");
		Map<String, String> payInfo = new HashMap<String, String>();
		if (loginUser != null) { // 先判断是否已登陆
			Riding riding = ridingService.countSign(loginUser.getUserid());
			if (riding == null) {
				payInfo.put("status", "0");
			} else {
				payInfo.put("status", "1");
			}
		} else {
			payInfo.put("status", "-1");
		}
		return payInfo;
	}

	@RequestMapping("/checkRiding")
	public Map<String, String> checkRiding(HttpSession session) throws Exception {

		User loginUser = (User) session.getAttribute("loginUser");
		Map<String, String> ridingInfo = new HashMap<String, String>();
		if (loginUser != null) { // 先判断是否已登陆

			Riding record = ridingService.checkRiding(loginUser.getUserid());
			if (record != null) {
				Long startTime = new Date().getTime() - record.getStarttime().getTime();
				ridingInfo.put("startTime", "" + startTime); // 开始时间
				ridingInfo.put("status", "0"); // 在骑车
			} else {
				ridingInfo.put("status", "1"); // 没骑车
			}
		} else {
			ridingInfo.put("status", "2"); // 没登陆
		}

		return ridingInfo;
	}

	@RequestMapping("/calculation")	
	public int calculation(HttpSession session, HttpServletRequest request) throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser != null) { // 先判断是否已登陆
			Bicycle bike = (Bicycle)session.getAttribute("bike");
			int pay = userService.payCount(loginUser.getUserid(),bike);
			session.setAttribute("ridingStatus", "1");
			session.removeAttribute("bicycleId");//结束骑行，移除绑定的车辆
			return pay;
		}
		return -1;
	}

	@RequestMapping("/pay")
	public int pay(@RequestBody Map map, HttpSession session) throws Exception {
		String pwd = (String) map.get("pass");
		User loginUser = (User) session.getAttribute("loginUser");
		
		if (pwd != "" && pwd.equals(loginUser.getPassword())) {
			Riding riding = ridingService.countSign(loginUser.getUserid());	
			if (riding != null) {				
				int flag = userService.pay(riding,loginUser);
				if(flag<0)
					return flag;//余额不足
				session.setAttribute("ridingStatus", "2");				
				return 0;//付款成功
			}
			return 1;//没有未完成的订单
		}
		return 2;//密码错误

	}

	@RequestMapping("/checkRidingStatus")
	public Map<String,String> checkRidingStatus(HttpSession session) throws Exception{
		User loginUser = (User) session.getAttribute("loginUser");
		Map<String,String> map =new HashMap<String,String>();
		Riding ridingR =null;
		Riding ridingP =null;
		if(loginUser!=null){
			ridingR = ridingService.checkRiding(loginUser.getUserid());
			ridingP = ridingService.countSign(loginUser.getUserid());
		}
		if(ridingR==null){
			if(ridingP!=null){
				int payCount = CalculationUtil.calcula(ridingP.getStarttime(),ridingP.getEndtime());
				map.put("payCount",""+payCount);
				map.put("ridingStatus", "1");//有未完成的订单
			}else{
				map.put("ridingStatus", "");//有未完成的订单
			}
		}else{
			map.put("ridingStatus", "0");//正在骑行
		}
		return map;
	}
}
