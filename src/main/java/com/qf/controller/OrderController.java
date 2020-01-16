package com.qf.controller;

import com.qf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;
import com.qf.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
*@author:老姚
*@date 2018年3月1日
*备注：订单
*/
@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderService _OrderService;
//获取订单列表
	@RequestMapping(value="orderList",method=RequestMethod.POST)
	public UiPageNum getOrderList(UINum2 uiNum2){

		return _OrderService.selectByUiNum2(uiNum2);
	}
//支付
	@RequestMapping("pay")
	public int pay(HttpSession session){
		User user= (User) session.getAttribute("user");
		if(_OrderService.pay(user.getId())){
			return 1;
		};
		return  0;
	}
//处理订单
	@RequestMapping("enterOrder")
	public int enterOrder(String check){
		if(_OrderService.enterOrder(check)){
			return  1;
		}
		return  0;
	}

	//查看个人订单
	@RequestMapping("getUserOrderList")
	public UiPageNum getUserOrderList(HttpSession session){
		User user= (User) session.getAttribute("user");
		return _OrderService.selectByUserDesc(user.getId());
	}
}
