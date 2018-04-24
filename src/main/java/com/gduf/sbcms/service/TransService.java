package com.gduf.sbcms.service;

import com.gduf.sbcms.entity.Transactions;

public interface TransService {
	
	int sumMoney(Integer uid) throws Exception;

	int deleteByPrimaryKey(Integer tid) throws Exception;

    int insert(Transactions record) throws Exception;

    int insertSelective(Transactions record) throws Exception;
    
    Transactions selectByPrimaryKey(Integer tid) throws Exception;

    int updateByPrimaryKeySelective(Transactions record) throws Exception;

    int updateByPrimaryKey(Transactions record) throws Exception; 
    
}
