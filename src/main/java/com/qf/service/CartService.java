package com.qf.service;

import com.qf.pojo.Cart;

import java.util.List;

/**
 * create by 姚超杰 by 2018/4/14
 * 备注:关于购物车
 */
public interface CartService {

    boolean addCart(Cart cart);

    boolean delCart(Cart cart);

    List<Cart> selectByPay(int id);

    boolean delCartAfterPay(int id);

}
