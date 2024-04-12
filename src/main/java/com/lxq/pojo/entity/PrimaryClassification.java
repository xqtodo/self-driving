package com.lxq.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName primary_classification
 */
@TableName(value ="primary_classification")
@Data
public class PrimaryClassification implements Serializable {
    private Integer id;

    private String name;

    private String picture;

    private static final long serialVersionUID = 1L;
}