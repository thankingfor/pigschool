package xyz.pigschool.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.content.service.ContentService;
import xyz.pigschool.pojo.XyzContent;

/**
 * 内容管理Controller
 * <p>Title: ItemCatController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class ContentController {

	private final static Logger logger = LoggerFactory.getLogger(ContentController.class);
	
	private Map<String,Object> map = new HashMap<String,Object>();
	
	@Autowired
	private ContentService contentService;
	
	/**
	 * 查询这个节点的所有数据
	 * @param parentId 父节点
	 * @return
	 */
	@RequestMapping("/content/list")
	@ResponseBody
	public Map<String,Object> getContentList(@RequestParam(name="page",defaultValue="1")int page,
			@RequestParam(name="rows",defaultValue="10")int rows,
			@RequestParam(name="param",defaultValue="")String param) {
		map.clear();
		//调用服务查询节点列表
		PageInfo<XyzContent> pageInfo = (PageInfo<XyzContent>) contentService.getContentlist(page, rows,param).getData();
		map.put("rows", pageInfo.getList());
		map.put("total", pageInfo.getTotal());
		return map;
	}
	
	/**
	 * 添加节点
	 * @param parentId 父节点id
	 * @param name 新节点的名字
	 * @return
	 */
	@RequestMapping("/content/insert")
	@ResponseBody
	public XYZResult getContentInsert(XyzContent content) {
		contentService.insert(content);
		return XYZResult.ok();
	}
	
	
	/**
	 * 删除分类节点
	 * @param id 要删除的id
 	 * @return
	 */
	@RequestMapping("/content/del")
	@ResponseBody
	public XYZResult getContentDel(@RequestParam(name="ids", defaultValue="0")Long[] ids) {
		XYZResult result = contentService.del(ids);
		return result;
	}
}
