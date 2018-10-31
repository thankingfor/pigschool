package xyz.pigschool.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.pigschool.manager.pojo.XyzManagerContent;
import xyz.pigschool.manager.pojo.XyzManagerContentExample;

public interface XyzManagerContentMapper {
    int countByExample(XyzManagerContentExample example);

    int deleteByExample(XyzManagerContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XyzManagerContent record);

    int insertSelective(XyzManagerContent record);

    List<XyzManagerContent> selectByExampleWithBLOBs(XyzManagerContentExample example);

    List<XyzManagerContent> selectByExample(XyzManagerContentExample example);

    XyzManagerContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XyzManagerContent record, @Param("example") XyzManagerContentExample example);

    int updateByExampleWithBLOBs(@Param("record") XyzManagerContent record, @Param("example") XyzManagerContentExample example);

    int updateByExample(@Param("record") XyzManagerContent record, @Param("example") XyzManagerContentExample example);

    int updateByPrimaryKeySelective(XyzManagerContent record);

    int updateByPrimaryKeyWithBLOBs(XyzManagerContent record);

    int updateByPrimaryKey(XyzManagerContent record);
}