package com.lxq.controller;

import com.lxq.pojo.entity.Routes;
import com.lxq.pojo.entity.ScenicSpots;
import com.lxq.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lxq
 * @Date: 2024/3/29 21:48
 */
@RestController
@Slf4j
@RequestMapping("spots")
public class ScenicSpotsController {

    //新增景点
    @PostMapping("add")
    public Result addSpots(@RequestBody ScenicSpots spots){
        log.info("新增景点:{}",spots);
        return Result.success();
    }
}
