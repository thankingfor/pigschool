package xyz.pigschool.sso.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import xyz.pigschool.common.jedis.JedisClient;
import xyz.pigschool.common.utils.JsonUtils;
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
    @Autowired
    private JedisClient jedisClient;
    @Value("${USER_SESSION}")
    private String USER_SESSION;
    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;
    @Value("${XYZ_MANAGER_TOTAL}")
    private String XYZ_MANAGER_TOTAL;
    @Value("${REGIST_COUNT_INCR}")
    private Long REGIST_COUNT_INCR;
    @Value("${LOGIN}")
    private String LOGIN;
    @Value("${REGISTER}")
    private String REGISTER;

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
        //获取当前的日期
        SimpleDateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd");
        String date =dateFormat.format(new Date());
        //查询当日是否有注册
        String hget = jedisClient.hget(XYZ_MANAGER_TOTAL, REGISTER+":"+date );
        if(StringUtils.isBlank(hget)) {
        	//当日首次注册redis
        	jedisClient.hset(XYZ_MANAGER_TOTAL, REGISTER+":"+date , 1+"");
        }else {//不是首次次数加一
        	jedisClient.hincrby(XYZ_MANAGER_TOTAL,REGISTER+":"+date ,REGIST_COUNT_INCR);
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

    @Override
    public XYZResult login(String phone, String password) {
        //判断手机号是否为空
        if(StringUtils.isBlank(phone)) {
            return XYZResult.build(400, "手机号不能为空");
        }
        //判断密码是否为空
        if(StringUtils.isBlank(password)) {
            return XYZResult.build(400, "密码不能为空");
        }
        //判断用户名和密码是否正确
        XyzUserExample example=new XyzUserExample();
        Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);

        List<XyzUser> list = userMapper.selectByExample(example);
        if(list.size()==0||list==null) {
            //返回登录失败
            return XYZResult.build(400,"用户名或密码不正确");
        }
        XyzUser user = list.get(0);
        //密码要进行md5加密后校验
        if(!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())){
            //返回登录失败
            return XYZResult.build(400,"用户名或密码不正确");
        }
        //获取当前的日期
        SimpleDateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd");
        String date =dateFormat.format(new Date());
        //查询当日是否有登录
        String hget = jedisClient.hget(XYZ_MANAGER_TOTAL, LOGIN+":"+date );
        if(StringUtils.isBlank(hget)) {
        	//当日首次登录存入redis
        	jedisClient.hset(XYZ_MANAGER_TOTAL, LOGIN+":"+date , 1+"");
        }else {//不是首次登录次数加一
        	jedisClient.hincrby(XYZ_MANAGER_TOTAL,LOGIN+":"+date ,REGIST_COUNT_INCR);
        }
        //生成token,使用uuid
        String token=UUID.randomUUID().toString();
        //清空密码
        user.setPassword(null);
        String json = JsonUtils.objectToJson(user);
        //那用户信息保存到redis,key就是token,value就是用户信息
        jedisClient.set(USER_SESSION+":"+token, JsonUtils.objectToJson(user));
        //设置key的过期时间
        jedisClient.expire(USER_SESSION+":"+token, SESSION_EXPIRE);
        //返回登录成功,其中要把token返回
        return XYZResult.ok(token);
    }

	@Override
	public XYZResult getUserByToken(String token) {
		String json = jedisClient.get(USER_SESSION+":"+token);
		if(StringUtils.isBlank(json)) {
			return XYZResult.build(400, "用户登录已经过期");
		}
		//重置session的过期时间
		jedisClient.expire(USER_SESSION+":"+token, SESSION_EXPIRE);
		//把json转换成User对象
		XyzUser user = JsonUtils.jsonToPojo(json, XyzUser.class);
		return XYZResult.ok(user);
	}

	@Override
	public XYZResult logout(String token) {
		// 删除key
		jedisClient.del(token);
		return XYZResult.ok();
	}

}
