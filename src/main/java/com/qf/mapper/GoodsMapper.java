package com.qf.mapper;

import java.util.List;

import com.qf.pojo.Goods;
import com.qf.pojo.UINum2;
import org.springframework.stereotype.Component;

/**
 * @deprecated : 商品dao
 * @author lenovo
 */
@Component
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);
    
    List<Goods> selectByUI(UINum2 uiNum2);
    
    int selectTotal(UINum2 uiNum2);
    
    int goodsDelete(List<String> list);
    
    int goodsRestore(List<String> list);

    int goodPicUpdate(Goods goods);
}