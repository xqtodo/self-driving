package com.lxq.service;

import com.lxq.pojo.entity.Vehicles;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lxq
* @description 针对表【vehicles】的数据库操作Service
* @createDate 2024-04-11 20:35:42
*/
public interface VehiclesService extends IService<Vehicles> {

    Integer getPrice(Integer eleId);
}
