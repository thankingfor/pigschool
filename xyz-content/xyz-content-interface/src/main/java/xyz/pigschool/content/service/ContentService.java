package xyz.pigschool.content.service;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.pojo.XyzContent;

public interface ContentService {
	/**
	 * 添加新内容
	 * @param content
	 * @return
	 */
	XYZResult insert(XyzContent content);
	/**
	 * 	删除内容
	 * 	做缓存,需要cid
	 * @param id
	 * @return
	 */
	XYZResult del(Long[] id,long cid);
	/**
	 * 根据关键字。得到内容列表
	 * @param page
	 * @param rows
	 * @param param
	 * @return
	 */
	XYZResult getContentlist(int page, int rows, String param);
	
	/**
	 * 根据cid判断 查询所有的content 然后封装成list
	 * list的name为  list+cid
	 * if这个cid是父节点  返回空
	 * @param cid 分类id
	 * @return
	 */
	XYZResult getContentListByCid(long cid);
}
