package com.gduf.sbcms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gduf.sbcms.dao.FeedbackMapper;
import com.gduf.sbcms.entity.Feedback;
import com.gduf.sbcms.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackMapper fdMapper;
	
	/*
	 * 按条件插入
	 * 
	 */
	@Override
	public int insertSelective(Feedback record) throws Exception{	
		return fdMapper.insertSelective(record);
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return 0;
	}

	@Override
	public int insert(Feedback record) {
		
		return 0;
	}

	@Override
	public Feedback selectByPrimaryKey(Integer id) {
		
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Feedback record) {
		
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Feedback record) {
		
		return 0;
	}

	@Override
	public List<Feedback> getFeedbackData(Feedback feedback) throws Exception {
		
		return fdMapper.select(feedback);
	}

}
