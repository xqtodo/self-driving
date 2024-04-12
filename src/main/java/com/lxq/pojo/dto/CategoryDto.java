package com.lxq.pojo.dto;

import com.lxq.pojo.entity.Goods;
import com.lxq.pojo.entity.SecondaryClassification;
import lombok.Data;

import java.util.List;

/**
 * @Author: lxq
 * @Date: 2024/4/9 23:58
 */
@Data
public class CategoryDto {

    private Integer id;

    private String name;

    private String picture;

    private List<CategoryDto> children;

    private List<Goods> goods;
}
