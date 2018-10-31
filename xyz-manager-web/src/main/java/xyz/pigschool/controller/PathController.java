package xyz.pigschool.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.manager.pojo.ManagerContentVO;
import xyz.pigschool.service.ManagerContentService;

@Controller
public class PathController {
	
	private Logger logger = LoggerFactory.getLogger(PathController.class);
	
	@Autowired
	private ManagerContentService managerContentService;
	
	@Value("${MANAGER_INDEX_CONTENT_PAGE}")
	private Integer MANAGER_INDEX_CONTENT_PAGE;
	
	@Value("${MANAGER_INDEX_CONTENT_ROWS}")
	private Integer MANAGER_INDEX_CONTENT_ROWS;
	
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
	public String index(HttpServletRequest request,Model model) {
		XYZResult result= managerContentService.getList(MANAGER_INDEX_CONTENT_PAGE, MANAGER_INDEX_CONTENT_ROWS, "");
		PageInfo<ManagerContentVO> pageInfo = (PageInfo<ManagerContentVO>) result.getData();
		model.addAttribute("ContentInfo", pageInfo);
		return "index";
	}
	/*@RequestMapping("/{path}")
	public String show(@PathVariable String path) {
		return path;
	}*/
	@RequestMapping("/")
	public String show() {
		return "index";
	}
}
