package com.lxq.pojo.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: lxq
 * @Date: 2024/4/12 上午2:07
 */
@Data
@Builder
public class DetailPageVO {
    private Integer id;

    private String name;

    private String brand;

    private String description;

    private String detailDesc;

    private Integer price;

    private Integer oldPrice;

    private String photoUrl;

    private String[] detailPhoto;

    private String[] spotsCity;
}
