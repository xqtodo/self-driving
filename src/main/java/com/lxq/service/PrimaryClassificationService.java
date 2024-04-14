package com.lxq.service;

import com.lxq.pojo.vo.CategoryVO;
import com.lxq.pojo.entity.PrimaryClassification;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lxq
* @description 针对表【primary_classification】的数据库操作Service
* @createDate 2024-04-09 23:57:40
*/
public interface PrimaryClassificationService extends IService<PrimaryClassification> {


    List<CategoryVO> findCategoryAndGoods();
}
