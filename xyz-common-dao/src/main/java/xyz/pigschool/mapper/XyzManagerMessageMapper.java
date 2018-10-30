package xyz.pigschool.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.pigschool.manager.pojo.XyzManagerMessage;
import xyz.pigschool.manager.pojo.XyzManagerMessageExample;

public interface XyzManagerMessageMapper {
    int countByExample(XyzManagerMessageExample example);

    int deleteByExample(XyzManagerMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XyzManagerMessage record);

    int insertSelective(XyzManagerMessage record);

    List<XyzManagerMessage> selectByExample(XyzManagerMessageExample example);

    XyzManagerMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XyzManagerMessage record, @Param("example") XyzManagerMessageExample example);

    int updateByExample(@Param("record") XyzManagerMessage record, @Param("example") XyzManagerMessageExample example);

    int updateByPrimaryKeySelective(XyzManagerMessage record);

    int updateByPrimaryKey(XyzManagerMessage record);
}