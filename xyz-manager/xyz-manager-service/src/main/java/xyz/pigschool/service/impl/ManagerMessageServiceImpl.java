package xyz.pigschool.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.manager.pojo.XyzManagerMessage;
import xyz.pigschool.mapper.XyzManagerMessageMapper;
import xyz.pigschool.service.ManagerMessageService;
import xyz.pigschool.service.mapper.ManagerMessageMapper;

@Service
public class ManagerMessageServiceImpl implements ManagerMessageService {

	private Logger logger = LoggerFactory.getLogger(ManagerMessageServiceImpl.class);
	
	@Autowired
	private XyzManagerMessageMapper messageMapper;
	
	@Autowired
	private ManagerMessageMapper managerMessageMapper;
	/**
	 * 	添加消息
	 * @param content
	 * @return
	 */
	public XYZResult insert(XyzManagerMessage message) {
		if(messageMapper.insertSelective(message) > 0 ) {
			return XYZResult.ok();
		}
		return XYZResult.build(201, "添加失败");
	}

	/**
	 * 	查询消息 返回map集合
	 * @param page
	 * @param rows
	 * @param param
	 * @return
	 */
	public XYZResult getList(int page, int rows, String param) {
		PageHelper.startPage(page, rows);
		List<Map<String, Object>> list = managerMessageMapper.selectAll();
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>> (list);
		logger.debug(pageInfo.toString());
		if(pageInfo != null) {
			return XYZResult.ok(pageInfo);
		}
		return XYZResult.build(201, "查询失败");
	}

	/**
	 * 按照id查询
	 * @param id
	 * @return
	 */
	public XYZResult selectById(int id) {
		logger.debug("id="+id+";");
		Map<String, Object> map = managerMessageMapper.selectById(id);
		logger.debug(map.toString());
		return XYZResult.ok(map);
	}

	
}
