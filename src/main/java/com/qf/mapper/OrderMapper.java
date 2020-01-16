package com.qf.mapper;

import java.util.List;

import com.qf.pojo.Order;
import com.qf.pojo.UINum2;

public interface OrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    List<Order> selectByUI(UINum2 uiNum2);
    
    int selectTotal(UINum2 uiNum2);

    int updateEnterByUI(List<String> list);

    List<Order> selectByUserDesc(int id);

}