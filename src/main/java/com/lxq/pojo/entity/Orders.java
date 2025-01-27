package com.lxq.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class Orders implements Serializable {
    private Integer id;

    private Integer userId;

    private String userName;

    private Integer userPhone;

    private String elePhoto;

    private String eleName;

    private Integer elePrice;

    private Integer eleCount;

    private Integer eleTotalprice;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}