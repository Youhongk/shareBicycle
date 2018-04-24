package com.gduf.sbcms.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gduf.sbcms.Util.CalculationUtil;
import com.gduf.sbcms.dao.UserMapper;
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

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	@Autowired
	TransService transService;
	@Autowired
	FeedbackService fdService;
	@Autowired
	RidingService ridingService;
	@Autowired
	BicycleService bicycleService;
	
	/*
	 * 注册
	 * 
	 */
	public void regist(User user) throws Exception {
		userMapper.insertSelective(user);	
	}

	/*
	 * 登陆
	 * 
	 */
	@Override
	public User login(User user) throws Exception {		
		return userMapper.select(user);
	}

	/*
	 * 更新
	 *
	 */
	@Override
	public void updateUser(User user) throws Exception {
		 userMapper.updateByPrimaryKeySelective(user);
	}
	
	/*
	 * 缴纳押金
	 * 
	 */
	@Override
	@Transactional
	public void deposit(User user) throws Exception {
		
		//这里先生成一条流水记录
		Transactions trans = new Transactions(user.getUserid(),299,new Date(),"1");
		transService.insert(trans);
		//再进行跟新
		this.updateByPrimaryKey(user);
	}
	
	/*
	 * 退押金
	 * 
	 */
	@Override
	@Transactional
	public void refund(User user) throws Exception {
		
		//这里先生成一条流水记录
		Transactions trans = new Transactions(user.getUserid(),-299,new Date(),"2");
		transService.insert(trans);
		//再进行跟新
		this.updateByPrimaryKey(user);
	}
	
	/*
	 * 充值
	 */
	@Override
	public void recharge(Transactions trans) throws Exception {
		transService.insert(trans);	 //生成一条充值流水	
	}	
	
	/*
	 * 用户反馈
	 */
	@Override
	public void feedback(Feedback fd) throws Exception {
		fdService.insertSelective(fd);	 //生成一条充值流水	
	}	
	
	
	
	
	
	
	
	
	@Override
	public int deleteByPrimaryKey(Integer userid) {
		
		return userMapper.deleteByPrimaryKey(userid);
	}

	@Override
	public int insert(User record) {
		
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer userid) {
	
		return userMapper.selectByPrimaryKey(userid);
	}

	@Override
	public User select(User user) {
		
		return userMapper.select(user);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		
		return userMapper.updateByPrimaryKey(record);
	}

	/*
	 * 结束骑行，返回费用
	 * @see com.gduf.sbcms.service.UserService#payCount(java.lang.Integer)
	 */
	@Override
	@Transactional
	public int payCount(Integer userId,Bicycle bike) throws Exception {
		
		Riding riding = ridingService.checkRiding(userId);   //查出正在骑行的记录
		if(riding==null)
			return -1;
		riding.setEndtime(new Date());                       //借宿时间
		riding.setRidingStatus("1");                         //修改状态为未付款
		ridingService.updateByPrimaryKeySelective(riding);   //修改骑行记录
		bike.setBicycleStatus(4);                            //修改车辆状态为可用
		bicycleService.updateByPrimaryKey(bike);
		int payCount = CalculationUtil.calcula(riding.getStarttime(),riding.getEndtime());		
		return payCount;
	}

	/*
	 * 开始骑行
	 * 
	 */
	@Override
	@Transactional
	public void riding(User loginUser, Bicycle bicycle) throws Exception {		
		Riding riding = new Riding();              
		riding.setStarttime(new Date()); 
		riding.setUserId(loginUser.getUserid());
		riding.setRidingStatus("0");				             
		bicycle.setBicycleStatus(5);
		
		ridingService.insertSelective(riding);              //生成骑行记录
		bicycleService.updateByPrimaryKeySelective(bicycle);//修改车辆状态
	}

	@Override
	@Transactional
	public int pay(Riding riding,User loginUser) throws Exception {
		
		riding.setRidingStatus("2");
		ridingService.updateByPrimaryKey(riding);
		
		int payCount = CalculationUtil.calcula(riding.getStarttime(),riding.getEndtime());	
		
		if(transService.sumMoney(loginUser.getUserid())<payCount){			
			return -1;  //余额不足			
		};
		
		Transactions trans = new Transactions(
				loginUser.getUserid(),-payCount,new Date(),"4");
		transService.insertSelective(trans);			
		return 1;	//付款成功			
	}

	

	
}
