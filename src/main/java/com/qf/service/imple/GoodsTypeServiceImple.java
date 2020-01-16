package com.qf.service.imple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.mapper.GoodsTypeMapper;
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
@Service
public class GoodsTypeServiceImple implements GoodsTypeService{

	@Autowired
	private GoodsTypeMapper mapper;
	@Override
	public List<EasyUiTreeNode> selectByUI(Integer parentid) {
		// TODO Auto-generated method stub
		List<EasyUiTreeNode> nodes=new ArrayList<>();
		List<GoodsType> list=mapper.selectByUI(parentid);
		for (GoodsType goodsType : list) {
			EasyUiTreeNode node=new EasyUiTreeNode();
			node.setId(goodsType.getId());
			node.setText(goodsType.getName());
			node.setState(goodsType.getIsparent()==1?"closed":"open");
			nodes.add(node);
		}
		return nodes;
	}
	@Override
	public UiPageNum selectByUINUm2(UINum2 uiNum2) {
		// TODO Auto-generated method stub
		uiNum2.setPage((uiNum2.getPage()-1)*uiNum2.getRows());
		UiPageNum uiPageNum=new UiPageNum();
		List<GoodsType> rows=mapper.selectByUINum(uiNum2);
		int total=mapper.selectTotal(uiNum2);
		uiPageNum.setRows(rows);
		uiPageNum.setTotal(total);
		
		return uiPageNum;
	}
	@Override
	public boolean deleteByUI(String check) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<>();
		String[] ids=check.split(",");
		for (String id : ids) {
			list.add(id);
		}
		
 		return mapper.deleteByUI(list)>0?true:false;
	}
	@Override
	public boolean restoreByUI(String check) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<>();
		String[] ids=check.split(",");
		for (String id : ids) {
			list.add(id);
		}
 		
		return mapper.restoreByUI(list)>0?true:false;
	}
	@Override
	public boolean insertByUI(GoodsType goodsType) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(goodsType)>0?true:false;
	}
	@Override
	public boolean updateByUI(GoodsType goodsType) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(goodsType)>0?true:false;
	}
	@Override
	public GoodsType selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}
	@Override
	public boolean checkByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name)!=null?true:false;
	}
	@Override
	@Transactional
	public GoodsType append(GoodsType goodsType) {
		// TODO Auto-generated method stub
		goodsType.setIsparent(0);
		goodsType.setName("新种类");
		goodsType.setLevel(3);
		goodsType.setStatus(1);
		
		if(mapper.insert(goodsType)>0&&mapper.updateIsparent(goodsType.getParent())>0){
			System.err.println(goodsType);
			return goodsType;
		}
		
		return null;
	}
	@Override
	public boolean deleteByTree(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByTree(id)>0?true:false;
	}

}
