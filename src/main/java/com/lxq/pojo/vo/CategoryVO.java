package com.lxq.pojo.vo;

import com.lxq.pojo.entity.Goods;
import lombok.Data;

import java.util.List;

/**
 * @Author: lxq
 * @Date: 2024/4/9 23:58
 */
@Data
public class CategoryVO {

    private Integer id;

    private String name;

    private String picture;

    private List<CategoryVO> children;

    private List<Goods> goods;
}
