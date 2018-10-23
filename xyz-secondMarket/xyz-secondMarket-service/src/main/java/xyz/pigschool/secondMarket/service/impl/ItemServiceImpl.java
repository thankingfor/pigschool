package xyz.pigschool.secondMarket.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	
	/**
	 * 商品添加
	 */
	public XYZResult insert(XyzItem item) {
		itemMapper.insertSelective(item);
		return null;
	}

	@Override
	public XYZResult del(Long[] id) {
		for (Long longId : id) {
			itemMapper.deleteByPrimaryKey(longId);
		}
		return XYZResult.ok();
	}

	/**
	 *  模糊查询 查询商品 根据卖点 标题 和 地址
	 * @param param 查询的条件
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
