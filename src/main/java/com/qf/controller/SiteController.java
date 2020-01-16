package com.qf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.pojo.EasyUiTreeNode;
import com.qf.pojo.Site;
import com.qf.service.SiteService;

/**
*@author:老姚
*@date 2018年1月13日
*备注：
*/
@Controller
public class SiteController {

	@Autowired
	private SiteService service;
	@RequestMapping("/AdminAdressThree")
	@ResponseBody
	public List<EasyUiTreeNode> r(){
		return service.selectProvince();
	}
	
	@RequestMapping("/AdminAdressTwo")
	@ResponseBody
	public List<EasyUiTreeNode> r2(String province){
		return service.selectCityBypro(province);
	}
	
	@RequestMapping("/AdminAdressOne")
	@ResponseBody
	public List<EasyUiTreeNode> r3(String city){
		return service.selectCountyByCity(city);
	}
}
