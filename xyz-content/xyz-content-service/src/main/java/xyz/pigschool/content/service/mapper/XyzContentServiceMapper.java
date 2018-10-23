package xyz.pigschool.content.service.mapper;

import java.util.List;

import xyz.pigschool.pojo.XyzContent;

public interface XyzContentServiceMapper {
	
	/**
	 *    通过参数条件查询
	 *   title title_desc sub_title content
	 *   这四个字段进行模糊查询
	 * @param Param
	 * @return
	 */
	List<XyzContent> selectByParam(String Param);
	
	/**
	 * 通过cid查询所有字段  sort字段进行逆序排序Desc
	 * @param cid
	 * @return
	 */
	List<XyzContent> selectByCid(long cid);
	
}
