package com.lxq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxq.pojo.entity.Goods;
import com.lxq.service.GoodsService;
import com.lxq.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

/**
* @author lxq
* @description 针对表【goods】的数据库操作Service实现
* @createDate 2024-04-09 23:57:40
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{

}




