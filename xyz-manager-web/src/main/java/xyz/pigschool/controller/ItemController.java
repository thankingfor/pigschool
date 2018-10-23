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
import xyz.pigschool.pojo.XyzItem;
import xyz.pigschool.secondMarket.service.ItemService;

/**
 * 商品管理Controller
 * <p>Title: ItemCatController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class ItemController {

	private final static Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	private Map<String,Object> map = new HashMap<String,Object>();
	
	@Autowired
	private ItemService itemService;
	
	/**
	 * 查询这个节点的所有数据
	 * @param parentId 父节点
	 * @return
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public Map<String,Object> getItemList(@RequestParam(name="page",defaultValue="1")int page,
			@RequestParam(name="rows",defaultValue="10")int rows,
			@RequestParam(name="param",defaultValue="")String param) {
		map.clear();
		//调用服务查询节点列表
		logger.info("我来到了控制层的getItemList方法，我的参数page="+page+"rows"+rows+"param="+param);
		PageInfo<XyzItem> pageInfo = (PageInfo<XyzItem>) itemService.getItemlist(page, rows,param).getData();
		logger.debug("rows="+pageInfo.getList()+"total"+pageInfo.getTotal());
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
	@RequestMapping("/item/insert")
	@ResponseBody
	public XYZResult getItemInsert(XyzItem item) {
		itemService.insert(item);
		return XYZResult.ok();
	}
	
	
	/**
	 * 删除分类节点
	 * @param id 要删除的id
 	 * @return
	 */
	@RequestMapping("/item/del")
	@ResponseBody
	public XYZResult getItemDel(@RequestParam(name="ids", defaultValue="0")Long[] ids) {
		XYZResult result = itemService.del(ids);
		return result;
	}
}
