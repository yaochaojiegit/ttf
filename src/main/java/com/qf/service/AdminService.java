package com.qf.service;

import com.qf.pojo.Adminer;

/**
*@author:老姚
*@date 2018年1月11日
*备注：
*/

public interface AdminService {

	Adminer selectByNamePass(String username, String password);
	
	boolean checkLoginByName(String username, String password);
}
