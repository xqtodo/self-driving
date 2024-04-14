package com.lxq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxq.pojo.entity.Orders;
import com.lxq.service.OrdersService;
import com.lxq.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author lxq
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2024-04-14 03:17:35
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




