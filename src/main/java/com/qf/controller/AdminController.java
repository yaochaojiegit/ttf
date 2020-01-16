package com.qf.controller;

import javax.servlet.http.HttpSession;

import com.qf.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.service.AdminService;

/**
*@author:老姚
*@date 2018年1月11日
*备注：管理员登录
*/
@Controller
@RequestMapping("adminer")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@RequestMapping(value="loginn",method={RequestMethod.POST})
	@ResponseBody
	public int r(String username,String password,String incode,HttpSession session){
		String code=(String) session.getAttribute("code");
		System.out.println(username+password+incode);
		if (!incode.equalsIgnoreCase(code)) {
			return 3;
		}
		password=MD5Utils.md5(password);
		if (service.checkLoginByName(username, password)) {
			return 1;
		}else {
			return 2;
		}
		
	}
}
