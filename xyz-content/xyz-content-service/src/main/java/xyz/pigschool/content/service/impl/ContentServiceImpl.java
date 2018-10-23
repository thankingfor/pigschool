package xyz.pigschool.content.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.content.service.ContentService;
import xyz.pigschool.content.service.mapper.XyzContentServiceMapper;
import xyz.pigschool.mapper.XyzContentMapper;
import xyz.pigschool.pojo.XyzContent;

@Service
public class ContentServiceImpl implements ContentService{

	private final static Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class);
	
	@Autowired
	private XyzContentMapper contentMapper;
	
	@Autowired
	private XyzContentServiceMapper contentServiceMapper;
	
	/**
	 * 添加新内容
	 * @param content
	 * @return
	 * @author lyf
	 */
	public XYZResult insert(XyzContent content) {
		contentMapper.insertSelective(content);
		return XYZResult.ok();
	}

	/**
	 * 删除内容
	 * @param id
	 * @return
	 * @author lyf
	 */
	public XYZResult del(Long[] id) {
		for (Long longId : id) {
			contentMapper.deleteByPrimaryKey(longId);
		}
		return XYZResult.ok();
	}

	/**
	 *  模糊查询内容 根据 标题 子标题 标题介绍 内容
	 * @param param 查询的条件
	 * @author lyf
	 */
	public XYZResult getContentlist(int page,int rows,String param) {
		logger.info("我来到了业务层的getItemlist方法，我的参数page="+page+"rows"+rows+"param="+param);
		PageHelper.startPage(page, rows);
		List<XyzContent> list = contentServiceMapper.selectByParam("%"+param+"%");
		PageInfo<XyzContent> pageInfo = new PageInfo<XyzContent> (list);
		return XYZResult.ok(pageInfo);
	}

	/**
	 * 根据cid判断 查询所有的content 然后封装成list
	 * list的name为  list+cid
	 * if这个cid是父节点  返回空
	 * 	按照sort字段排序数越大 越靠前
	 * @param cid 分类id
	 * @return
	 * @author lyf
	 */
	public XYZResult getContentListByCid(long cid) {
		List<XyzContent> list = contentServiceMapper.selectByCid(cid);
		if(list != null && list.size()>0) {
			return XYZResult.ok(list);
		}
		return XYZResult.build(201, "list为空");
	}

}
