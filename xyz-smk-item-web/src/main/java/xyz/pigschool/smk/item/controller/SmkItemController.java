package xyz.pigschool.smk.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.pigschool.secondMarket.service.ItemService;
import xyz.pigschool.smk.pojo.ItemDec;

/**
 * 商品详情页面展示Controller
 * @version 1.0
 */
@Controller
public class SmkItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/smkitem/{itemId}")
	public String showItemInfo(@PathVariable Long itemId, Model model) {
		//调用服务取商品基本信息
		ItemDec itemDec = (ItemDec) itemService.getItemById(itemId).getData();
		model.addAttribute("itemDec", itemDec);
		//返回逻辑视图
		return "item";
	}
}
