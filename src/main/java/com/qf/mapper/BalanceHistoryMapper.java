package com.qf.mapper;

import com.qf.pojo.BalanceHistory;

import java.util.List;

/**
 * create by 姚超杰 by 2018/4/25
 * 备注:充值记录
 */
public interface BalanceHistoryMapper {
    List<BalanceHistory> selectById(BalanceHistory balanceHistory);

    int selectCountById(BalanceHistory balanceHistory);

    int insert(BalanceHistory balanceHistory);
}
