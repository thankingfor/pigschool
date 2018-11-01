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
import xyz.pigschool.manager.pojo.XyzManagerTag;
import xyz.pigschool.manager.pojo.XyzManagerTagExample;
import xyz.pigschool.manager.pojo.XyzManagerTagExample.Criteria;
import xyz.pigschool.mapper.XyzManagerMessageMapper;
import xyz.pigschool.mapper.XyzManagerTagMapper;
import xyz.pigschool.service.ManagerMessageService;
import xyz.pigschool.service.ManagerTagService;
import xyz.pigschool.service.mapper.ManagerMessageMapper;

@Service
public class ManagerTagServiceImpl implements ManagerTagService {

	private Logger logger = LoggerFactory.getLogger(ManagerTagServiceImpl.class);
	
	@Autowired
	private XyzManagerTagMapper tagMapper;
	
	/**
	 * 	添加消息
	 * @param tag
	 * @return
	 */
	public XYZResult insert(XyzManagerTag tag) {
		if(tagMapper.insertSelective(tag) > 0 ) {
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
		XyzManagerTagExample example = new XyzManagerTagExample();
		Criteria criteria = example.createCriteria();
		criteria.andContentLike("%"+param+"%");
		example.setOrderByClause("created DESC");
		List<XyzManagerTag> list = tagMapper.selectByExample(example);
		PageInfo<XyzManagerTag> pageInfo = new PageInfo<XyzManagerTag> (list);
		logger.debug(pageInfo.toString());
		if(!pageInfo.getList().isEmpty()) {
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
		XyzManagerTag tag = tagMapper.selectByPrimaryKey(id);
		return XYZResult.ok(tag);
	}

	/**
	 * 按照id删除
	 */
	public XYZResult delById(int id) {
		logger.debug("id="+id+";");
		if(tagMapper.deleteByPrimaryKey(id) > 0) {
			return XYZResult.ok();
		}
		return XYZResult.build(201, "删除失败");
	}

	
}
