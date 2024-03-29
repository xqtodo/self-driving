package com.lxq.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName scenic_spots
 */
@TableName(value ="scenic_spots")
@Data
public class ScenicSpots implements Serializable {
    private Integer id;

    private String name;

    private String location;

    private String description;

    private String photoUrl;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}