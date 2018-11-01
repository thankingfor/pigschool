package xyz.pigschool.service;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.manager.pojo.XyzManagerMessage;
import xyz.pigschool.manager.pojo.XyzManagerTag;

public interface ManagerTagService {
	/**
	 * 	添加标签
	 * @param content
	 * @return
	 */
	XYZResult insert(XyzManagerTag tag);
	
	/**
	 * 	查询标签
	 *  	按照时间排序
	 * @param page
	 * @param rows
	 * @param param
	 * @return
	 */
	XYZResult getList(int page,int rows,String param);
	
	/**
	 * 按照id查询
	 * @param id
	 * @return
	 */
	XYZResult selectById(int id);
	
	/**
	 * 按照id删除
	 * @param id
	 * @return
	 */
	XYZResult delById(int id);
}
