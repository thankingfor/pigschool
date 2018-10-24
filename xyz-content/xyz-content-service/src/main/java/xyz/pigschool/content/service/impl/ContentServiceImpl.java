package xyz.pigschool.content.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import xyz.pigschool.common.jedis.JedisClient;
import xyz.pigschool.common.utils.JsonUtils;
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
	
	@Autowired
	private JedisClient jedisclient;
	
	@Value("${Content_list}")
	private String Content_list;
	
	/**
	 * 	添加新内容
	 *	 做缓存
	 * @param content
	 * @return
	 * @author lyf
	 */
	public XYZResult insert(XyzContent content) {
		contentMapper.insertSelective(content);
		//缓存同步，删除缓存中的数据 
		jedisclient.hdel(Content_list, content.getCategoryId().toString());
		return XYZResult.ok();
	}

	/**
	 * 	删除内容
	 * 	做缓存
	 * @param id
	 * @return
	 * @author lyf
	 */
	public XYZResult del(Long[] id,long cid) {
		for (Long longId : id) {
			contentMapper.deleteByPrimaryKey(longId);
		}
		//缓存同步，删除缓存中的数据 
		jedisclient.hdel(Content_list, cid + "");
		return XYZResult.ok();
	}

	/**
	 *  	模糊查询内容 根据 标题 子标题 标题介绍 内容
	 *  	后台用到的方法，没做缓存
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
	 * 	添加缓存到redis 如果存在就在缓存中获取
	 *   	如果不存在就从数据库中查询到，再放入缓存中
	 * @param cid 分类id
	 * @return
	 * @author lyf
	 */
	public XYZResult getContentListByCid(long cid) {
		try {
			//查询缓存
			String json = jedisclient.hget(Content_list, cid + "");
			//如果缓存中有直接响应结果
			if(StringUtils.isNotBlank(json)) {
				List<XyzContent> list = JsonUtils.jsonToList(json, XyzContent.class);
				return XYZResult.ok(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//从数据库中获取数据
		List<XyzContent> list = contentServiceMapper.selectByCid(cid);
		if(list != null && list.size()>0) {
			try {
				//把结果添加到缓存
				jedisclient.hset(Content_list, cid+"", JsonUtils.objectToJson(list));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return XYZResult.ok(list);
		}
		return XYZResult.build(201, "list为空");
	}

}
