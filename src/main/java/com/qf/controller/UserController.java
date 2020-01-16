package com.qf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.qf.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;
import com.qf.pojo.User;
import com.qf.service.UserService;

/**
*@author:老姚
*@date 2018年1月11日
*备注：
*/
@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value="/userList",method={RequestMethod.POST})
	@ResponseBody
	public UiPageNum r(UINum2 uiNum2){
		System.err.println(uiNum2);
		UiPageNum pageNum=service.selectByUI(uiNum2);
		return pageNum;
	}
	
	@RequestMapping("CheckName")
	@ResponseBody
	public boolean r2(String username){
		System.err.println(username);
		if (service.checkUserName(username)) {
			return false;
		}
		return true;
	}
	
	@RequestMapping("UserAdd")
	@ResponseBody
	public int r3(User user){
		System.err.println(user);
		user.setPassword(MD5Utils.md5(user.getPassword()));
		if (service.userAdd(user)) {
			return 1;
		}
		return 0;
	}
	@RequestMapping("idAdd")
	@ResponseBody
	public void r4(Integer check,HttpSession session){
		System.err.println("check"+check);
		session.setAttribute("uid", check);
		System.err.println((Integer)session.getAttribute("uid"));
		
	}
	
	@RequestMapping("AdminUpdet")
	@ResponseBody
	public User r5(HttpSession session){
		Integer uid=(Integer) session.getAttribute("uid");
		User user=service.selectById(uid);
		System.err.println(user);
		return user;
	}

	//检查登录
	@RequestMapping("userCheck")
	@ResponseBody
	public User userCheck(HttpSession session){
		User user= (User) session.getAttribute("user");
		if (user==null){
			return  null;
		}
		User user2=service.selectById(user.getId());
		session.setAttribute("user",user2);
		System.err.println(user);
		return user2;
	}
	
	@RequestMapping("AdminUserU")
	@ResponseBody
	public int r6(User user){
		System.out.println("user="+user);
		if (StringUtils.checkEmpty(user.getPassword())){
			user.setPassword(MD5Utils.md5(user.getPassword()));
		}
		if (service.userUpd(user)) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("userDown")
	@ResponseBody
	public int r7(String check){
		String[] strings=check.split(",");
		List<Integer> list=new ArrayList<>();
		for (String string : strings) {
			list.add(Integer.parseInt(string));
		}
		if (service.userDown(list)) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("userUp")
	@ResponseBody
	public int r8(String check){
		String[] strings=check.split(",");
		List<Integer> list=new ArrayList<>();
		for (String string : strings) {
			list.add(Integer.parseInt(string));
		}
		if (service.userUp(list)) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("LoginServlet")
	@ResponseBody
	public int r9(User user,String incode,HttpSession session){
		System.err.println(user);
		String code=(String) session.getAttribute("code");
		if (!incode.equalsIgnoreCase(code)) {
			return 0;
		}
		User u=service.selectByNameAndPass(user);
		if (u!=null) {
			session.setAttribute("user",u);
			return 1;
		}
		return 2;
	}
	//注册并发送邮件
	@RequestMapping("resgisterServlet")
	@ResponseBody
	public int r10(User user){
		
		System.err.println(user);
		if (service.userAdd(user)) {
			EmailUtils.sendEmail(user);
			return 1;
		}
		return 0;
	}


	//激活账号
	@RequestMapping("Activate")
	public  String Activate(int id,String code){ ;
		String ucode=Base64Utils.decoder(code);
		User user=new User();
		user.setId(id);
		user.setCode(ucode);
		if(service.updateFlag(user)){
			return "PageTum.html";
		}
		return "register.html" ;
	}

	//充值和退款
	@RequestMapping("updateRecharge")
	@ResponseBody
	public R updateRecharge(int id, int balance, int type, HttpSession session){
		if (type==0){
			return service.updateRecharge(id,0);
		}else {
			User user= service.selectById(id);
			return service.updateRecharge(id,user.getBalance()+balance);
		}
	}

	@RequestMapping("loginOut")
	@ResponseBody
	public R loginOut(HttpSession session){
		session.setAttribute("user",null);
		return R.ok();

	}
}
