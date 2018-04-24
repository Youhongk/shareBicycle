package com.gduf.sbcms.dao;

import com.gduf.sbcms.entity.Transactions;

public interface TransactionsMapper {

	int sumMoney(Integer uid) throws Exception;
	
    int deleteByPrimaryKey(Integer tid);

    int insert(Transactions record);

    int insertSelective(Transactions record);
    
    Transactions selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Transactions record);

    int updateByPrimaryKey(Transactions record);
}