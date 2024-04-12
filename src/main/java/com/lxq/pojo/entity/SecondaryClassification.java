package com.lxq.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName secondary_classification
 */
@TableName(value ="secondary_classification")
@Data
public class SecondaryClassification implements Serializable {
    private Integer id;

    private String name;

    private String picture;

    private static final long serialVersionUID = 1L;
}