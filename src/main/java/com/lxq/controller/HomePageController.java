package com.lxq.controller;

import com.lxq.pojo.dto.CategoryDto;
import com.lxq.pojo.dto.RouteDto;
import com.lxq.pojo.dto.ScenicSpotsDto;
import com.lxq.pojo.dto.VehiclesDto;
import com.lxq.pojo.entity.*;
import com.lxq.result.Result;
import com.lxq.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lxq
 * @Date: 2024/4/2 6:45
 */
@RestController
@RequestMapping("/home")
@Slf4j
@RequiredArgsConstructor
public class HomePageController {

    private final BannerService bannerService;
    private final PrimaryClassificationService primaryClassificationService;
    private final ScenicSpotsService scenicSpotsService;
    private final RoutesService routesService;
    private final VehiclesService vehiclesService;

    /**
     * @return {@link Result}<{@link List}<{@link Banner}>>
     */
    @GetMapping("banner")
    public Result<List<Banner>> getBanner(){
        log.info("获取轮播图");
        List<Banner> list = bannerService.list();
        return Result.success(list);
    }

    //TODO：搁置
    //  @GetMapping("category/head")
    public Result<List<CategoryDto>> getCategory(){
        log.info("获取分类及分类下属模块信息");
        List<CategoryDto> categoryDtoList = primaryClassificationService.findCategoryAndGoods();
        return Result.success(categoryDtoList);
    }

    /**
     * @return {@link Result}<{@link List}<{@link ScenicSpotsDto}>>
     *///获取景点
    @GetMapping("spots")
    public Result<List<ScenicSpotsDto>> getSpots(){
        log.info("获取景点");
        List<ScenicSpotsDto> scenicSpotsDtoList = new ArrayList<>();
        List<ScenicSpots> list = scenicSpotsService.list();
        for (ScenicSpots scenicSpots : list) {
            ScenicSpotsDto scenicSpotsDto = new ScenicSpotsDto();
            BeanUtils.copyProperties(scenicSpots,scenicSpotsDto);
            scenicSpotsDtoList.add(scenicSpotsDto);
        }
        return Result.success(scenicSpotsDtoList);
    }

    //获取路线
    @GetMapping("routes")
    public Result<List<RouteDto>> getRoutes(){
        log.info("获取路线");
        List<RouteDto> routeDtoList = new ArrayList<>();
        List<Routes> routesList = routesService.list();
        for (Routes routes : routesList) {
            RouteDto routeDto = new RouteDto();
            BeanUtils.copyProperties(routes,routeDto);
            routeDtoList.add(routeDto);
        }
        return Result.success(routeDtoList);
    }

    //租车接口，获取全部车辆
    @GetMapping("vehicles")
    public Result<List<VehiclesDto>> getVehicles(){
        log.info("获取全部车辆");
        List<VehiclesDto> vehiclesList = new ArrayList<>();
        vehiclesService.list().forEach(vehicles -> {
            VehiclesDto vehiclesDto = VehiclesDto.builder()
                    .id(vehicles.getId())
                    .vehicleBrand(vehicles.getVehicleBrand())
                    .vehicleModel(vehicles.getVehicleModel())
                    .price(vehicles.getPrice())
                    .photoUrl(vehicles.getPhotoUrl())
                    .build();

            vehiclesList.add(vehiclesDto);
        });
        return Result.success(vehiclesList);
    }
}














