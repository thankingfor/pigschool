package xyz.pigschool.controller;

import java.util.Map;

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
import xyz.pigschool.manager.pojo.XyzManagerTag;
import xyz.pigschool.service.ManagerTagService;

/**
 * 	标签管理
 * @author lyf
 */
@Controller
public class ManagerTagController {

	private Logger logger = LoggerFactory.getLogger(ManagerTagController.class);
	
	@Autowired
	private ManagerTagService managerTagService;
	
	/**
	 * 添加标签
	 * @param tag
	 * @return
	 */
	@RequestMapping("/manager/tag/insert")
	@ResponseBody
	public XYZResult insert(XyzManagerTag tag) {
		XYZResult result= managerTagService.insert(tag);
		return result;
	}
	
	/**
	 * 	标签列表
	 * @param page
	 * @param rows
	 * @param param
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/tag")
	public String getList(@RequestParam(name="page",defaultValue="1")int page,
			@RequestParam(name="rows",defaultValue="8")int rows,
			@RequestParam(name="param",defaultValue="")String param,
			HttpServletRequest request,Model model) {
		logger.debug(page+","+rows+","+param);
		XYZResult result= managerTagService.getList(page, rows, param);
		PageInfo<Map<String, Object>> pageInfo = (PageInfo<Map<String, Object>>) result.getData();
		model.addAttribute("pageInfo", pageInfo);
		return "index/tag";
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/manager/tag/del")
	@ResponseBody
	public XYZResult del(int id) {
		XYZResult result= managerTagService.delById(id);
		return result;
	}
}
