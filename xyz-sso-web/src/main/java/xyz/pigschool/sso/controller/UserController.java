package xyz.pigschool.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.pigschool.common.utils.CookieUtils;
import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.pojo.XyzUser;
import xyz.pigschool.sso.service.UserService;

/**
 * 用户处理Controller
 * @author zk
 * @da2018年10月25日
 */
@Controller
public class UserController {

		@Autowired
		private UserService userService;
		@Value("${TOKEN_KEY}")
		private String TOKEN_KEY;
		
		@RequestMapping("user/check/{param}/{type}")
		@ResponseBody
		public XYZResult checkUserData(@PathVariable String param,@PathVariable Integer type) {
			XYZResult result = userService.checkData(param, type);
			return result;
		}
		@RequestMapping(value="/user/register",method=RequestMethod.POST)
		@ResponseBody
		public XYZResult register(XyzUser user) {
			XYZResult result = userService.register(user);
			System.out.println(result.toString());
			return result;
		}
		
		@RequestMapping(value="/user/login",method=RequestMethod.POST)
		@ResponseBody
		public XYZResult login(String phone,String password,HttpServletResponse response,HttpServletRequest request) {
			XYZResult result = userService.login(phone, password);
			//把token写入cookie
			CookieUtils.setCookie(request, response, TOKEN_KEY, result.getData().toString());
			return result;
			
		}
		
}
