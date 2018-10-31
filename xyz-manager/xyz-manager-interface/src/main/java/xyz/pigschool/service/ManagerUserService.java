package xyz.pigschool.service;

import xyz.pigschool.common.utils.XYZResult;

public interface ManagerUserService {
	XYZResult login(String username,String password);
}
