package com.lxq.mapper;

import com.lxq.pojo.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lxq
* @description 针对表【orders】的数据库操作Mapper
* @createDate 2024-04-14 03:17:35
* @Entity com.lxq.pojo.entity.Orders
*/
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}




