package xyz.pigschool.sso.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.mapper.XyzUserMapper;
import xyz.pigschool.pojo.XyzUser;
import xyz.pigschool.pojo.XyzUserExample;
import xyz.pigschool.pojo.XyzUserExample.Criteria;
import xyz.pigschool.sso.service.UserService;

/**
 * 用户处理Service
 * @author zk
 * @da2018年10月25日
 */

@Service
public class UserServiceImpl implements UserService {
		
	@Autowired
	private XyzUserMapper userMapper;
	
	@Override
	public XYZResult checkData(String data, int type) {
		
		XyzUserExample example=new XyzUserExample();
		Criteria criteria = example.createCriteria();
		//设置查询条件
		//1.判断用户名是否可用
		if(type==1) {
			criteria.andUsernameEqualTo(data);
			//2.判断手机号是否可用
		} else if(type==2){
			criteria.andPhoneEqualTo(data);
			//3.判断email是否可用
		}else if(type==3){
			criteria.andEmailEqualTo(data);
		}else {
			XYZResult.build(400, "非法数据!");
		}
		List<XyzUser> list = userMapper.selectByExample(example);
		if(list !=null && list.size()>0) {
			//查到数据,返回false
			return XYZResult.ok(false);
		}
		return XYZResult.ok(true);
	}

	@Override
	public XYZResult register(XyzUser user) {
       //判断用户名是否为空
		if(StringUtils.isBlank(user.getUsername())) {
    	   return XYZResult.build(400, "用户名不能为空");
       }
		//判断用户名是否重复
		XYZResult xyzResultN = checkData(user.getUsername(), 1);
		if(!(boolean)xyzResultN.getData()) {
			return XYZResult.build(400,"用户名已存在");
		}
		//判断密码是否为空
		if(StringUtils.isBlank(user.getPassword())) {
			return XYZResult.build(400, "密码不能为空");
		}
		//判断手机号是否为空
		if(StringUtils.isBlank(user.getPhone())) {
			return XYZResult.build(400, "手机号不能为空");
		}
		//判断手机号是否重复
		XYZResult xyzResultP = checkData(user.getPhone(), 2);
		if(!(boolean) xyzResultP.getData()) {
			return XYZResult.build(400, "手机号已存在");
		}
		//判断email是否为空
		if(StringUtils.isBlank(user.getEmail())) {
			return XYZResult.build(400, "email不能为空");
		}
		//判断email是否重复
		XYZResult xyzResultE = checkData(user.getEmail(), 3);
		if(!(boolean) xyzResultE.getData()) {
			return XYZResult.build(400, "email已存在");
		}
		//补全pojo
		user.setCreated(new Date());
		user.setUpdated(new Date());
		//密码进行md5加密
		String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass);
		//插入数据
		userMapper.insert(user);
		return XYZResult.ok();
	}

}
