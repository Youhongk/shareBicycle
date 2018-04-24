package com.gduf.sbcms.dao;

import java.util.List;

import com.gduf.sbcms.entity.Feedback;

public interface FeedbackMapper {

	/*
	 * 
	 */
	List<Feedback> select(Feedback feedback) throws Exception;
	
	int deleteByPrimaryKey(Integer id) throws Exception;

	int insert(Feedback record) throws Exception;

	int insertSelective(Feedback record) throws Exception;

	Feedback selectByPrimaryKey(Integer id) throws Exception;

	int updateByPrimaryKeySelective(Feedback record) throws Exception;

	int updateByPrimaryKey(Feedback record) throws Exception;
}