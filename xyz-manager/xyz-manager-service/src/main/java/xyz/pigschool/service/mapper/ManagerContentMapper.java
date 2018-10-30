package xyz.pigschool.service.mapper;

import java.util.List;

import xyz.pigschool.manager.pojo.ManagerContentVO;

public interface ManagerContentMapper {

	/**
	 * 	找出is_top的最大值
	 * 
	 * @return
	 */
	public int getIstop();

	public int updateTopById(int id,int max);

	public List<ManagerContentVO> selectByParam(String string);
	
}
