package com.qf.controller;

import com.qf.pojo.BalanceHistory;
import com.qf.pojo.UiPageNum;
import com.qf.service.BalanceHistoryService;
import com.qf.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by 姚超杰 by 2018/4/25
 * 备注:充值记录
 */
@RestController
@RequestMapping("balanceHistory")
public class BalanceHistoryController {

    @Autowired
    private BalanceHistoryService _BalanceHistoryService;
    //根据id查询个人账户变化金额
    @RequestMapping("selectById")
    public UiPageNum selectById(Integer id){
        return _BalanceHistoryService.selectById(id);
    }

    @RequestMapping("insert")
    public R insert(BalanceHistory balanceHistory){
        return _BalanceHistoryService.balanceHistoryAdd(balanceHistory);
    }
}
