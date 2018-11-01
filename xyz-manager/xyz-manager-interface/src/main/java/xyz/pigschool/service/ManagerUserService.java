package xyz.pigschool.service;

import xyz.pigschool.common.utils.XYZResult;

public interface ManagerUserService {
	/**
	 * 	登录
	 * @param username
	 * @param password
	 * @return
	 */
	XYZResult login(String username,String password);
	/**
	 * 	查询消息
	 *  	按照时间排序
	 * @param page
	 * @param rows
	 * @param param
	 * @return
	 */
	XYZResult getList(int page,int rows,String param);
}
