package xyz.pigschool.service.mapper;

import java.util.List;

import xyz.pigschool.pojo.XyzItem;

public interface XyzItemServiceMapper {
	
	List<XyzItem> selectByParam(String Param);
}
