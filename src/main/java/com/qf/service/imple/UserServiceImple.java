package com.qf.service.imple;

import java.util.Date;
import java.util.List;

import com.qf.pojo.BalanceHistory;
import com.qf.service.BalanceHistoryService;
import com.qf.util.MD5Utils;
import com.qf.util.R;
import com.qf.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.mapper.UserMapper;
import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.transaction.annotation.Transactional;

/**
*@author:老姚
*@date 2018年1月11日
*备注：
*/
@Service
public class UserServiceImple implements UserService{

	@Autowired
	private UserMapper mapper;

	@Autowired
	private BalanceHistoryService _BalanceHistoryService;
	@Override
	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}
	@Override
	public UiPageNum selectByUI(UINum2 uiNum2) {
		// TODO Auto-generated method stub
		uiNum2.setPage((uiNum2.getPage()-1)*uiNum2.getRows());
		UiPageNum pageNum=new UiPageNum();
		List<User> rows=mapper.selectByAll(uiNum2);
		int total=mapper.selectByTotal(uiNum2);
		pageNum.setRows(rows);
		pageNum.setTotal(total);
		System.err.println(pageNum);
		return pageNum;
	}
	@Override
	public boolean checkUserName(String username) {
		// TODO Auto-generated method stub
		if (mapper.selectByUsername(username)!=null) {
			return true;
		}
		return false;
	}
	@Override
	public boolean userAdd(User user) {
		// TODO Auto-generated method stub
		user.setFlag(0);
		user.setRole(0);
		user.setPassword(MD5Utils.md5(user.getPassword()));
		user.setCode(RandomUtils.createActiveCode());
		if(mapper.insertSelective(user)>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean userUpd(User user) {
		// TODO Auto-generated method stub
		
		
		return mapper.updateByPrimaryKeySelective(user)>0?true:false;
	}
	@Override
	public boolean userDown(List<Integer> list) {
		// TODO Auto-generated method stub
		return mapper.deleteByCheck(list)>0?true:false;
	}
	@Override
	public boolean userUp(List<Integer> list) {
		// TODO Auto-generated method stub
		return mapper.restoreByCheck(list)>0?true:false;
	}
	@Override
	public User selectByNameAndPass(User user) {
		// TODO Auto-generated method stub
		user.setPassword(MD5Utils.md5(user.getPassword()));
		return mapper.selectByNameAndpass(user);
	}

	@Override
	public boolean updateFlag(User user) {
		User u=mapper.selectByPrimaryKey(user.getId());
		if(u.getFlag()!=0){
			return  false;
		}
		if (u.getCode().equals(user.getCode())){
			return mapper.updateStatusByEmail(user)>0;
		}
		return  false;
	}

	//充值退款
	@Override
	@Transactional
	public R updateRecharge(int id, int balance) {
		BalanceHistory balanceHistory=new BalanceHistory();

		User user=mapper.selectByPrimaryKey(id);
		if (balance==0){
			balanceHistory.setType(0);
			balanceHistory.setMoney(user.getBalance());
			balanceHistory.setBeforeBalance(user.getBalance());
			balanceHistory.setAfterBalance(balance);
		}else if(balance-user.getBalance()<0){
			balanceHistory.setType(2);
			balanceHistory.setMoney(user.getBalance()-balance);
			balanceHistory.setBeforeBalance(user.getBalance());
			balanceHistory.setAfterBalance(balance);
		}else {
			balanceHistory.setType(1);
			balanceHistory.setMoney(balance-user.getBalance());
			balanceHistory.setBeforeBalance(user.getBalance());
			balanceHistory.setAfterBalance(balance);
		}

		user.setBalance(balance);

		balanceHistory.setUid(id);
		balanceHistory.setTime(new Date());
		R r=_BalanceHistoryService.balanceHistoryAdd(balanceHistory);
		 if(mapper.updateRecharge(user)>0){
		 	return R.ok(r.get("msg").toString());
		 }else {
		 	return R.error(r.get("msg").toString());
		 }
	}


}
