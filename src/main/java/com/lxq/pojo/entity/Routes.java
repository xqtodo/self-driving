package com.lxq.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName routes
 */
@TableName(value ="routes")
@Data
public class Routes implements Serializable {
    private Integer id;

    private String routeName;

    private String description;

    private String startLocation;

    private String endLocation;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}