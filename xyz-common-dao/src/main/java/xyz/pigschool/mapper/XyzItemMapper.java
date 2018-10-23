package xyz.pigschool.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.pigschool.pojo.XyzItem;
import xyz.pigschool.pojo.XyzItemExample;

public interface XyzItemMapper {
    int countByExample(XyzItemExample example);

    int deleteByExample(XyzItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XyzItem record);

    int insertSelective(XyzItem record);

    List<XyzItem> selectByExample(XyzItemExample example);

    XyzItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XyzItem record, @Param("example") XyzItemExample example);

    int updateByExample(@Param("record") XyzItem record, @Param("example") XyzItemExample example);

    int updateByPrimaryKeySelective(XyzItem record);

    int updateByPrimaryKey(XyzItem record);
}