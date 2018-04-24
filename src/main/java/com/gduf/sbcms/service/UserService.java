package com.gduf.sbcms.service;

import com.gduf.sbcms.entity.Bicycle;
import com.gduf.sbcms.entity.Feedback;
import com.gduf.sbcms.entity.Riding;
import com.gduf.sbcms.entity.Transactions;
import com.gduf.sbcms.entity.User;

public interface UserService {

	void regist(User user)throws Exception;
	
	User login(User user)throws Exception;
	
	void updateUser(User user)throws Exception;
	
	void deposit(User user) throws Exception;
	
	void recharge(Transactions trans) throws Exception;
	
	public void refund(User user) throws Exception ;
	
	public void feedback(Feedback fd) throws Exception ;
	
	public int payCount(Integer userId,Bicycle bike)throws Exception;
	
	public void riding(User loginUser,  Bicycle bicycle)throws Exception;
	
	public int pay(Riding riding,User loginUser)throws Exception;
	
		
	int deleteByPrimaryKey(Integer userid);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userid);

	User select(User user);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}
