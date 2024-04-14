package com.lxq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxq.context.BaseContext;
import com.lxq.pojo.dto.ShoppingCartDto;
import com.lxq.pojo.entity.ShoppingCart;
import com.lxq.service.ShoppingCartService;
import com.lxq.mapper.ShoppingCartMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
* @author lxq
* @description 针对表【shopping_cart】的数据库操作Service实现
* @createDate 2024-04-13 18:24:55
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
    implements ShoppingCartService{

        @Override
        public void add(ShoppingCartDto shoppingCartDto) {
            // 创建一个LambdaQueryWrapper对象，用于构建查询条件
            // 判断该商品购物车中是否存在
            LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ShoppingCart::getEleId, shoppingCartDto.getId())
                    .eq(ShoppingCart::getUserId, BaseContext.getCurrentId());

            // 执行查询，获取购物车中已存在的商品
            ShoppingCart existingCartItem = this.getOne(queryWrapper);

            // 如果已存在该商品
            if (existingCartItem != null) {
                // 更新该商品的数量
                // 如果存在，则更新数量
                existingCartItem.setEleCount(existingCartItem.getEleCount() + shoppingCartDto.getCount());
                this.updateById(existingCartItem);
            } else {
                // 如果不存在该商品，则创建一个新的购物车项
                // 如果不存在，则添加新的购物车项
                ShoppingCart shoppingCart = ShoppingCart.builder()
                        .eleId(shoppingCartDto.getId())
                        .eleCount(shoppingCartDto.getCount())
                        .elePhoto(shoppingCartDto.getPicture())
                        .userId(BaseContext.getCurrentId())
                        .build();
                this.save(shoppingCart);
            }
        }

    @Override
    public void deleteByIds(Integer userid, String[] ids) {
        // 创建一个LambdaQueryWrapper对象，用于构建查询条件
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(ShoppingCart::getEleId, ids)
                .eq(ShoppingCart::getUserId, userid);
        this.remove(queryWrapper);
    }
}




