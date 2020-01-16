package com.qf.mapper;

import java.util.List;


import com.qf.pojo.UINum2;
import com.qf.pojo.User;


public interface UserMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectByAll(UINum2 uiNum2);
    
    int selectByTotal(UINum2 uiNum2);
    
    User selectByUsername(String username);
    
    int deleteByCheck(List<Integer> list);
    
    int restoreByCheck(List<Integer> list);
    
    User selectByNameAndpass(User user);

    //激活账号
    int updateStatusByEmail(User user);


    //充值和退款
    int updateRecharge(User user);

    
}