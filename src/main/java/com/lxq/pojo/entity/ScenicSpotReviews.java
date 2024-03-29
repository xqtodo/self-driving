package com.lxq.pojo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName scenic_spot_reviews
 */
@TableName(value ="scenic_spot_reviews")
@Data
public class ScenicSpotReviews implements Serializable {
    private Integer id;

    private Integer scenicSpotId;

    private Integer userId;

    private Integer rating;

    private String review;

    private Date reviewDate;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}