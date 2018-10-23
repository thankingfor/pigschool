package xyz.pigschool.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.pigschool.common.pojo.TreeNode;
import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.content.service.ContentCatService;
import xyz.pigschool.mapper.XyzContentCatMapper;
import xyz.pigschool.pojo.XyzContentCat;
import xyz.pigschool.pojo.XyzContentCatExample;
import xyz.pigschool.pojo.XyzContentCatExample.Criteria;

@Service
public class ContentCatServiceImpl implements ContentCatService{

	@Autowired
	private XyzContentCatMapper contentCatMapper;
	
	/**
	 * 根据夫id查询子节点
	 * @param parentId 父id
	 * @return XYZResult类
	 */
	public XYZResult getItemCatlist(long parentId) {
		XyzContentCatExample example = new XyzContentCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<XyzContentCat> list = contentCatMapper.selectByExample(example);
		List<TreeNode> resultList = new ArrayList<>();
		for (XyzContentCat contentCat : list) {
			String[] isParent = {""};
			TreeNode node = new TreeNode();
			//设置属性
			node.setId(contentCat.getId());
			node.setText(contentCat.getName());
			if(contentCat.getIsParent() == 1) {
				isParent[0] = "父节点";
			}else {
				isParent[0] = "子节点";
			}
			node.setTags(isParent);
			resultList.add(node);
		}
		return XYZResult.ok(resultList);
	}

	/**
	 * 插入菜单节点
	 * @param contentCat
	 * @return XYZResult类
	 */
	public XYZResult insert(XyzContentCat contentCat) {
		//查到通过父节点，如果父节点为自己点，把他变为父节点
		XyzContentCat parent_contentCat = contentCatMapper.selectByPrimaryKey(contentCat.getParentId());
		parent_contentCat.setIsParent(1);
		//更新父节点
		contentCatMapper.updateByPrimaryKeySelective(parent_contentCat);
		//添加新节点
		contentCatMapper.insertSelective(contentCat);
		return XYZResult.ok();
	}

	/**
	 * 修改菜单节点
	 * @param contentCat
	 * @return XYZResult类
	 */
	public XYZResult edit(XyzContentCat contentCat) {
		contentCat.setUpdated(new Date());
		contentCatMapper.updateByPrimaryKeySelective(contentCat);
		return XYZResult.ok();
	}

	/**
	 * 删除节点 修改父类的字段
	 * @param parentId
	 * @param id
	 * @return
	 */
	public XYZResult del(long parentId, long id) {
		//删除节点
		contentCatMapper.deleteByPrimaryKey(id);
		//如果父节点就这一个子节点，就变为子节点
		List<TreeNode> resultList = (List<TreeNode>) getItemCatlist(parentId).getData();
		if(resultList.size() <= 0) {
			XyzContentCat parent_contentCat = new XyzContentCat();
			parent_contentCat.setId(parentId);
			parent_contentCat.setIsParent(0);
			contentCatMapper.updateByPrimaryKeySelective(parent_contentCat);
		}
		return XYZResult.ok();
	}

}
