package com.lxq.controller;

import com.lxq.pojo.dto.DetailPageDto;
import com.lxq.pojo.dto.VehiclesDto;
import com.lxq.pojo.entity.Routes;
import com.lxq.pojo.entity.ScenicSpots;
import com.lxq.pojo.entity.Vehicles;
import com.lxq.result.Result;
import com.lxq.service.RoutesService;
import com.lxq.service.ScenicSpotsService;
import com.lxq.service.VehiclesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lxq
 * @Date: 2024/4/11 下午9:08
 */
@RestController
@RequestMapping("module")
@Slf4j
@RequiredArgsConstructor
public class DetailController {

    private final ScenicSpotsService scenicSpotsService;
    private final RoutesService routesService;
    private final VehiclesService vehiclesService;

    @GetMapping("detail")
    public Result getDetail(Integer id) {
        String idStr = id.toString();
        char firstDigit = idStr.charAt(0);
        if (firstDigit == '1') {
            log.info("景点详情页面");
            ScenicSpots spots = scenicSpotsService.getById(idStr);
            String[] splitDetailPhoto = spots.getDetailPhoto().split(",");
            DetailPageDto detailPageDto = DetailPageDto.builder()
                    .id(spots.getId())
                    .name(spots.getName())
                    .price(spots.getPrice())
                    .oldPrice(spots.getOldPrice())
                    .photoUrl(spots.getPhotoUrl())
                    .description(spots.getDescription())
                    .detailPhoto(splitDetailPhoto)
                    .build();
            return Result.success(detailPageDto);
        } else if (firstDigit == '2') {
            log.info("线路详情页面");
            Routes routes = routesService.getById(idStr);
            String[] splitSpots = routes.getSpotsCity().split(",");
            String[] splitDetailPhoto = routes.getDetailPhoto().split(",");
            DetailPageDto detailPageDto = DetailPageDto.builder()
                    .id(routes.getId())
                    .name(routes.getName())
                    .price(0)
                    .oldPrice(998)
                    .photoUrl(routes.getPhotoUrl())
                    .description(routes.getDescription())
                    .detailDesc(routes.getDetailDesc())
                    .spotsCity(splitSpots)
                    .detailPhoto(splitDetailPhoto)
                    .build();
            return Result.success(detailPageDto);
        } else if (firstDigit == '3') {
            log.info("租车详情页面");
            Vehicles vehicles = vehiclesService.getById(idStr);
            String[] splitDetailPhoto = vehicles.getDetailPhoto().split(",");
            DetailPageDto detailPageDto = DetailPageDto.builder()
                    .id(vehicles.getId())
                    .brand(vehicles.getVehicleBrand())
                    .name(vehicles.getVehicleModel())
                    .price(vehicles.getPrice())
                    .oldPrice(vehicles.getOldPrice())
                    .photoUrl(vehicles.getPhotoUrl())
                    .description(vehicles.getDescription())
                    .detailPhoto(splitDetailPhoto)
                    .build();
            return Result.success(detailPageDto);
        }
        return Result.error("参数错误");
    }
}




















