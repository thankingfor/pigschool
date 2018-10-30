package xyz.pigschool.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.manager.pojo.XyzManagerUser;
import xyz.pigschool.manager.pojo.XyzManagerUserExample;
import xyz.pigschool.manager.pojo.XyzManagerUserExample.Criteria;
import xyz.pigschool.mapper.XyzManagerUserMapper;
import xyz.pigschool.service.ManagerUserService;

@Service
public class ManagerUserServiceImpl implements ManagerUserService{

	private final static Logger logger = LoggerFactory.getLogger(ManagerUserServiceImpl.class);
	
	@Autowired
	private XyzManagerUserMapper userMapper;
	
	public XYZResult login(String username, String password) {
		logger.debug("username="+username+"password="+password);
		XyzManagerUserExample example = new XyzManagerUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<XyzManagerUser> list = userMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			//返回登录失败
			return XYZResult.build(400, "用户名或密码错误");
		}
		//取用户信息
		XyzManagerUser user = list.get(0);
		if(user.getPassword().equals(password)) {
			logger.debug("user:"+user.getName()+"::"+user.getId()+"::"+user.getNick());
			return XYZResult.ok(user);
		}
		return XYZResult.build(400, "用户名或密码错误");
	}

}