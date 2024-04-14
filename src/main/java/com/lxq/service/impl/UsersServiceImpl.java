package com.lxq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxq.pojo.vo.UserVO;
import com.lxq.pojo.entity.Users;
import com.lxq.service.UsersService;
import com.lxq.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author lxq
* @description 针对表【users】的数据库操作Service实现
* @createDate 2024-03-28 19:23:04
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{
    @Override
    public Users login(UserVO userVO) {

        //按username,password查询
        Users user = this.lambdaQuery()
                .eq(Users::getUsername, userVO.getUsername())
                .eq(Users::getPassword, userVO.getPassword()).one();
        return user;
    }
}




