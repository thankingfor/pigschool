package xyz.pigschool.service;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.manager.pojo.XyzManagerContent;

public interface ManagerContentService {
	/**
	 * 	添加content
	 * @param content
	 * @return
	 */
	XYZResult insert(XyzManagerContent content);
	
	/**
	 * 分页获取数据
	 * @param page 页数
	 * @param rows 行数
	 * @param param 查询条件
	 * @return
	 */
	XYZResult getList(int page,int rows,String param);
	
	/**
	 * 	置顶
	 * @param id 内容id
	 * @return
	 */
	XYZResult upTop(int id);
	
	/**
	 * 	取消置顶
	 * @param id 内容id
	 * @return
	 */
	XYZResult outTop(int id);
	
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	XYZResult getById(int id);
}
