package com.qf.service;

import com.qf.pojo.OrderDetail;
import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;

/**
 * create by 姚超杰 by 2018/4/16
 * 备注:订单详情
 */
public interface OrderDetailService {

    boolean addOrderDetail(OrderDetail orderDetail);

    UiPageNum selectByUI(UINum2 uiNum2);

    UiPageNum selectByOid(String id);

}
