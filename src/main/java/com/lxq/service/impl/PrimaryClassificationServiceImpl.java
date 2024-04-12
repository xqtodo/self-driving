package com.lxq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxq.pojo.dto.CategoryDto;
import com.lxq.pojo.entity.PrimaryClassification;
import com.lxq.service.PrimaryClassificationService;
import com.lxq.mapper.PrimaryClassificationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lxq
* @description 针对表【primary_classification】的数据库操作Service实现
* @createDate 2024-04-09 23:57:40
*/
@Service
@RequiredArgsConstructor
public class PrimaryClassificationServiceImpl extends ServiceImpl<PrimaryClassificationMapper, PrimaryClassification>
    implements PrimaryClassificationService{
    @Override
    public List<CategoryDto> findCategoryAndGoods() {

        return null;
    }
}




