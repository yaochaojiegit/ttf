package com.qf.service.imple;

import com.qf.mapper.OrderDetailMapper;
import com.qf.pojo.OrderDetail;
import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;
import com.qf.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by 姚超杰 by 2018/4/16
 * 备注:订单详情
 */
@Service
public class OrderDetailServiceImple  implements OrderDetailService {
    @Autowired
    protected OrderDetailMapper _OrderDetailMapper;

    @Override
    public boolean addOrderDetail(OrderDetail orderDetail) {

        return _OrderDetailMapper.insertSelective(orderDetail)>0;
    }

    @Override
    public UiPageNum selectByUI(UINum2 uiNum2) {

        uiNum2.setPage((uiNum2.getPage()-1)*uiNum2.getRows());
        UiPageNum uiPageNum=new UiPageNum();
        List<OrderDetail> rows=_OrderDetailMapper.selectByUI(uiNum2);
        int total=_OrderDetailMapper.selectCountByUI(uiNum2);
        uiPageNum.setRows(rows);
        uiPageNum.setTotal(total);
        return uiPageNum;
    }

    @Override
    public UiPageNum selectByOid(String id) {
        UiPageNum uiPageNum=new UiPageNum();
        List<OrderDetail> rows=_OrderDetailMapper.selectByOid(id);
        uiPageNum.setRows(rows);
        return uiPageNum;
    }
}
