package com.qf.service.imple;

import com.qf.mapper.BalanceHistoryMapper;
import com.qf.pojo.BalanceHistory;
import com.qf.pojo.UiPageNum;
import com.qf.service.BalanceHistoryService;
import com.qf.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by 姚超杰 by 2018/4/25
 * 备注:充值记录
 */
@Service
public class BalanceHistoryServiceImple implements BalanceHistoryService {

    @Autowired
    private BalanceHistoryMapper _BalanceHistoryMapper;


    @Override
    public UiPageNum selectById(Integer id) {
        UiPageNum uiPageNum=new UiPageNum();
        BalanceHistory balanceHistory=new BalanceHistory();
        balanceHistory.setUid(id);
        List<BalanceHistory> rows=_BalanceHistoryMapper.selectById(balanceHistory);
        int total=_BalanceHistoryMapper.selectCountById(balanceHistory);
        uiPageNum.setRows(rows);
        uiPageNum.setTotal(total);
        return uiPageNum;
    }

    @Override
    public R balanceHistoryAdd(BalanceHistory balanceHistory) {

        if (_BalanceHistoryMapper.insert(balanceHistory)>0){
            return R.ok("账户记录添加成功");
        }
        return R.error("账户记录添加失败");
    }
}
