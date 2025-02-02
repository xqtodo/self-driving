package com.lxq.mapper;

import com.lxq.pojo.entity.Vehicles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
* @author lxq
* @description 针对表【vehicles】的数据库操作Mapper
* @createDate 2024-04-11 20:35:42
* @Entity com.lxq.pojo.entity.Vehicles
*/
@Mapper
public interface VehiclesMapper extends BaseMapper<Vehicles> {

    @Select("select price from vehicles where id=#{eleId}")
    Integer getPrice(Integer eleId);
}




