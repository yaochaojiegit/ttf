package com.qf.mapper;

import java.util.List;

import com.qf.pojo.GoodsType;
import com.qf.pojo.UINum2;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
    
    List<GoodsType> selectByUI(Integer parentid);
    
    List<GoodsType> selectByUINum(UINum2 uiNum2);
    
    int selectTotal(UINum2 uiNum2);
    
    int deleteByUI(List<String> list);
    
    int deleteByTree(Integer id);
    
    int restoreByUI(List<String> list);
    
    GoodsType selectByName(String name);
    
    int updateIsparent(Integer id);
    
}