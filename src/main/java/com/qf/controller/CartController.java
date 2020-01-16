package com.qf.controller;

import com.qf.pojo.Cart;
import com.qf.pojo.User;
import com.qf.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * create by 姚超杰 by 2018/4/14
 * 备注:
 */
@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService service;
    //添加商品到购物车
    @RequestMapping("addCart")
    public int addCart(Cart cart, HttpSession session){
        User user= (User) session.getAttribute("user");
        cart.setId(user.getId());
        if(service.addCart(cart)){
            return  1;
        }
        return  0;
    }

    //删除购物车的商品
    @RequestMapping("delCart")
    public  int delCart(Cart cart,HttpSession session){
        User user= (User) session.getAttribute("user");
        cart.setId(user.getId());
        if (service.delCart(cart)){
            return 1;
        }
        return 0;
    }

}
