package xyz.pigschool.secondMarket.service.mapper;

import java.util.List;

import xyz.pigschool.pojo.XyzItem;
import xyz.pigschool.pojo.XyzItemCat;

public interface XyzItemServiceMapper {
	
	/**
	 * 通过参数查找商品 找的都是state=1的商品
	 * @param Param
	 * @return
	 */
	List<XyzItem> selectByParam(String Param);
	
	/**
	 * 通过cid 查找类别
	 * @param cid
	 * @return
	 */
	XyzItemCat selectById(long cid);
}
