package xyz.pigschool.sso.service;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.pojo.XyzUser;

public interface UserService {
     
	XYZResult checkData(String data,int type);
	XYZResult register( XyzUser user);
	XYZResult login(String phone,String password);
	XYZResult getUserByToken(String token);
	XYZResult logout(String token);
}
