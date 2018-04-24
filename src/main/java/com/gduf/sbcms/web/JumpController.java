package com.gduf.sbcms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gduf.sbcms.entity.Bicycle;
import com.gduf.sbcms.entity.User;
import com.gduf.sbcms.service.BicycleService;
import com.gduf.sbcms.service.FeedbackService;
import com.gduf.sbcms.service.RidingService;
import com.gduf.sbcms.service.TransService;
import com.gduf.sbcms.service.UserService;

@Controller
@RequestMapping("/jump")
public class JumpController {

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

	
	/*
	 * model对象中存放的参数：
	 * 1、message:用于告诉前台应该弹出哪个模态框，执行哪个操作
	 * 2、lgInfo:判断是否登陆
	 * 3、error:故障信息
	 */
	@RequestMapping("/scan")
	public ModelAndView scan(HttpSession session, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		Integer bicycleId = (Integer)session.getAttribute("bicycleId");
		if(bicycleId==null){//判断进入方式：先登陆还是先扫码
			bicycleId = new Integer(request.getParameter("id")); // 获取车辆id
		}
		Bicycle bicycle = bicycleService.selectByPrimaryKey(bicycleId); // 获取车辆信息
		User loginUser = (User) session.getAttribute("loginUser"); // 获取登陆信息
		mav.addObject("name", "");
		mav.addObject("vip", "");
		mav.addObject("number", ""); // 算出余额
		String viewName = ""; // 转发的页面：tips/user  
		
		//判断车辆是否可用
		boolean flag=true;
		if(bicycle == null ) {
			mav.addObject("errorInfo", "车辆信息异常，请另外寻找车辆骑行！");
		}else if(bicycle.getBicycleStatus() == 5)			
				mav.addObject("errorInfo", "车辆使用中，请另外寻找车辆骑行！");
		else if(bicycle.getBicycleStatus() == 6)
				mav.addObject("errorInfo", "抱歉，车辆故障，请另外寻找车辆骑行！");
		else{
			flag = false;
		}
		if(flag){			
			viewName = "tips";
			mav.setViewName(viewName);
			return mav;
		}
		
		viewName = "user";
		mav.setViewName(viewName);
		if (loginUser == null) { 
			mav.addObject("lgInfo", "0");	//未登录	
			mav.addObject("message", "0");
			session.setAttribute("bicycleId", bicycleId);//车辆可用则把这次扫描的车辆id存放到session备用
		} else{
			mav.addObject("lgInfo", "1");   //已登录			
			mav.addObject("name", ""+loginUser.getName());
			mav.addObject("vip", ""+loginUser.getVip());
			mav.addObject("number", "" + transService.sumMoney(loginUser.getUserid())); // 算出余额			
			if ( "0".equals(loginUser.getVip()) ) { // 判断是否交了押金 0-未交押金
				mav.addObject("message", "1");	
				return mav;	
			} else if (ridingService.checkRiding(loginUser.getUserid()) != null) {
				mav.addObject("message", "2"); // 已交押金， 判断用户是否用车中，正在骑行
				return mav;
			} else if (ridingService.countSign(loginUser.getUserid()) != null) {
				mav.addObject("message", "3"); // 已交押金，未骑行,检查是否有未完成订单 ,有未完成订单
				return mav;
			} else {
				userService.riding(loginUser, bicycle); // 骑行
				session.setAttribute("bike", bicycle); //把正在骑行的车辆信息保存到session中备用
				mav.addObject("message", "4");
			}
		}		
			return mav;
	}

	@RequestMapping("/goUser")
	public ModelAndView goUser(HttpServletRequest request) throws Exception {			
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("user");
		mav.addObject("lgInfo", "-1");
		mav.addObject("message", "-1");
		mav.addObject("name", "");
		mav.addObject("vip", "");
		mav.addObject("number", ""); // 算出余额
		return mav;
	}

	@RequestMapping("/goIndex")
	public ModelAndView goIndex() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

}
