package xyz.pigschool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.pojo.XyzItemCat;
import xyz.pigschool.service.ItemCatService;

/**
 * 商品分类管理Controller
 * <p>Title: ItemCatController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class ItemCatController {

	private final static Logger logger = LoggerFactory.getLogger(ItemCatController.class);
	
	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 查询这个节点的所有数据
	 * @param parentId 父节点
	 * @return
	 */
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public XYZResult getItemCatList(
			@RequestParam(name="parentId", defaultValue="0")Long parentId) {
		//调用服务查询节点列表
		XYZResult result = itemCatService.getItemCatlist(parentId);
		return result;
		
	}
	
	/**
	 * 添加节点
	 * @param parentId 父节点id
	 * @param name 新节点的名字
	 * @return
	 */
	@RequestMapping("/item/cat/insert")
	@ResponseBody
	public XYZResult getItemCatInsert(
			@RequestParam(name="parentId", defaultValue="0")Long parentId,
			@RequestParam(name="name", defaultValue="0")String name) {
		logger.debug("----"+parentId+"--"+name);
		XyzItemCat itemCat = new XyzItemCat();
		itemCat.setParentId(parentId);
		itemCat.setName(name);
		XYZResult result = itemCatService.insert(itemCat);
		return result;
	}
	
	/**
	 * 修改节点
	 * @param id 要修改的id
	 * @param name 要改的名字
	 * @return
	 */
	@RequestMapping("/item/cat/update")
	@ResponseBody
	public XYZResult getItemCatUpdate(
			@RequestParam(name="id", defaultValue="0")Long id,
			@RequestParam(name="name", defaultValue="0")String name) {
		logger.debug("-----"+name);
		XyzItemCat itemCat = new XyzItemCat();
		itemCat.setName(name);
		itemCat.setId(id);
		XYZResult result = itemCatService.edit(itemCat);
		return result;
	}
	
	/**
	 * 删除分类节点
	 * @param id 要删除的id
 	 * @return
	 */
	@RequestMapping("/item/cat/del")
	@ResponseBody
	public XYZResult getItemCatDel(
			@RequestParam(name="parentId", defaultValue="0")Long parentId,
			@RequestParam(name="id", defaultValue="0")Long id) {
		logger.debug("----id"+id+"----parentId"+parentId);
		XYZResult result = itemCatService.del(parentId,id);
		return result;
	}
}
