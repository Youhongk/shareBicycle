package com.gduf.sbcms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gduf.sbcms.dao.RidingMapper;
import com.gduf.sbcms.entity.Riding;
import com.gduf.sbcms.service.RidingService;

@Service
public class RidingServiceImpl implements RidingService {

	@Autowired
	RidingMapper ridingmapper;
	
	/*
	 * 计算用户未完成订单的数量
	 */
	@Override
	public Riding countSign(Integer id) throws Exception {
		
		return ridingmapper.countSign(id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) throws Exception {
		
		return ridingmapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Riding record) throws Exception {
		
		return ridingmapper.insert(record);
	}

	@Override
	public int insertSelective(Riding record) throws Exception {
		
		return ridingmapper.insertSelective(record);
	}

	@Override
	public Riding selectByPrimaryKey(Integer id) throws Exception {
		
		return ridingmapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Riding record) throws Exception {
		
		return ridingmapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Riding record) throws Exception {
		
		return ridingmapper.updateByPrimaryKey(record);
	}

	@Override
	public Riding checkRiding(Integer id) throws Exception {
				
		return ridingmapper.checkRiding(id);
	}

	@Override
	public List<Riding> getBicycleData(Riding riding) throws Exception {
		
		return ridingmapper.select(riding);
	}

}
