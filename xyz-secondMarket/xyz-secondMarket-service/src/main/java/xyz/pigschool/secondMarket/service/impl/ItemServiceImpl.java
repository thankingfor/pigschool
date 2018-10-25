package xyz.pigschool.secondMarket.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import xyz.pigschool.common.utils.IDUtils;
import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.pojo.XyzItem;
import xyz.pigschool.secondMarket.service.ItemService;
import xyz.pigschool.secondMarket.service.mapper.XyzItemServiceMapper;

@Service
public class ItemServiceImpl implements ItemService{

	private final static Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	@Autowired
	private xyz.pigschool.mapper.XyzItemMapper itemMapper;
	
	@Autowired 
	private XyzItemServiceMapper itemServiceMapper;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	/**
	 * Resource 现根据id注入  没有再找类型
	 */
	@Resource
	private Destination topicDestination;
	
	@Resource
	private Destination itemDelDestination;
	
	/**
	 * 商品添加
	 * 自己设置 不自增
	 * @author lyf
	 */
	public XYZResult insert(XyzItem item) {
		//生成商品id
		final long itemId = IDUtils.genItemId();
		item.setId(itemId);
		//添加数据到数据库
		itemMapper.insertSelective(item);
		//发送商品添加消息
		jmsTemplate.send(topicDestination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(itemId + "");
				return textMessage;
			}
		});
		
		return XYZResult.ok();
	}

	/**
	 * 商品删除
	 * 同步索引库 mq操作
	 * @author lyf
	 */
	@Override
	public XYZResult del(Long[] id) {
		for (Long longId : id) {
			itemMapper.deleteByPrimaryKey(longId);
			//发送商品添加消息
			jmsTemplate.send(itemDelDestination, new MessageCreator() {
				
				@Override
				public Message createMessage(Session session) throws JMSException {
					TextMessage textMessage = session.createTextMessage(longId + "");
					return textMessage;
				}
			});
		}
		return XYZResult.ok();
	}

	/**
	 *  模糊查询 查询商品 根据卖点 标题 和 地址
	 * @param param 查询的条件
	 * @author lyf
	 */
	@Override
	public XYZResult getItemlist(int page,int rows,String param) {
		logger.info("我来到了业务层的getItemlist方法，我的参数page="+page+"rows"+rows+"param="+param);
		PageHelper.startPage(page, rows);
		List<XyzItem> list = itemServiceMapper.selectByParam("%"+param+"%");
		PageInfo<XyzItem> pageInfo = new PageInfo<XyzItem> (list);
		logger.debug("我来到了业务层的getItemlist方法，我的参数rows="+pageInfo.getList()+"total"+pageInfo.getTotal());
		return XYZResult.ok(pageInfo);
	}

}
