package com.lxq.service;

import com.lxq.pojo.vo.UserVO;
import com.lxq.pojo.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lxq
* @description 针对表【users】的数据库操作Service
* @createDate 2024-03-28 19:23:04
*/
public interface UsersService extends IService<Users> {

    Users login(UserVO userVO);
}
