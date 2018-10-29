package xyz.pigschool.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		@RequestMapping("user/check/{param}/{type}")
		@ResponseBody
		public XYZResult checkUserData(@PathVariable String param,@PathVariable Integer type) {
			XYZResult result = userService.checkData(param, type);
			return result;
		}
		@RequestMapping(value="/user/register",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
		@ResponseBody
		public XYZResult register(XyzUser user) {
			XYZResult result = userService.register(user);
			return result;
		}
		
		@ResponseBody
		@RequestMapping("/get")
		public String run() {
			return "测试呀";	
		}
		
}
