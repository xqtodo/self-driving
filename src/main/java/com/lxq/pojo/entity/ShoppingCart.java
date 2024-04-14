package com.lxq.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * @TableName shopping_cart
 */
@TableName(value ="shopping_cart")
@Data
@Builder
public class ShoppingCart implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer eleId;

    private Integer eleCount;

    private String elePhoto;

    private static final long serialVersionUID = 1L;
}