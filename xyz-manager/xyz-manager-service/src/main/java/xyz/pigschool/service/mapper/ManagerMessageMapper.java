package xyz.pigschool.service.mapper;

import java.util.List;
import java.util.Map;

public interface ManagerMessageMapper {
	/**
	 * 	查询所有 返回map
	 * 	id uid name nick message created
	 * @return
	 */
	public List<Map<String,Object>> selectAll();
	
	/**
	 * 	查询所有 单一
	 * 	id uid name nick message created
	 */
	public Map<String,Object> selectById(int id);
}
