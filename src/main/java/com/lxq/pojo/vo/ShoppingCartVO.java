package com.lxq.pojo.vo;

import lombok.Data;

/**
 * @Author: lxq
 * @Date: 2024/4/13 下午9:35
 */
@Data
public class ShoppingCartVO {

    private Integer id;

    private Integer count;

    private Integer price;

    private String name;

    private String picture;
}
