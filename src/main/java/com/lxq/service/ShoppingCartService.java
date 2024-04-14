package com.lxq.service;

import com.lxq.pojo.dto.ShoppingCartDto;
import com.lxq.pojo.entity.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lxq
* @description 针对表【shopping_cart】的数据库操作Service
* @createDate 2024-04-13 18:24:55
*/
public interface ShoppingCartService extends IService<ShoppingCart> {


    void add(ShoppingCartDto shoppingCartDto);

    void deleteByIds(Integer userid, String[] ids);

}
