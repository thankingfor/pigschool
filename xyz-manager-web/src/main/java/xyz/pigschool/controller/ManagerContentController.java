package xyz.pigschool.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.manager.pojo.ManagerContentVO;
import xyz.pigschool.manager.pojo.XyzManagerContent;
import xyz.pigschool.manager.pojo.XyzManagerUser;
import xyz.pigschool.service.ManagerContentService;

@Controller
public class ManagerContentController {

	private Logger logger = LoggerFactory.getLogger(ManagerContentController.class);
	
	@Autowired
	private ManagerContentService managerContentService;
	
	@RequestMapping("/manager/content/insert")
	@ResponseBody
	public XYZResult insert(XyzManagerContent content,HttpServletRequest request) {
		logger.debug(content.getTitle()+","+content.getContent()+","+content.getIsTop());
		XyzManagerUser user = (XyzManagerUser) request.getSession().getAttribute("user");
		logger.debug(content.getTitle()+","+content.getContent()+","+content.getIsTop()+","+user.getName());
		content.setUid(user.getId());
		XYZResult result= managerContentService.insert(content);
		return result;
	}
	
	
	@RequestMapping("/content")
	public String getList(@RequestParam(name="page",defaultValue="1")int page,
			@RequestParam(name="rows",defaultValue="8")int rows,
			@RequestParam(name="param",defaultValue="")String param,
			HttpServletRequest request,Model model) {
		logger.debug(page+","+rows+","+param);
		XYZResult result= managerContentService.getList(page, rows, param);
		PageInfo<ManagerContentVO> pageInfo = (PageInfo<ManagerContentVO>) result.getData();
		model.addAttribute("pageInfo", pageInfo);
		return "index/content";
	}
	
	@RequestMapping("/manager/content/upTop")
	@ResponseBody
	public XYZResult upTop(int id) {
		logger.debug("id="+id);
		XYZResult result= managerContentService.upTop(id);
		return result;
	}
	
	@RequestMapping("/manager/content/outTop")
	@ResponseBody
	public XYZResult outTop(int id) {
		logger.debug("id="+id);
		XYZResult result= managerContentService.outTop(id);
		return result;
	}
	
}
