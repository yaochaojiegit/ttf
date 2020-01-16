package com.qf.service;

import java.util.List;

import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;
import com.qf.pojo.User;
import com.qf.util.R;

/**
*@author:老姚
*@date 2018年1月11日
*备注：
*/

public interface UserService {

	User selectById(Integer id);
	
	UiPageNum selectByUI(UINum2 uiNum2); 
	
	boolean checkUserName(String username);
	
	boolean userAdd(User user);
	
	boolean userUpd(User user);
	
	boolean userDown(List<Integer> list);
	
	boolean userUp(List<Integer> list);
	
	User selectByNameAndPass(User user);

	boolean updateFlag(User user);

	R updateRecharge(int id, int balance);
	
}
