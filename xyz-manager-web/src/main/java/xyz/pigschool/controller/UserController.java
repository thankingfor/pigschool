package xyz.pigschool.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.manager.pojo.XyzManagerUser;
import xyz.pigschool.service.ManagerUserService;

@Controller
public class UserController {
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ManagerUserService userService;
	
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
}
