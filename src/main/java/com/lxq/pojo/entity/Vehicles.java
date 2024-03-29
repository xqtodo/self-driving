package com.lxq.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName vehicles
 */
@TableName(value ="vehicles")
@Data
public class Vehicles implements Serializable {
    private Integer id;

    private String vehicleBrand;

    private String vehicleModel;

    private String licensePlate;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}