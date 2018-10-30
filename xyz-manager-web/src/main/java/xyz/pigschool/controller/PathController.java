package xyz.pigschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathController {
	
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	@RequestMapping("/content_add")
	public String content_add() {
		return "content/content_add";
	}
	@RequestMapping("/content_list")
	public String content_list() {
		return "content/content_list";
	}
	@RequestMapping("/content_cat")
	public String content_cat() {
		return "content/content_cat";
	}
	@RequestMapping("/item_list")
	public String item_list() {
		return "item/item_list";
	}
	@RequestMapping("/item_add")
	public String item_add() {
		return "item/item_add";
	}
	@RequestMapping("/item_cat")
	public String item_cat() {
		return "item/item_cat";
	}
	@RequestMapping("/tag")
	public String tag() {
		return "index/tag";
	}
	/*@RequestMapping("/content")
	public String content() {
		return "index/content";
	}*/
	@RequestMapping("/content_post")
	public String content_post() {
		return "index/content_post";
	}
	@RequestMapping("/user_list")
	public String user_list() {
		return "index/user_list";
	}
	@RequestMapping("/user_search")
	public String user_search() {
		return "index/user_search";
	}
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/{path}")
	public String show(@PathVariable String path) {
		return path;
	}
	@RequestMapping("/")
	public String show() {
		return "index";
	}
}
