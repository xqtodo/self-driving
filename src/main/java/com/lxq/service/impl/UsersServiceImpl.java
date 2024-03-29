package com.lxq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxq.constant.MessageConstant;
import com.lxq.exception.LoginException;
import com.lxq.pojo.dto.UserDto;
import com.lxq.pojo.entity.Users;
import com.lxq.service.UsersService;
import com.lxq.mapper.UsersMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
* @author lxq
* @description 针对表【users】的数据库操作Service实现
* @createDate 2024-03-28 19:23:04
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{
    @Override
    public Users login(UserDto userDto) {

        //按username,password查询
        Users user = this.lambdaQuery()
                .eq(Users::getUsername, userDto.getUsername())
                .eq(Users::getPassword, userDto.getPassword()).one();
        return user;
    }
}




