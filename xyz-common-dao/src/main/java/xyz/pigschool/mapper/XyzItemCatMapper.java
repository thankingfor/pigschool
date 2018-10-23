package xyz.pigschool.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.pigschool.pojo.XyzItemCat;
import xyz.pigschool.pojo.XyzItemCatExample;

public interface XyzItemCatMapper {
    int countByExample(XyzItemCatExample example);

    int deleteByExample(XyzItemCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XyzItemCat record);

    int insertSelective(XyzItemCat record);

    List<XyzItemCat> selectByExample(XyzItemCatExample example);

    XyzItemCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XyzItemCat record, @Param("example") XyzItemCatExample example);

    int updateByExample(@Param("record") XyzItemCat record, @Param("example") XyzItemCatExample example);

    int updateByPrimaryKeySelective(XyzItemCat record);

    int updateByPrimaryKey(XyzItemCat record);
}