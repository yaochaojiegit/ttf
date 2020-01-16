package com.qf.service.imple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.mapper.SiteMapper;
import com.qf.pojo.EasyUiTreeNode;
import com.qf.pojo.Site;
import com.qf.service.SiteService;

/**
*@author:老姚
*@date 2018年1月13日
*备注：
*/
@Service
public class SiteServiceImple implements SiteService {

	@Autowired
	private SiteMapper mapper;
	@Override
	public List<EasyUiTreeNode> selectProvince() {
		// TODO Auto-generated method stub
		List<Site> list=mapper.selectProvince();
		List<EasyUiTreeNode> nodes=new ArrayList<>();
		int id=1;
		for (Site site : list) {
			EasyUiTreeNode node=new EasyUiTreeNode();
			node.setId(id++);
			node.setText(site.getProvince());
			nodes.add(node);
		}
		return nodes;
	}

	@Override
	public List<EasyUiTreeNode> selectCityBypro(String province) {
		// TODO Auto-generated method stub
		List<Site> list=mapper.selectCityByPro(province);
		List<EasyUiTreeNode> nodes=new ArrayList<>();
		int id=1;
		for (Site site : list) {
			EasyUiTreeNode node=new EasyUiTreeNode();
			node.setId(id++);
			node.setText(site.getCity());
			nodes.add(node);
		}
		return nodes;
	}

	@Override
	public List<EasyUiTreeNode> selectCountyByCity(String city) {
		// TODO Auto-generated method stub
		List< Site> list=mapper.selectCountyByCity(city);
		List<EasyUiTreeNode> nodes=new ArrayList<>();
		int id=1;
		for (Site site : list) {
			EasyUiTreeNode node=new EasyUiTreeNode();
			node.setId(id++);
			node.setText(site.getCounty());
			nodes.add(node);
		}
		
		return nodes;
	}

}
