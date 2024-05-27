package com.lxq.pojo.dto;

import lombok.Data;

/**
 * @Author: lxq
 * @Date: 2024/5/27 下午5:36
 */
@Data
public class RouteDto {

    private Integer id;

    private String name;

    private String location;

    private String description;

    private String detailDesc;

    private String photoUrl;

    private String detailPhoto;

    private String spotsCity;
}
