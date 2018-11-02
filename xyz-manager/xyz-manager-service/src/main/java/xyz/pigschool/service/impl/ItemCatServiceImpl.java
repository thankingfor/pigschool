package xyz.pigschool.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.pigschool.common.pojo.TreeNode;
import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.mapper.XyzItemCatMapper;
import xyz.pigschool.pojo.XyzItemCat;
import xyz.pigschool.pojo.XyzItemCatExample;
import xyz.pigschool.pojo.XyzItemCatExample.Criteria;
import xyz.pigschool.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{

	private final static Logger logger = LoggerFactory.getLogger(ItemCatServiceImpl.class);
	//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	@Autowired
	private XyzItemCatMapper itemCatMapper;
	
	/**
	 * 通过id查询下面所有的TreeNode 状态。可选值:1(正常),0(删除)
	 */
	public XYZResult getItemCatlist(long parentId) {
		logger.info("我来到了 getItemCatlist");
		//根据parentId查询子节点列表
		XyzItemCatExample example = new XyzItemCatExample();
		Criteria criteria = example.createCriteria();
		//设置查询条件
		criteria.andParentIdEqualTo(parentId);
		criteria.andStateEqualTo(1);
		//执行查询
		List<XyzItemCat> list = itemCatMapper.selectByExample(example);
		//创建返回结果List
		List<TreeNode> resultList = new ArrayList<>();
		//把列表转换成EasyUITreeNode列表
		for (XyzItemCat itemCat : list) {
			String[] isParent = {""};
			TreeNode node = new TreeNode();
			//设置属性
			node.setId(itemCat.getId());
			node.setText(itemCat.getName());
			if(itemCat.getIsParent() == 1) {
				isParent[0] = "父节点";
			}else {
				isParent[0] = "子节点";
			}
			node.setTags(isParent);
			//添加到结果列表
			resultList.add(node);
		}
		//返回结果
		return XYZResult.ok(resultList);
	}

	/**
	 * 添加
	 */
	public XYZResult insert(XyzItemCat itemCat) {
		//查到通过父节点，如果父节点为自己点，把他变为父节点
		XyzItemCat parent_itemCat = itemCatMapper.selectByPrimaryKey(itemCat.getParentId());
		parent_itemCat.setIsParent(1);
		//更新父节点
		itemCatMapper.updateByPrimaryKeySelective(parent_itemCat);
		//添加新节点
		itemCatMapper.insertSelective(itemCat);
		return XYZResult.ok();
	}

	/**
	 * 修改
	 */
	public XYZResult edit(XyzItemCat itemCat) {
		itemCat.setUpdated(new Date());
		logger.info("---itemCat"+itemCat);
		itemCatMapper.updateByPrimaryKeySelective(itemCat);
		return XYZResult.ok();
	}

	/**
	 * 删除 可选值:1(正常),0(删除)
	 */ 
	@SuppressWarnings("unchecked")
	public XYZResult del(long parentId,long id) {
		logger.info("---parentId"+parentId);
		XyzItemCat itemCat1 = new XyzItemCat();
		itemCat1.setId(id);
		itemCat1.setState(0);
		itemCatMapper.updateByPrimaryKeySelective(itemCat1);
		//itemCatMapper.deleteByPrimaryKey(id); 不能直接删除
		//如果删除的id是唯一的节点，就让父节点变为子节点
		List<TreeNode> resultList = (List<TreeNode>) getItemCatlist(parentId).getData();
		logger.info("---resultList.size()"+resultList.size());
		if(resultList.size() <= 0) {
			XyzItemCat itemCat = new XyzItemCat();
			itemCat.setId(parentId);
			itemCat.setIsParent(0);
			logger.info("---itemCat"+itemCat);
			itemCatMapper.updateByPrimaryKeySelective(itemCat);
		}
		return XYZResult.ok();
	}

}
