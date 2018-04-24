package com.gduf.sbcms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gduf.sbcms.entity.Bicycle;
import com.gduf.sbcms.entity.Params;

public interface BicycleService {

	List<Params> getParamData(String paramName) throws Exception;
	
	List<Bicycle> getBicycleData(Bicycle bicycle) throws Exception;

	Bicycle selectByPrimaryKey(Integer bicycleId) throws Exception;
	
	int deleteByPrimaryKey(Integer bicycleId) throws Exception;

	int insert(Bicycle record) throws Exception;

	int insertSelective(Bicycle record) throws Exception;
	
	void updateByPrimaryKeySelective(Bicycle record) throws Exception;

	int updateByPrimaryKey(Bicycle record) throws Exception;
	
	int updateBatch(String ids,Bicycle bicycle) throws Exception;
	List<Bicycle> regionalInit() throws Exception;
	
}
