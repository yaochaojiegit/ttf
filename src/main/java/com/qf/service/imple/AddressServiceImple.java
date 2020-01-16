package com.qf.service.imple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.mapper.AddressMapper;
import com.qf.pojo.Address;
import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;
import com.qf.service.AddressService;

/**
*@author:老姚
*@date 2018年1月13日
*备注：
*/
@Service
public class AddressServiceImple implements AddressService {

	@Autowired
	private AddressMapper mapper;

	@Override
	public boolean addressAdd(Address address) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(address)>0?true:false;
	}

	@Override
	public UiPageNum selectAddressList(UINum2 uiNum2) {
		// TODO Auto-generated method stub
		uiNum2.setPage((uiNum2.getPage()-1)*uiNum2.getRows());
		UiPageNum pageNum=new UiPageNum();
		List< Address> rows=mapper.selectByList(uiNum2);
		int total=mapper.selectTotal(uiNum2);
		pageNum.setRows(rows);
		pageNum.setTotal(total);
		return pageNum;
	}

	@Override
	public UiPageNum selectByUser(UINum2 uiNum2) {
		// TODO Auto-generated method stub
		uiNum2.setPage((uiNum2.getPage()-1)*uiNum2.getRows());
		UiPageNum pageNum =new UiPageNum();
		List<Address> rows=mapper.selectByUser(uiNum2);
		int total=mapper.selectTotalByUser(uiNum2);
		pageNum.setRows(rows);
		pageNum.setTotal(total);
		return pageNum;
	}

	@Override
	public boolean addressUp(String check) {
		// TODO Auto-generated method stub
		List<String > list=new ArrayList<>();
		String[] ids=check.split(",");
		for (String id : ids) {
			list.add(id);
		}
		return mapper.restoreAddress(list)>0?true:false;
	}

	@Override
	public boolean addressDown(String check) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<>();
		String[] ids=check.split(",");
		for (String id : ids) {
			list.add(id);
		}
		return mapper.deleteAddress(list)>0?true:false;
	}

	@Override
	public Address selectById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(address)>0?true:false;
	}
	
	
	
}
