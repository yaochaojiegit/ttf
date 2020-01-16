package com.qf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.pojo.EasyUiTreeNode;
import com.qf.pojo.GoodsType;
import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;
import com.qf.service.GoodsTypeService;

/**
*@author:老姚
*@date 2018年1月16日
*备注：
*/
@Controller
public class GoodsTypeController {

	@Autowired
	private GoodsTypeService service;
	
	@RequestMapping("/AdminGUTreeServle")
	@ResponseBody
	public List<EasyUiTreeNode> r(@RequestParam(defaultValue="0")Integer id){
	
		return service.selectByUI(id);
	}
	
	@RequestMapping("/GTList")
	@ResponseBody
	public UiPageNum r2(UINum2 uiNum2){
		System.err.println(uiNum2);
		return service.selectByUINUm2(uiNum2);
	}
	
	@RequestMapping("/downType")
	@ResponseBody
	public int r3(String check){
		if (service.deleteByUI(check)) {
			return 1;
		}
		return 0;
	}
	@RequestMapping("/upType")
	@ResponseBody
	public int r4(String check){
		if (service.restoreByUI(check)) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping(value="/content/append",method=RequestMethod.POST)
	@ResponseBody
	public GoodsType r5(GoodsType goodsType){
		return service.append(goodsType);
	}
	
	@RequestMapping("/CheckGdsName")
	@ResponseBody
	public boolean r6(String name){
		if (service.checkByName(name)) {
			return false;
		}
		
		return true;
	}
	
	@RequestMapping("/content/list")
	@ResponseBody
	public List<EasyUiTreeNode> r7(@RequestParam(defaultValue="0")Integer id){
		
		return service.selectByUI(id);
	}
	
	@RequestMapping("/content/update")
	@ResponseBody
	public void r7(GoodsType goodsType){
		service.updateByUI(goodsType);
	}
	
	@RequestMapping("/content/delete")
	@ResponseBody
	public void r8(Integer id){
		service.deleteByTree(id);
	}
}
