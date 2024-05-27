package com.lxq.controller;

import com.lxq.pojo.dto.UserDto;
import com.lxq.pojo.dto.VehicleDto;
import com.lxq.pojo.entity.Users;
import com.lxq.pojo.entity.Vehicles;
import com.lxq.pojo.vo.UserVO;
import com.lxq.result.Result;
import com.lxq.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.lxq.pojo.entity.Users.ROLE_NORMAL;

/**
 * @Author: lxq
 * @Date: 2024/5/28 上午1:44
 */
@RestController
@RequestMapping("user")
@Slf4j
@RequiredArgsConstructor
public class AnotherUserController {

    private final UsersService usersService;

    @GetMapping("getUsers")
    public Result<List<UserDto>> getUsers(){
        // 查询所有路线信息
        log.info("查询所有用户信息");
        List<UserDto> UserList = new ArrayList<>();
        List<Users> carList = usersService.list();
        carList.forEach(item -> {
            UserDto user = new UserDto();
            BeanUtils.copyProperties(item,user);
            UserList.add(user);
        });
        return Result.success(UserList);
    }

    @PostMapping("addUser")
    public Result register(@RequestBody UserVO userVO){
        log.info("用户注册信息,{}", userVO);
        Users user = new Users();
        BeanUtils.copyProperties(userVO,user);
//        user.setRole(ROLE_NORMAL);
        usersService.save(user);
        return Result.success();
    }

    @PostMapping("modifyUser")
    public Result<Void> modifySpot(@RequestBody UserDto userDto){
        log.info("修改用户信息");
        Users user = new Users();
        BeanUtils.copyProperties(userDto,user);
        // 修改车辆信息
        usersService.updateById(user);
        return Result.success();
    }

    @DeleteMapping("deleteUser/{id}")
    public Result<Void> deleteSpot(@PathVariable Integer id){
        log.info("删除用户");
        // 删除景点信息
        usersService.removeById(id);
        return Result.success();
    }
}
