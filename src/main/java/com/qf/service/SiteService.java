package com.qf.service;

import java.util.List;

import com.qf.pojo.EasyUiTreeNode;
import com.qf.pojo.Site;

/**
*@author:老姚
*@date 2018年1月13日
*备注：
*/

public interface SiteService {

	List<EasyUiTreeNode> selectProvince();
	
	List<EasyUiTreeNode> selectCityBypro(String province);
	
	List<EasyUiTreeNode> selectCountyByCity(String city);
}
