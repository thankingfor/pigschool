package xyz.pigschool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.content.service.ContentCatService;
import xyz.pigschool.pojo.XyzContentCat;

/**
 * 内容分类管理Controller
 * <p>Title: ItemCatController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class ContentCatController {

	private final static Logger logger = LoggerFactory.getLogger(ContentCatController.class);
	
	@Autowired
	private ContentCatService contentCatService;
	
	/**
	 * 查询这个节点的所有数据
	 * @param parentId 父节点
	 * @return
	 */
	@RequestMapping("/content/cat/list")
	@ResponseBody
	public XYZResult getContentCatList(
			@RequestParam(name="parentId", defaultValue="0")Long parentId) {
		//调用服务查询节点列表
		XYZResult result = contentCatService.getItemCatlist(parentId);
		return result;
		
	}
	
	/**
	 * 添加节点
	 * @param parentId 父节点id
	 * @param name 新节点的名字
	 * @return
	 */
	@RequestMapping("/content/cat/insert")
	@ResponseBody
	public XYZResult getContentCatInsert(
			@RequestParam(name="parentId", defaultValue="0")Long parentId,
			@RequestParam(name="name", defaultValue="0")String name) {
		logger.debug("----"+parentId+"--"+name);
		XyzContentCat contentCat = new XyzContentCat();
		contentCat.setParentId(parentId);
		contentCat.setName(name);
		XYZResult result = contentCatService.insert(contentCat);
		return result;
	}
	
	/**
	 * 修改节点
	 * @param id 要修改的id
	 * @param name 要改的名字
	 * @return
	 */
	@RequestMapping("/content/cat/update")
	@ResponseBody
	public XYZResult getContentCatUpdate(
			@RequestParam(name="id", defaultValue="0")Long id,
			@RequestParam(name="name", defaultValue="0")String name) {
		logger.debug("-----"+name);
		XyzContentCat contentCat = new XyzContentCat();
		contentCat.setName(name);
		contentCat.setId(id);
		XYZResult result = contentCatService.edit(contentCat);
		return result;
	}
	
	/**
	 * 删除分类节点
	 * @param id 要删除的id
 	 * @return
	 */
	@RequestMapping("/content/cat/del")
	@ResponseBody
	public XYZResult getContentCatDel(
			@RequestParam(name="parentId", defaultValue="0")Long parentId,
			@RequestParam(name="id", defaultValue="0")Long id) {
		logger.debug("----id"+id+"----parentId"+parentId);
		XYZResult result = contentCatService.del(parentId,id);
		return result;
	}
}
