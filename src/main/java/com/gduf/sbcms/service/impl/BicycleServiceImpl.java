package com.gduf.sbcms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gduf.sbcms.dao.BicycleMapper;
import com.gduf.sbcms.dao.ParamsMapper;
import com.gduf.sbcms.entity.Bicycle;
import com.gduf.sbcms.entity.Params;
import com.gduf.sbcms.service.BicycleService;

@Service
public class BicycleServiceImpl implements BicycleService {

	@Autowired
	BicycleMapper bicycleMapper;
	@Autowired
	ParamsMapper paramMapper;
	
	@Override
	public List<Bicycle> getBicycleData(Bicycle bicycle) throws Exception {		
		return bicycleMapper.select(bicycle);
	}
	
	@Override
	public int deleteByPrimaryKey(Integer bicycleId) throws Exception {
	
		return bicycleMapper.deleteByPrimaryKey(bicycleId);
	}

	@Override
	public int insert(Bicycle record) throws Exception {
	
		return bicycleMapper.insert(record);
	}

	@Override
	public int insertSelective(Bicycle record) throws Exception {
	
		return bicycleMapper.insertSelective(record);
	}

	@Override
	public Bicycle selectByPrimaryKey(Integer bicycleId) throws Exception {
	
		return bicycleMapper.selectByPrimaryKey(bicycleId);
	}

	@Override
	public void updateByPrimaryKeySelective(Bicycle record) throws Exception {
	
		 bicycleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Bicycle record) throws Exception {
	
		return bicycleMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateBatch(String ids, Bicycle bicycle) throws Exception {
		
		return bicycleMapper.updateBatch(ids, bicycle);
	}

	@Override
	public List<Params> getParamData(String paramName) throws Exception {		
		return paramMapper.selectByPname(paramName);
	}

	@Override
	public List<Bicycle> regionalInit() throws Exception {
		
		String pks = "4,6";
		return bicycleMapper.getBicycleByStatus(pks);
	}

}
