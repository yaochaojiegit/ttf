package com.qf.service;


import com.qf.pojo.Goods;
import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;

/**
*@author: 老姚
*@date 2018年1月11日
*备注： 商品管理
*/

public interface GoodsService {

	/**
	 * 根据商品id获取商品信息
	 * @param id 商品id
	 * @return Goods商品名称
	 */
	Goods selectById(Integer id);

	/**
	 * 页面获取商品列表
	 * @param uiNum2 参数实体
	 * @return UiPageNum
	 */
	UiPageNum selectByUI(UINum2 uiNum2);

	/**
	 * 删除商品
	 * @param check  商品id
	 * @return 删除结果
	 */
	boolean deleteGoods(String check);

	/**
	 * 商品上架
	 * @param check 商品id
	 * @return 操作结果
	 */
	boolean restoreGoods(String check);

	/**
	 * 添加单个商品
	 * @param goods 商品实体
	 * @return 操作结果
	 */
	boolean insertGoods(Goods goods);

	/**
	 * 修改商品
	 * @param goods 商品
	 * @return 修改结果
	 */
	boolean updateGoods(Goods goods);

	/**
	 * 修改商品图片
	 * @param goods 商品
	 * @return 修改结果
	 */
	boolean goodPicUpdate(Goods goods);
}
