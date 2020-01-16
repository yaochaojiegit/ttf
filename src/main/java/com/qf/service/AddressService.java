package com.qf.service;

import com.qf.pojo.Address;
import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;

/**
*@author:老姚
*@date 2018年1月13日
*备注：
*/

public interface AddressService {

	boolean addressAdd(Address address);
	
	UiPageNum selectAddressList(UINum2 uiNum2);
	
	UiPageNum selectByUser(UINum2 uiNum2);
	
	boolean addressUp(String check);
	
	boolean addressDown(String check);
	
	Address selectById(Integer id);
	
	boolean updateAddress(Address address);
	
}
