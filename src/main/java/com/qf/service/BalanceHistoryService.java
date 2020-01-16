package com.qf.service;

import com.qf.pojo.BalanceHistory;
import com.qf.pojo.UiPageNum;
import com.qf.util.R;

/**
 * create by 姚超杰 by 2018/4/25
 * 备注:
 */
public interface BalanceHistoryService {
    UiPageNum selectById(Integer id);

    R balanceHistoryAdd(BalanceHistory balanceHistory);
}
