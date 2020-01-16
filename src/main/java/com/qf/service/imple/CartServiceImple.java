package com.qf.service.imple;

import com.qf.mapper.CartMapper;
import com.qf.pojo.Cart;
import com.qf.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by 姚超杰 by 2018/4/14
 * 备注:
 */
@Service
public class CartServiceImple implements CartService {
    @Autowired
    private CartMapper mapper;

    @Override
    public boolean addCart(Cart cart) {
        Cart c=mapper.selectByIdWithGid(cart);
        if (c==null){
           return mapper.insertCart(cart)>0;
        }else {
            c.setNum(c.getNum()+cart.getNum());
            c.setMoney(c.getMoney()+cart.getMoney());
           return mapper.updateCart(c)>0;
        }

    }

    @Override
    public boolean delCart(Cart cart) {
        Cart c=mapper.selectByIdWithGid(cart);
        if (c==null){
            return false;
        }
        if (c.getNum()==1){
            return mapper.deleteCart(cart)>0;
        }else {
            c.setNum(c.getNum()-cart.getNum());
            c.setMoney(c.getMoney()-cart.getMoney());
            return mapper.updateCart(c)>0;
        }
    }

    @Override
    public List<Cart> selectByPay(int id) {
        return mapper.selectById(id);
    }

    @Override
    public boolean delCartAfterPay(int id) {
        return mapper.deleteCartAfterPay(id)>0;
    }
}
