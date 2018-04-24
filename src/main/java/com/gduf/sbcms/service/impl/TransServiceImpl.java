package com.gduf.sbcms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gduf.sbcms.dao.TransactionsMapper;
import com.gduf.sbcms.entity.Transactions;
import com.gduf.sbcms.service.TransService;

@Service
public class TransServiceImpl implements TransService {

	@Autowired
	TransactionsMapper transMapper;

	/*
	 * 计算余额
	 */
	@Override
	public int sumMoney(Integer uid) throws Exception {
		int result = 0;

		result = transMapper.sumMoney(uid);

		return result;
	}

	@Override
	public int deleteByPrimaryKey(Integer tid) throws Exception {

		return transMapper.deleteByPrimaryKey(tid);
	}

	@Override
	public int insert(Transactions record) throws Exception {

		return transMapper.insert(record);
	}

	@Override
	public int insertSelective(Transactions record) throws Exception {

		return transMapper.insertSelective(record);
	}

	@Override
	public Transactions selectByPrimaryKey(Integer tid) throws Exception {

		return transMapper.selectByPrimaryKey(tid);
	}

	@Override
	public int updateByPrimaryKeySelective(Transactions record) throws Exception {

		return transMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Transactions record) throws Exception {

		return transMapper.updateByPrimaryKey(record);
	}

}
