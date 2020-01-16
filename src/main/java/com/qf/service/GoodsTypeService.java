package com.qf.service;

import java.util.List;

import com.qf.pojo.EasyUiTreeNode;
import com.qf.pojo.GoodsType;
import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;

/**
*@author:老姚
*@date 2018年1月16日
*备注：关于商品种类
*/

public interface GoodsTypeService {

	List<EasyUiTreeNode> selectByUI(Integer parentid);
	
	UiPageNum selectByUINUm2(UINum2 uiNum2);
	
	boolean deleteByUI(String check);
	
	boolean deleteByTree(Integer id);
	
	boolean restoreByUI(String check);
	
	boolean insertByUI(GoodsType goodsType);
	
	boolean updateByUI(GoodsType goodsType);
	
	GoodsType selectByPrimaryKey(Integer id);
	
	boolean checkByName(String name);
	
	GoodsType append(GoodsType goodsType);
}
