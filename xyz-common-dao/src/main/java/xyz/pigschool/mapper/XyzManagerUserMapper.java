package xyz.pigschool.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.pigschool.manager.pojo.XyzManagerUser;
import xyz.pigschool.manager.pojo.XyzManagerUserExample;

public interface XyzManagerUserMapper {
    int countByExample(XyzManagerUserExample example);

    int deleteByExample(XyzManagerUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XyzManagerUser record);

    int insertSelective(XyzManagerUser record);

    List<XyzManagerUser> selectByExample(XyzManagerUserExample example);

    XyzManagerUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XyzManagerUser record, @Param("example") XyzManagerUserExample example);

    int updateByExample(@Param("record") XyzManagerUser record, @Param("example") XyzManagerUserExample example);

    int updateByPrimaryKeySelective(XyzManagerUser record);

    int updateByPrimaryKey(XyzManagerUser record);
}