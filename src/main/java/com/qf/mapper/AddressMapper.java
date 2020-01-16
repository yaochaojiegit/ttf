package com.qf.mapper;

import java.util.List;

import com.qf.pojo.Address;
import com.qf.pojo.UINum2;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKeyWithBLOBs(Address record);

    int updateByPrimaryKey(Address record);
    
    List<Address> selectByList(UINum2 uiNum2);
    
    int selectTotal(UINum2 uiNum2);
    
    List<Address> selectByUser(UINum2 uiNum2);
    
    int selectTotalByUser(UINum2 uiNum2);
    
    int	deleteAddress(List<String> list);
    
    int restoreAddress(List<String> list);
    
}