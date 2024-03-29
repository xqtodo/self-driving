package com.lxq.mapper;

import com.lxq.pojo.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lxq
* @description 针对表【users】的数据库操作Mapper
* @createDate 2024-03-28 19:23:04
* @Entity com.lxq.pogi/entity.Users
*/
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}




