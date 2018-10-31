package xyz.pigschool.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
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
			return result;
		}
		
		@RequestMapping(value="/user/login",method=RequestMethod.POST)
		@ResponseBody
		public XYZResult login(String phone,String password,HttpServletResponse response,HttpServletRequest request) {
			XYZResult result = userService.login(phone, password);
			//如果登录成功把token写入cookie
			if(result.getStatus()==200) {
			CookieUtils.setCookie(request, response, TOKEN_KEY, result.getData().toString());
			}
			return result;
		}
		@RequestMapping(value="/user/token/{token}",method=RequestMethod.GET)
		@ResponseBody
		public Object getUserByToken(@PathVariable String token,String callback) {
			XYZResult result = userService.getUserByToken(token);
			//判断是否为jsonp请求
			if(StringUtils.isBlank(callback)) {
				MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(result);
				//设置回调方法
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}
			return result;
		}
		@RequestMapping(value="/user/logout/{token}",method=RequestMethod.GET)
		@ResponseBody
		public XYZResult logout(@PathVariable String token) {
			XYZResult result = userService.logout(token);
			return result;
		}
}
