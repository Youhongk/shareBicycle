package com.gduf.sbcms.dao;

import java.util.List;

import com.gduf.sbcms.entity.Riding;

public interface RidingMapper {

	/*
	 * 根据用户编号查询骑行记录，统计未完成记录的数量
	 */
	Riding countSign(Integer id)throws Exception;
	
	/*
	 * 根据用户编号查询骑行记录，统计正在骑行的记录的数量
	 */
	Riding checkRiding(Integer id)throws Exception;
	
	List<Riding> select(Riding riding)throws Exception;
	
	int deleteByPrimaryKey(Integer id)throws Exception;

	int insert(Riding record)throws Exception;

	int insertSelective(Riding record)throws Exception;

	Riding selectByPrimaryKey(Integer id)throws Exception;
	
	Riding select(Integer userId)throws Exception;
	
	int updateByPrimaryKeySelective(Riding record)throws Exception;

	int updateByPrimaryKey(Riding record)throws Exception;
}