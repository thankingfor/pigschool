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
 * �û�����Service
 * @author zk
 * @da2018��10��25��
 */

@Service
public class UserServiceImpl implements UserService {
		
	@Autowired
	private XyzUserMapper userMapper;
	
	@Override
	public XYZResult checkData(String data, int type) {
		
		XyzUserExample example=new XyzUserExample();
		Criteria criteria = example.createCriteria();
		//���ò�ѯ����
		//1.�ж��û����Ƿ����
		if(type==1) {
			criteria.andUsernameEqualTo(data);
			//2.�ж��ֻ����Ƿ����
		} else if(type==2){
			criteria.andPhoneEqualTo(data);
			//3.�ж�email�Ƿ����
		}else if(type==3){
			criteria.andEmailEqualTo(data);
		}else {
			XYZResult.build(400, "�Ƿ�����!");
		}
		List<XyzUser> list = userMapper.selectByExample(example);
		if(list !=null && list.size()>0) {
			//�鵽����,����false
			return XYZResult.ok(false);
		}
		return XYZResult.ok(true);
	}

	@Override
	public XYZResult register(XyzUser user) {
       //�ж��û����Ƿ�Ϊ��
		if(StringUtils.isBlank(user.getUsername())) {
    	   return XYZResult.build(400, "�û�������Ϊ��");
       }
		//�ж��û����Ƿ��ظ�
		XYZResult xyzResultN = checkData(user.getUsername(), 1);
		if(!(boolean)xyzResultN.getData()) {
			return XYZResult.build(400,"�û����Ѵ���");
		}
		//�ж������Ƿ�Ϊ��
		if(StringUtils.isBlank(user.getPassword())) {
			return XYZResult.build(400, "���벻��Ϊ��");
		}
		//�ж��ֻ����Ƿ�Ϊ��
		if(StringUtils.isBlank(user.getPhone())) {
			return XYZResult.build(400, "�ֻ��Ų���Ϊ��");
		}
		//�ж��ֻ����Ƿ��ظ�
		XYZResult xyzResultP = checkData(user.getPhone(), 2);
		if(!(boolean) xyzResultP.getData()) {
			return XYZResult.build(400, "�ֻ����Ѵ���");
		}
		//�ж�email�Ƿ�Ϊ��
		if(StringUtils.isBlank(user.getEmail())) {
			return XYZResult.build(400, "email����Ϊ��");
		}
		//�ж�email�Ƿ��ظ�
		XYZResult xyzResultE = checkData(user.getEmail(), 3);
		if(!(boolean) xyzResultE.getData()) {
			return XYZResult.build(400, "email�Ѵ���");
		}
		//��ȫpojo
		user.setCreated(new Date());
		user.setUpdated(new Date());
		//�������md5����
		String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass);
		//��������
		userMapper.insert(user);
		return XYZResult.ok();
	}

}
