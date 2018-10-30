package xyz.pigschool.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.pigschool.manager.pojo.XyzManagerTotal;
import xyz.pigschool.manager.pojo.XyzManagerTotalExample;

public interface XyzManagerTotalMapper {
    int countByExample(XyzManagerTotalExample example);

    int deleteByExample(XyzManagerTotalExample example);

    int deleteByPrimaryKey(String recorddateid);

    int insert(XyzManagerTotal record);

    int insertSelective(XyzManagerTotal record);

    List<XyzManagerTotal> selectByExample(XyzManagerTotalExample example);

    XyzManagerTotal selectByPrimaryKey(String recorddateid);

    int updateByExampleSelective(@Param("record") XyzManagerTotal record, @Param("example") XyzManagerTotalExample example);

    int updateByExample(@Param("record") XyzManagerTotal record, @Param("example") XyzManagerTotalExample example);

    int updateByPrimaryKeySelective(XyzManagerTotal record);

    int updateByPrimaryKey(XyzManagerTotal record);
}