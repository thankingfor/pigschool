package xyz.pigschool.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	
	/**
	 * 	登录
	 * @param username
	 * @param password
	 * @return
	 */
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
		String md5Pass = DigestUtils.md5DigestAsHex(password.getBytes());
		if(user.getPassword().equals(md5Pass)) {
			return XYZResult.ok(user);
		}
		return XYZResult.build(400, "用户名或密码错误");
	}

	/**
	 * 	查询消息
	 *  	按照时间排序
	 * @param page
	 * @param rows
	 * @param param
	 * @return
	 */
	public XYZResult getList(int page, int rows, String param) {
		PageHelper.startPage(page, rows);
		XyzManagerUserExample example = new XyzManagerUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%"+param+"%");
		List<XyzManagerUser> list = userMapper.selectByExample(example);
		PageInfo<XyzManagerUser> pageInfo = new PageInfo<XyzManagerUser>(list);
		return XYZResult.ok(pageInfo);
	}

	/**
	 * 修改密码
	 */
	public XYZResult molPwd(XyzManagerUser user) {
		user.setUpdated(new Date());
		//加密
		String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass);
		if(userMapper.updateByPrimaryKeySelective(user) > 0) {
			return XYZResult.ok();
		}
		return XYZResult.build(201, "修改失败");
	}

}