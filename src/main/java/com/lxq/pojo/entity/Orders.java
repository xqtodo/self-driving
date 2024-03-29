package com.lxq.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class Orders implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer vehicleId;

    private Integer routeId;

    private Date orderDate;

    private Date pickupTime;

    private Date dropoffTime;

    private BigDecimal totalCost;

    private Integer status;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}