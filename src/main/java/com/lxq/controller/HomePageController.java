package com.lxq.controller;

import com.lxq.pojo.vo.CategoryVO;
import com.lxq.pojo.vo.RouteVO;
import com.lxq.pojo.vo.ScenicSpotsVO;
import com.lxq.pojo.vo.VehiclesVO;
import com.lxq.pojo.entity.*;
import com.lxq.result.Result;
import com.lxq.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Result<List<CategoryVO>> getCategory(){
        log.info("获取分类及分类下属模块信息");
        List<CategoryVO> categoryVOList = primaryClassificationService.findCategoryAndGoods();
        return Result.success(categoryVOList);
    }

    /**
     * @return {@link Result}<{@link List}<{@link ScenicSpotsVO}>>
     *///获取景点
    @GetMapping("spots")
    public Result<List<ScenicSpotsVO>> getSpots(){
        log.info("获取景点");
        List<ScenicSpotsVO> scenicSpotsVOList = new ArrayList<>();
        List<ScenicSpots> list = scenicSpotsService.list();
        for (ScenicSpots scenicSpots : list) {
            ScenicSpotsVO scenicSpotsVO = new ScenicSpotsVO();
            BeanUtils.copyProperties(scenicSpots, scenicSpotsVO);
            scenicSpotsVOList.add(scenicSpotsVO);
        }
        return Result.success(scenicSpotsVOList);
    }

    //获取路线
    @GetMapping("routes")
    public Result<List<RouteVO>> getRoutes(){
        log.info("获取路线");
        List<RouteVO> routeVOList = new ArrayList<>();
        List<Routes> routesList = routesService.list();
        for (Routes routes : routesList) {
            RouteVO routeVO = new RouteVO();
            BeanUtils.copyProperties(routes, routeVO);
            routeVOList.add(routeVO);
        }
        return Result.success(routeVOList);
    }

    //租车接口，获取全部车辆
    @GetMapping("vehicles")
    public Result<List<VehiclesVO>> getVehicles(){
        log.info("获取全部车辆");
        List<VehiclesVO> vehiclesList = new ArrayList<>();
        vehiclesService.list().forEach(vehicles -> {
            VehiclesVO vehiclesVO = VehiclesVO.builder()
                    .id(vehicles.getId())
                    .vehicleBrand(vehicles.getVehicleBrand())
                    .vehicleModel(vehicles.getVehicleModel())
                    .price(vehicles.getPrice())
                    .photoUrl(vehicles.getPhotoUrl())
                    .build();

            vehiclesList.add(vehiclesVO);
        });
        return Result.success(vehiclesList);
    }
}














