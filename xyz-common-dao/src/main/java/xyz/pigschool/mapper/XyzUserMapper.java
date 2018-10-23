package xyz.pigschool.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.pigschool.pojo.XyzUser;
import xyz.pigschool.pojo.XyzUserExample;

public interface XyzUserMapper {
    int countByExample(XyzUserExample example);

    int deleteByExample(XyzUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XyzUser record);

    int insertSelective(XyzUser record);

    List<XyzUser> selectByExample(XyzUserExample example);

    XyzUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XyzUser record, @Param("example") XyzUserExample example);

    int updateByExample(@Param("record") XyzUser record, @Param("example") XyzUserExample example);

    int updateByPrimaryKeySelective(XyzUser record);

    int updateByPrimaryKey(XyzUser record);
}