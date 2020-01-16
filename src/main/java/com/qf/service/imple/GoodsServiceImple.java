package com.qf.service.imple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.mapper.GoodsMapper;
import com.qf.pojo.Goods;
import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;
import com.qf.service.GoodsService;

/**
*@author: 老姚
*@date 2018年1月11日
*备注：商品管理
*/
@Service
public class GoodsServiceImple implements GoodsService{

	private final GoodsMapper mapper;

	@Autowired
	public GoodsServiceImple(GoodsMapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * 根据商品id获取商品信息
	 * @param id 商品id
	 * @return Goods商品名称
	 */
	@Override
	public Goods selectById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
	/**
	 * 页面获取商品列表
	 * @param uiNum2 参数实体
	 * @return UiPageNum
	 */
	@Override
	public UiPageNum selectByUI(UINum2 uiNum2) {
		uiNum2.setPage((uiNum2.getPage()-1)*uiNum2.getRows());
		List< Goods> rows=mapper.selectByUI(uiNum2);
		int total=mapper.selectTotal(uiNum2);
		UiPageNum pageNum=new UiPageNum();
		pageNum.setRows(rows);
		pageNum.setTotal(total);
		System.err.println(pageNum);
		return pageNum;
	}
	/**
	 * 删除商品
	 * @param check  商品id
	 * @return 删除结果
	 */
	@Override
	public boolean deleteGoods(String check) {

		List<String> list=new ArrayList<>();
		String[] ids=check.split(",");
		Collections.addAll(list, ids);
		return mapper.goodsDelete(list)>0;
	}
	/**
	 * 商品上架
	 * @param check 商品id
	 * @return 操作结果
	 */
	@Override
	public boolean restoreGoods(String check) {
		List<String> list=new ArrayList<>();
		String[] ids=check.split(",");
		Collections.addAll(list, ids);
		return mapper.goodsRestore(list)>0;
	}
	/**
	 * 添加单个商品
	 * @param goods 商品实体
	 * @return 操作结果
	 */
	@Override
	public boolean insertGoods(Goods goods) {
		return mapper.insertSelective(goods)>0;
	}
	/**
	 * 修改商品
	 * @param goods 商品
	 * @return 修改结果
	 */
	@Override
	public boolean updateGoods(Goods goods) {
		return mapper.updateByPrimaryKeySelective(goods)>0;
	}
	/**
	 * 修改商品图片
	 * @param goods 商品
	 * @return 修改结果
	 */
	@Override
	public boolean goodPicUpdate(Goods goods) {
		return mapper.goodPicUpdate(goods)>0;
	}

}
