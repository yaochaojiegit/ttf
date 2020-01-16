package com.qf.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.pojo.Address;
import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;
import com.qf.service.AddressService;

/**
*@author:老姚
*@date 2018年1月13日
*备注：
*/
@Controller
public class AddressController {

	@Autowired
	private AddressService service;
	@RequestMapping("/AdminUAA")
	@ResponseBody
	public int r(HttpSession session){
		
		Integer id=(Integer) session.getAttribute("uid");
		return id;
	}
	@RequestMapping("/AdminAdressAdd")
	@ResponseBody
	public int r2(Address address){
		address.setStatus(1);
		if (service.addressAdd(address)) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/AdminUserAdressList")
	@ResponseBody
	public UiPageNum r3(UINum2 uiNum2,HttpSession session){
		Object uid=session.getAttribute("uid");
		uiNum2.setSpecies2(uid.toString());
		return service.selectByUser(uiNum2);
	}
	
	
	@RequestMapping("/AdminAdressUp")
	@ResponseBody
	public int r4(String check){
		if (service.addressUp(check)) {
			return 1;
		}
		
		return 0;
	}
	
	@RequestMapping("/AdminAdressDown")
	@ResponseBody
	public int r5(String check){
		if (service.addressDown(check)) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/AdminUpd")
	@ResponseBody
	public void r6(Integer che,HttpSession session){
		session.setAttribute("aid", che);
	}
	
	
	@RequestMapping("/AdminUAU")
	@ResponseBody
	public Address r7(HttpSession session){
		Integer id=(Integer) session.getAttribute("aid");
		
		return service.selectById(id);
	}
	
	
	@RequestMapping("/AdminAdressUpd")
	@ResponseBody
	public int r8(Address address){
		
		if (service.updateAddress(address)) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/AdminListAdressServlet")
	@ResponseBody
	public UiPageNum r9(UINum2 uiNum2){
		return service.selectAddressList(uiNum2);
		
	}
	
	
	
}
