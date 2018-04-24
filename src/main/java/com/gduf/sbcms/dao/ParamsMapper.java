package com.gduf.sbcms.dao;

import com.gduf.sbcms.entity.Params;
import com.gduf.sbcms.entity.ParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParamsMapper {
    int countByExample(ParamsExample example);

    int deleteByExample(ParamsExample example);

    int deleteByPrimaryKey(Integer paramid);

    int insert(Params record);

    int insertSelective(Params record);

    List<Params> selectByExample(ParamsExample example);

    List<Params> selectByPname(String paramName);
    
    Params selectByPrimaryKey(Integer paramid);

    int updateByExampleSelective(@Param("record") Params record, @Param("example") ParamsExample example);

    int updateByExample(@Param("record") Params record, @Param("example") ParamsExample example);

    int updateByPrimaryKeySelective(Params record);

    int updateByPrimaryKey(Params record);
}