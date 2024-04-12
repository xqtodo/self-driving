package com.lxq.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName banner
 */
@TableName(value ="banner")
@Data
public class Banner implements Serializable {
    private Integer id;

    private String imgurl;

    private static final long serialVersionUID = 1L;
}