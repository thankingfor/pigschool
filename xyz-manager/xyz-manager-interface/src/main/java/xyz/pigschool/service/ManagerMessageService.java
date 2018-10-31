package xyz.pigschool.service;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.manager.pojo.XyzManagerMessage;

public interface ManagerMessageService {
	/**
	 * 	添加消息
	 * @param content
	 * @return
	 */
	XYZResult insert(XyzManagerMessage message);
	
	/**
	 * 	查询消息
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
}
