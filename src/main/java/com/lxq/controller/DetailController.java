package com.lxq.controller;

import com.lxq.pojo.vo.DetailPageVO;
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
            DetailPageVO detailPageVO = DetailPageVO.builder()
                    .id(spots.getId())
                    .name(spots.getName())
                    .price(spots.getPrice())
                    .oldPrice(spots.getOldPrice())
                    .photoUrl(spots.getPhotoUrl())
                    .description(spots.getDescription())
                    .detailPhoto(splitDetailPhoto)
                    .build();
            return Result.success(detailPageVO);
        } else if (firstDigit == '2') {
            log.info("线路详情页面");
            Routes routes = routesService.getById(idStr);
            String[] splitSpots = routes.getSpotsCity().split(",");
            String[] splitDetailPhoto = routes.getDetailPhoto().split(",");
            DetailPageVO detailPageVO = DetailPageVO.builder()
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
            return Result.success(detailPageVO);
        } else if (firstDigit == '3') {
            log.info("租车详情页面");
            Vehicles vehicles = vehiclesService.getById(idStr);
            String[] splitDetailPhoto = vehicles.getDetailPhoto().split(",");
            DetailPageVO detailPageVO = DetailPageVO.builder()
                    .id(vehicles.getId())
                    .brand(vehicles.getVehicleBrand())
                    .name(vehicles.getVehicleModel())
                    .price(vehicles.getPrice())
                    .oldPrice(vehicles.getOldPrice())
                    .photoUrl(vehicles.getPhotoUrl())
                    .description(vehicles.getDescription())
                    .detailPhoto(splitDetailPhoto)
                    .build();
            return Result.success(detailPageVO);
        }
        return Result.error("参数错误");
    }
}
//        @GetMapping("detail")
//        public Result getDetail(Integer id) {
//            // 如果id为空，返回参数错误的结果
//            if (id == null) {
//                return Result.error("参数错误");
//            }
//
//            // 将id转换为字符串
//            String idStr = id.toString();
//            // 获取字符串的第一个字符
//            char firstDigit = idStr.charAt(0);
//
//            // 如果第一个字符为'1'
//            if (firstDigit == '1') {
//                // 记录景点详情页面日志
//                log.info("景点详情页面");
//                // 通过服务获取景点对象
//                ScenicSpots spots = scenicSpotsService.getById(idStr);
//                // 如果景点对象为空，返回景点不存在的结果
//                if (spots == null) {
//                    return Result.error("景点不存在");
//                }
//                // 获取景点的详情图片列表
//                String[] splitDetailPhoto = spots.getDetailPhoto() != null ? spots.getDetailPhoto().split(",") : new String[0];
//                // 创建并返回景点详情结果
//                return createScenicSpotDetailResult(spots, splitDetailPhoto);
//            // 如果第一个字符为'2'
//            } else if (firstDigit == '2') {
//                // 记录线路详情页面日志
//                log.info("线路详情页面");
//                // 通过服务获取线路对象
//                Routes routes = routesService.getById(idStr);
//                // 如果线路对象为空，返回线路不存在的结果
//                if (routes == null) {
//                    return Result.error("线路不存在");
//                }
//                // 获取线路的景点城市列表和详情图片列表
//                String[] splitSpots = routes.getSpotsCity() != null ? routes.getSpotsCity().split(",") : new String[0];
//                String[] splitDetailPhoto = routes.getDetailPhoto() != null ? routes.getDetailPhoto().split(",") : new String[0];
//                // 创建并返回线路详情结果
//                return createRouteDetailResult(routes, splitSpots, splitDetailPhoto);
//            // 如果第一个字符为'3'
//            } else if (firstDigit == '3') {
//                // 记录租车详情页面日志
//                log.info("租车详情页面");
//                // 通过服务获取租车对象
//                Vehicles vehicles = vehiclesService.getById(idStr);
//                // 如果租车对象为空，返回租车不存在的结果
//                if (vehicles == null) {
//                    return Result.error("租车不存在");
//                }
//                // 获取租车的详情图片列表
//                String[] splitDetailPhoto = vehicles.getDetailPhoto() != null ? vehicles.getDetailPhoto().split(",") : new String[0];
//                // 创建并返回租车详情结果
//                return createVehicleDetailResult(vehicles, splitDetailPhoto);
//            }
//            // 如果第一个字符不是'1'、'2'或'3'，返回参数错误的结果
//            return Result.error("参数错误");
//        }
//
//
//    private Result createScenicSpotDetailResult(ScenicSpots spots, String[] splitDetailPhoto) {
//        DetailPageVO detailPageVO = DetailPageVO.builder()
//                .id(spots.getId())
//                .name(spots.getName())
//                .price(spots.getPrice())
//                .oldPrice(spots.getOldPrice())
//                .photoUrl(spots.getPhotoUrl())
//                .description(spots.getDescription())
//                .detailPhoto(splitDetailPhoto)
//                .build();
//        return Result.success(detailPageVO);
//    }
//
//    private Result createRouteDetailResult(Routes routes, String[] splitSpots, String[] splitDetailPhoto) {
//        DetailPageVO detailPageVO = DetailPageVO.builder()
//                .id(routes.getId())
//                .name(routes.getName())
//                .price(0)  // Consider fetching actual price if available
//                .oldPrice(998)  // Consider fetching actual old price if available
//                .photoUrl(routes.getPhotoUrl())
//                .description(routes.getDescription())
//                .detailDesc(routes.getDetailDesc())
//                .spotsCity(splitSpots)
//                .detailPhoto(splitDetailPhoto)
//                .build();
//        return Result.success(detailPageVO);
//    }
//}




















