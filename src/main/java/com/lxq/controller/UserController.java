package com.lxq.controller;

import com.lxq.constant.JwtClaimsConstant;
import com.lxq.constant.MessageConstant;
import com.lxq.exception.LoginException;
import com.lxq.pojo.vo.UserVO;
import com.lxq.pojo.entity.Users;
import com.lxq.properties.JwtProperties;
import com.lxq.result.Result;
import com.lxq.service.UsersService;
import com.lxq.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.lxq.pojo.entity.Users.ROLE_NORMAL;

/**
 * @Author: lxq
 * @Date: 2024/3/28 19:50
 */
@Slf4j
@RequestMapping("user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;
    private final JwtProperties jwtProperties;
    @PostMapping("register")
    public Result register(@RequestBody UserVO userVO){
        log.info("用户注册信息,{}", userVO);
        Users user = new Users();
        BeanUtils.copyProperties(userVO,user);
        user.setRole(ROLE_NORMAL);
        usersService.save(user);
        return Result.success();
    }
    @PostMapping("login")
    public Result login(@RequestBody UserVO userVO){
        log.info("用户登录信息,{}", userVO);
        //使用optional判断userDto是否存在
        Users users = Optional.ofNullable(usersService.login(userVO)).orElseThrow(() -> new LoginException(MessageConstant.LOGIN_ERROR));
//        Users users = usersService.login(userDto);

//        if (Objects.equals(users.getRole(), "普通用户")){
//            return Result.error(MessageConstant.ACCOUNT_PERMISSION_DENIED);
//        }

//        根据用户id生成token
        Map<String,Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID,users.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);
        List<String> loginInfo = new ArrayList<>();
        loginInfo.add(users.getUsername());
        loginInfo.add(token);
        log.info("用户token,{}", token);
        return Result.success(loginInfo);
    }

}
