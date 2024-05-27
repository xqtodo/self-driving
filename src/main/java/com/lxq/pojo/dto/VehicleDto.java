package com.lxq.pojo.dto;

import lombok.Data;

/**
 * @Author: lxq
 * @Date: 2024/5/28 上午12:01
 */
@Data
public class VehicleDto {
    private Integer id;

    private String vehicleBrand;

    private String vehicleModel;

    private Integer price;

    private Integer oldPrice;

    private String photoUrl;

    private String detailPhoto;

    private String description;
}
