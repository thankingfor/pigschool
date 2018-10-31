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
import xyz.pigschool.manager.pojo.ManagerContentVO;
import xyz.pigschool.manager.pojo.XyzManagerContent;
import xyz.pigschool.manager.pojo.XyzManagerMessage;
import xyz.pigschool.manager.pojo.XyzManagerUser;
import xyz.pigschool.service.ManagerContentService;
import xyz.pigschool.service.ManagerMessageService;

/**
 * 	留言消息
 * @author lyf
 */
@Controller
public class ManagerMessageController {

	private Logger logger = LoggerFactory.getLogger(ManagerMessageController.class);
	
	@Autowired
	private ManagerMessageService managerMessageService;
	
	/**
	 * 	消息添加页面
	 * @param message
	 * @param request
	 * @return
	 */
	@RequestMapping("/manager/message/insert")
	@ResponseBody
	public XYZResult insert(XyzManagerMessage message,HttpServletRequest request) {
		XyzManagerUser user = (XyzManagerUser) request.getSession().getAttribute("user");
		message.setUid(user.getId());
		XYZResult result= managerMessageService.insert(message);
		return result;
	}
	
	/**
	 * 	消息详情页面
	 * 	id uid name nick message created
	 * @param page
	 * @param rows
	 * @param param
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/message")
	public String getList(@RequestParam(name="page",defaultValue="1")int page,
			@RequestParam(name="rows",defaultValue="8")int rows,
			@RequestParam(name="param",defaultValue="")String param,
			HttpServletRequest request,Model model) {
		logger.debug(page+","+rows+","+param);
		XYZResult result= managerMessageService.getList(page, rows, param);
		PageInfo<Map<String, Object>> pageInfo = (PageInfo<Map<String, Object>>) result.getData();
		model.addAttribute("pageInfo", pageInfo);
		return "index/messageShow";
	}
	
}
