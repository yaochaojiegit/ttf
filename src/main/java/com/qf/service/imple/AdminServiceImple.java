package com.qf.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.mapper.AdminMapper;
import com.qf.pojo.Adminer;
import com.qf.service.AdminService;

/**
*@author:老姚
*@date 2018年1月11日
*备注：
*/
@Service
public class AdminServiceImple implements AdminService{

	@Autowired
	private AdminMapper mapper;
	
	@Override
	public Adminer selectByNamePass(String username, String password) {
		// TODO Auto-generated method stub
		return mapper.selectByNamePass(username, password);
	}

	@Override
	public boolean checkLoginByName(String username, String password) {
		// TODO Auto-generated method stub
		if (mapper.selectByNamePass(username, password)!=null) {
			return true;
		}
		return false;
	}

	
}
