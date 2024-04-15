package com.lxq.controller;

import com.lxq.pojo.dto.ScenicSpotsDto;
import com.lxq.pojo.entity.ScenicSpots;
import com.lxq.pojo.vo.ScenicSpotsVO;
import com.lxq.result.Result;
import com.lxq.service.ScenicSpotsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lxq
 * @Date: 2024/4/14 下午11:22
 */
@RestController
@RequestMapping("/admin")
@Slf4j
@RequiredArgsConstructor
public class AdminController {

    private final ScenicSpotsService scenicSpotsService;

    @GetMapping("getSpots")
    public Result<List<ScenicSpotsDto>> getSpots(){
        // 查询所有景点信息
        log.info("查询所有景点信息");
        List<ScenicSpotsDto> scenicSpotsDtoList = new  ArrayList<>();
        List<ScenicSpots> scenicSpotsList = scenicSpotsService.list();
        scenicSpotsList.forEach(item -> {
            ScenicSpotsDto scenicSpotsDto = new ScenicSpotsDto();
            BeanUtils.copyProperties(item,scenicSpotsDto);
            scenicSpotsDtoList.add(scenicSpotsDto);
        });
        return Result.success(scenicSpotsDtoList);
    }

    @PostMapping("modifySpot")
    public Result<Void> modifySpot(@RequestBody ScenicSpotsDto scenicSpotsDto){
        log.info("修改景点信息");
        ScenicSpots scenicSpots = new ScenicSpots();
        BeanUtils.copyProperties(scenicSpotsDto,scenicSpots);
        // 修改景点信息
        scenicSpotsService.updateById(scenicSpots);
        return Result.success();
    }

    @PostMapping("addSpot")
    public Result<Void> addSpot(@RequestBody ScenicSpotsDto scenicSpotsDto){
        log.info("添加景点信息");
        ScenicSpots scenicSpots = new ScenicSpots();
        BeanUtils.copyProperties(scenicSpotsDto,scenicSpots);
        // 添加景点信息
        scenicSpotsService.save(scenicSpots);
        return Result.success();
    }

    @DeleteMapping("deleteSpot/{id}")
    public Result<Void> deleteSpot(@PathVariable Integer id){
        log.info("删除景点信息");
        // 删除景点信息
        scenicSpotsService.removeById(id);
        return Result.success();
    }
}

