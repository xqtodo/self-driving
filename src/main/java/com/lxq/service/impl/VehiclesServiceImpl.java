package com.lxq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxq.pojo.entity.Vehicles;
import com.lxq.service.VehiclesService;
import com.lxq.mapper.VehiclesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author lxq
* @description 针对表【vehicles】的数据库操作Service实现
* @createDate 2024-04-11 20:35:42
*/
@Service
public class VehiclesServiceImpl extends ServiceImpl<VehiclesMapper, Vehicles>
    implements VehiclesService{

    @Autowired
    private VehiclesMapper vehiclesMapper;

    @Override
    public Integer getPrice(Integer eleId) {
        Integer price = vehiclesMapper.getPrice(eleId);
        return price;
    }
}




