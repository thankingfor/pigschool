package xyz.pigschool.controller;

import java.util.Map;

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
import xyz.pigschool.manager.pojo.XyzManagerUser;
import xyz.pigschool.service.ManagerContentService;
import xyz.pigschool.service.ManagerMessageService;
import xyz.pigschool.service.ManagerUserService;

@Controller
public class PathController {
	
	private Logger logger = LoggerFactory.getLogger(PathController.class);
	
	@Autowired
	private ManagerContentService managerContentService;
	
	@Autowired
	private ManagerMessageService managerMessageService;
	
	@Autowired
	private ManagerUserService managerUserService;
	
	@Value("${MANAGER_INDEX_CONTENT_PAGE}")
	private Integer MANAGER_INDEX_CONTENT_PAGE;
	
	@Value("${MANAGER_INDEX_CONTENT_ROWS}")
	private Integer MANAGER_INDEX_CONTENT_ROWS;
	
	@Value("${MANAGER_INDEX_MESSAGE_PAGE}")
	private Integer MANAGER_INDEX_MESSAGE_PAGE;
	
	@Value("${MANAGER_INDEX_MESSAGE_ROWS}")
	private Integer MANAGER_INDEX_MESSAGE_ROWS;
	
	@Value("${MANAGER_INDEX_USER_PAGE}")
	private Integer MANAGER_INDEX_USER_PAGE;
	
	@Value("${MANAGER_INDEX_USER_ROWS}")
	private Integer MANAGER_INDEX_USER_ROWS;
	
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
	/*@RequestMapping("/content")
	public String content() {
		return "index/content";
	}*/
	@RequestMapping("/content_post")
	public String content_post() {
		return "index/content_post";
	}
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	@RequestMapping("/index")
	public String index(HttpServletRequest request,Model model) {
		//网站热帖
		XYZResult result= managerContentService.getList(MANAGER_INDEX_CONTENT_PAGE, MANAGER_INDEX_CONTENT_ROWS, "");
		PageInfo<ManagerContentVO> pageInfo = (PageInfo<ManagerContentVO>) result.getData();
		model.addAttribute("ContentInfo", pageInfo);
		//团队留言板
		XYZResult result2= managerMessageService.getList(MANAGER_INDEX_MESSAGE_PAGE, MANAGER_INDEX_MESSAGE_ROWS, "");
		PageInfo<Map<String, Object>> pageInfo2 = (PageInfo<Map<String, Object>>) result2.getData();
		model.addAttribute("MessageInfo", pageInfo2);
		//团队联系手册
		XYZResult result3 = managerUserService.getList(MANAGER_INDEX_USER_PAGE, MANAGER_INDEX_USER_ROWS, "");
		PageInfo<XyzManagerUser> pageInfo3 = (PageInfo<XyzManagerUser>) result3.getData();
		model.addAttribute("UserInfo", pageInfo3);
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
