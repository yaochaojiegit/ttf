package com.qf.controller;

import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;
import com.qf.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by 姚超杰 by 2018/4/16
 * 备注:
 */
@RestController
@RequestMapping("orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService _OrderDetailService;

    @RequestMapping("getOrderDetailList")
    public UiPageNum getOrderDetailList(UINum2 uiNum2){

        return _OrderDetailService.selectByUI(uiNum2);
    }

    //根据订单id获取订单详情
    @RequestMapping("getOrderDetailByID")
    public UiPageNum getOrderDetailByID(String orderId){
        return  _OrderDetailService.selectByOid(orderId);
    }
}
