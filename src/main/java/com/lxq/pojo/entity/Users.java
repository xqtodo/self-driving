package com.lxq.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName users
 */
@TableName(value ="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {

    public static final String ROLE_NORMAL = "普通用户";
    public static final String ROLE_MANAGER = "管理员";

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String role;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}