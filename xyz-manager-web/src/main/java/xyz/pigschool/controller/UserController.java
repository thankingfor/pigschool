package xyz.pigschool.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
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
import xyz.pigschool.manager.pojo.XyzManagerUser;
import xyz.pigschool.service.ManagerUserService;

@Controller
public class UserController {
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ManagerUserService userService;
	
	@Autowired
	private ManagerUserService managerUserService;
	
	/**
	 * 	用户登录
	 * @param username
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author lyf
	 */
	@RequestMapping("/login/up")
	@ResponseBody
	public XYZResult login(String username,String password,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.debug("username="+username+"password="+password);
		XYZResult result = userService.login(username, password);
		if(result.getStatus() == 200) {
			XyzManagerUser user = (XyzManagerUser) result.getData();
			logger.debug("user:"+user.getName()+"::"+user.getId()+"::"+user.getNick());
			request.getSession().setAttribute("user", user);
			//ajax只是用来传输文本流 xml html js等
			//request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
			return result;
		}
		//request.setAttribute("msg", result.getMsg());
		//request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request, response);
		return result;
	}
	
	/**
	 * 	登出操作
	 * @param session
	 * @return
	 * @throws Exception
	 * @author lyf
	 */
	@RequestMapping("/loginout")
	@ResponseBody
	public XYZResult logout(HttpSession session) throws Exception{
		session.invalidate();
		return XYZResult.ok();
	}
	
	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping("/user_list")
	public String user_list(@RequestParam(name="page",defaultValue="1")int page,
			@RequestParam(name="rows",defaultValue="8")int rows,
			@RequestParam(name="param",defaultValue="")String param,
			HttpServletRequest request,Model model) {
		XYZResult result3 = managerUserService.getList(page, rows, param);
		PageInfo<XyzManagerUser> pageInfo3 = (PageInfo<XyzManagerUser>) result3.getData();
		model.addAttribute("UserInfo", pageInfo3);
		return "index/user_list";
	}
	
	/**
	 * 用户搜索
	 * @return
	 */
	@RequestMapping("/user_search")
	public String user_search() {
		return "index/user_search";
	}
	/**
	 * 用户密码修改
	 * @return
	 */
	@RequestMapping("/modPassword")
	public String modPassword() {
		return "user/modPassword";
	}
	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	@RequestMapping("/user/molPwd")
	@ResponseBody
	public XYZResult modPwd(String password,HttpServletRequest request) {
		XyzManagerUser user = (XyzManagerUser) request.getSession().getAttribute("user");
		user.setPassword(password);
		XYZResult result = managerUserService.molPwd(user);
		return result;
	}
}
