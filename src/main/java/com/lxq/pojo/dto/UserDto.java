package com.lxq.pojo.dto;

import lombok.Data;

/**
 * @Author: lxq
 * @Date: 2024/5/28 上午1:53
 */
@Data
public class UserDto {

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String role;

}
