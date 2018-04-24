package com.gduf.sbcms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gduf.sbcms.entity.Bicycle;

public interface BicycleMapper {

	//条件查询
	List<Bicycle> getBicycleByStatus(@Param("pks")String pks)throws Exception;
	
	List<Bicycle> select(Bicycle bicycle) throws Exception; 
	
	Bicycle selectByPrimaryKey(Integer bicycleId) throws Exception;
	
	int deleteByPrimaryKey(Integer bicycleId) throws Exception;

	int insert(Bicycle record) throws Exception;

	int insertSelective(Bicycle record) throws Exception;
	
	int updateByPrimaryKeySelective(Bicycle record) throws Exception;

	int updateByPrimaryKey(Bicycle record) throws Exception;
	
	int updateBatch(@Param("ids")String ids,@Param("bicycle")Bicycle bicycle) throws Exception;
}