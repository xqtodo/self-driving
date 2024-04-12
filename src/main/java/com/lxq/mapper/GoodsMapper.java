package com.lxq.mapper;

import com.lxq.pojo.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lxq
* @description 针对表【goods】的数据库操作Mapper
* @createDate 2024-04-09 23:57:40
* @Entity com.lxq.pojo.entity.Goods
*/
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

}




