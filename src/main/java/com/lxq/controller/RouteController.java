package com.lxq.controller;

import com.lxq.pojo.dto.RouteDto;
import com.lxq.pojo.dto.ScenicSpotsDto;
import com.lxq.pojo.entity.Routes;
import com.lxq.pojo.entity.ScenicSpots;
import com.lxq.result.Result;
import com.lxq.service.RoutesService;
import com.lxq.service.ScenicSpotsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lxq
 * @Date: 2024/5/27 下午5:33
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RoutesService routesService;

    @GetMapping("getRoutes")
    public Result<List<RouteDto>> getSpots(){
        // 查询所有路线信息
        log.info("查询所有路线");
        List<RouteDto> RouteDtoList = new ArrayList<>();
        List<Routes> routeList = routesService.list();
        routeList.forEach(item -> {
            RouteDto routeDto = new RouteDto();
            BeanUtils.copyProperties(item,routeDto);
            RouteDtoList.add(routeDto);
        });
        return Result.success(RouteDtoList);
    }

    @PostMapping("modifyRoutes")
    public Result<Void> modifySpot(@RequestBody RouteDto routeDto){
        log.info("修改路线信息");
        Routes routes = new Routes();
        BeanUtils.copyProperties(routeDto,routes);
        // 修改景点信息
        routesService.updateById(routes);
        return Result.success();
    }

    @PostMapping("addRoutes")
    public Result<Void> addSpot(@RequestBody RouteDto routeDto){
        log.info("添加路线信息");
        Routes routes = new Routes();
        BeanUtils.copyProperties(routeDto,routes);
        // 添加景点信息
        routesService.save(routes);
        return Result.success();
    }

    @DeleteMapping("deleteRoutes/{id}")
    public Result<Void> deleteSpot(@PathVariable Integer id){
        log.info("删除路线信息");
        // 删除景点信息
        routesService.removeById(id);
        return Result.success();
    }
}
