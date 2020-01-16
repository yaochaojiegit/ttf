package com.qf.service;

import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;

/**
*@author:老姚
*@date 2018年3月1日
*备注：
*/

public interface OrderService {

	UiPageNum selectByUiNum2(UINum2 uiNum2);

	boolean pay(int id);

	boolean enterOrder(String ids);

	UiPageNum selectByUserDesc(int id);
}
