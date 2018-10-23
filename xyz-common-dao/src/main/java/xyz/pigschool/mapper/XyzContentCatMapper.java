package xyz.pigschool.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.pigschool.pojo.XyzContentCat;
import xyz.pigschool.pojo.XyzContentCatExample;

public interface XyzContentCatMapper {
    int countByExample(XyzContentCatExample example);

    int deleteByExample(XyzContentCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XyzContentCat record);

    int insertSelective(XyzContentCat record);

    List<XyzContentCat> selectByExample(XyzContentCatExample example);

    XyzContentCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XyzContentCat record, @Param("example") XyzContentCatExample example);

    int updateByExample(@Param("record") XyzContentCat record, @Param("example") XyzContentCatExample example);

    int updateByPrimaryKeySelective(XyzContentCat record);

    int updateByPrimaryKey(XyzContentCat record);
}