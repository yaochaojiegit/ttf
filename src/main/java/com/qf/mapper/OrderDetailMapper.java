package com.qf.mapper;

import com.qf.pojo.OrderDetail;
import com.qf.pojo.UINum2;

import java.util.List;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer id);

    List<OrderDetail> selectByUI(UINum2 uiNum2);

    int selectCountByUI(UINum2 uiNum2);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    List<OrderDetail> selectByOid(String id);
}