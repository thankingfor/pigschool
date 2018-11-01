package xyz.pigschool.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.pigschool.manager.pojo.XyzManagerTag;
import xyz.pigschool.manager.pojo.XyzManagerTagExample;

public interface XyzManagerTagMapper {
    int countByExample(XyzManagerTagExample example);

    int deleteByExample(XyzManagerTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XyzManagerTag record);

    int insertSelective(XyzManagerTag record);

    List<XyzManagerTag> selectByExample(XyzManagerTagExample example);

    XyzManagerTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XyzManagerTag record, @Param("example") XyzManagerTagExample example);

    int updateByExample(@Param("record") XyzManagerTag record, @Param("example") XyzManagerTagExample example);

    int updateByPrimaryKeySelective(XyzManagerTag record);

    int updateByPrimaryKey(XyzManagerTag record);
}