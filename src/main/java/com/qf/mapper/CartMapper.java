package com.qf.mapper;

import com.qf.pojo.Cart;

import java.util.List;

/**
 * create by 姚超杰 by 2018/4/14
 * 备注:购物车
 */
public interface CartMapper {
    int insertCart(Cart cart);

    int updateCart(Cart cart);

    int deleteCart(Cart cart);

    int deleteCartAfterPay(int id);

    Cart selectByIdWithGid(Cart cart);

    List<Cart> selectById(int id);



}
