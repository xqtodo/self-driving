package com.lxq.pojo.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: lxq
 * @Date: 2024/4/11 下午8:36
 */
@Builder
@Data
public class VehiclesDto {
    private Integer id;

    private String vehicleBrand;

    private String vehicleModel;

    private Integer price;

    private Integer oldPrice;

    private String photoUrl;

    private String[] detailPhoto;
}
