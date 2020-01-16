package com.qf.service.imple;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.qf.pojo.*;
import com.qf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.mapper.OrderMapper;
import org.springframework.transaction.annotation.Transactional;

/**
*@author:老姚
*@date 2018年3月1日
*备注：
*/
@Service
public class OrderServiceImple implements OrderService {

	@Autowired
	private  OrderMapper mapper;

	@Autowired
	private CartService _CartService;

	@Autowired
	private OrderDetailService _OrderDetailService;

	@Autowired
	private UserService _UserService;

	@Autowired
	private BalanceHistoryService _BalanceHistoryService;

	//获取订单列表
	@Override
	public UiPageNum selectByUiNum2(UINum2 uiNum2) {
		// TODO Auto-generated method stub
		uiNum2.setPage((uiNum2.getPage()-1)*uiNum2.getRows());
		UiPageNum uiPageNum=new UiPageNum();
		List<Order> rows=mapper.selectByUI(uiNum2);
		int total=mapper.selectTotal(uiNum2);
		uiPageNum.setRows(rows);
		uiPageNum.setTotal(total);
		
		return uiPageNum;
	}

	//支付方法
	@Override
	@Transactional
	public boolean pay(int id) {
		List<Cart> list=_CartService.selectByPay(id);
		int money=0;
		for (Cart cart : list) {
			money+=cart.getMoney();//获取总额
		}
		Order order=new Order();
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		order.setDate(format.format(date));
		order.setStatus(0);
		order.setMoney(money);
		order.setUid(id);

		if(mapper.insertSelective(order)>0){//创建订单
			OrderDetail orderDetail=new OrderDetail();
			orderDetail.setOid(order.getId());
			User user=_UserService.selectById(id);
			if(user.getBalance()<money){
				return false;
			}else {
				_UserService.updateRecharge(id,user.getBalance()-money);
			}
			for (Cart cart : list) {
				orderDetail.setNum(cart.getNum());
				orderDetail.setMoney(cart.getMoney());
				orderDetail.setPid(cart.getPid());
				_OrderDetailService.addOrderDetail(orderDetail);//添加到订单详情表
			}
			_CartService.delCartAfterPay(id);//支付完毕删除购物车数据
			return  true;
		}
		return false;
	}

	@Override
	public boolean enterOrder(String check) {
		List<String> list=new ArrayList<>();
		String[] ids=check.split(",");
		for (String id : ids) {
			list.add(id);
		}
		return mapper.updateEnterByUI(list)>0;
	}

	@Override
	public UiPageNum selectByUserDesc(int id) {
		UiPageNum uiPageNum=new UiPageNum();
		uiPageNum.setRows(mapper.selectByUserDesc(id));
		return uiPageNum;
	}
}
