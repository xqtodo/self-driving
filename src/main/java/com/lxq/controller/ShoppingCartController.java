package com.lxq.controller;

import com.lxq.context.BaseContext;
import com.lxq.pojo.dto.ShoppingCartDto;
import com.lxq.pojo.dto.ShoppingDelDto;
import com.lxq.pojo.entity.Orders;
import com.lxq.pojo.entity.ScenicSpots;
import com.lxq.pojo.entity.Vehicles;
import com.lxq.pojo.vo.ShoppingCartVO;
import com.lxq.result.Result;
import com.lxq.service.ScenicSpotsService;
import com.lxq.service.ShoppingCartService;
import com.lxq.service.VehiclesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lxq
 * @Date: 2024/4/13 下午5:23
 */
@RestController
@RequestMapping("member")
@Slf4j
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final VehiclesService vehiclesService;
    private final ScenicSpotsService scenicSpotsService;

    @PostMapping("addCart")
    public Result addCart(@RequestBody ShoppingCartDto shoppingCartDto) {
        shoppingCartService.add(shoppingCartDto);
        return Result.success();
    }

    @GetMapping("my_getCart") //有BUG
    public Result<List<ShoppingCartVO>> my_getCart() {
        List<ShoppingCartVO> ShoppingCartVOList = new ArrayList<>();
//      通过shoppingCartService查询出所有数据，然后通过循环将数据封装到ShoppingCartVO中，最后返回
        shoppingCartService.list().forEach(shoppingCart -> {
            ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
            log.info("根据商品id查询价格并且返回，{}", shoppingCart.getEleId());
            Integer price = 0;
            String name = "";
            Integer eleId = shoppingCart.getEleId();
            char eleIdFirstDigital = eleId.toString().charAt(0);
            if (eleIdFirstDigital == '3') {
                // 3开头表示车辆
                log.info("查询车辆价格");
                price = vehiclesService.getPrice(eleId);
                name = vehiclesService.getById(eleId).getVehicleModel();
            } else if (eleIdFirstDigital == '1') {
                // 1开头表示景点
                log.info("查询景点价格");
                price = scenicSpotsService.getById(eleId).getPrice();
                name = scenicSpotsService.getById(eleId).getName();
            }
            shoppingCartVO.setPrice(price);
            shoppingCartVO.setName(name);
            shoppingCartVO.setId(shoppingCart.getEleId());
            shoppingCartVO.setCount(shoppingCart.getEleCount());
            shoppingCartVO.setPicture(shoppingCart.getElePhoto());
            ShoppingCartVOList.add(shoppingCartVO);
        });
        return Result.success(ShoppingCartVOList);
    }

    @GetMapping("getCart")
    public Result<List<ShoppingCartVO>> getCart() {
        List<ShoppingCartVO> cartList = new ArrayList<>();

        shoppingCartService.list().forEach(shoppingCart -> {
            if (shoppingCart.getEleId() == null || shoppingCart.getEleId() < 0) {
                log.error("Element ID is invalid or null.");
                return; // 跳过不合法或为空的记录
            }

            ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
            Integer price = null;
            String name = null;

            // 获取EleId的首位数字
            //int firstDigit = (int) Math.floorMod(shoppingCart.getEleId(), 100) / 10; // 假设EleId是两位数，获取十位数作为firstDigit
            // 修复获取首位数字的方法
            int firstDigit = shoppingCart.getEleId() / 1000; // 获取千位数
            firstDigit = firstDigit % 10; // 获取首位数字

            // 根据首位数字判断商品类型
            switch (firstDigit) {
                case 3:
                    log.info("查询车辆价格");
                    try {
                        // 查询车辆信息
                        Vehicles vehicle = vehiclesService.getById(shoppingCart.getEleId());
                        price = vehicle.getPrice();
                        name = vehicle.getVehicleModel();
                    } catch (Exception e) {
                        log.error("Error querying vehicle info: ", e);
                    }
                    break;
                case 1:
                    log.info("查询景点价格");
                    try {
                        // 查询景点信息
                        ScenicSpots scenicSpot = scenicSpotsService.getById(shoppingCart.getEleId());
                        price = scenicSpot.getPrice();
                        name = scenicSpot.getName();
                    } catch (Exception e) {
                        log.error("Error querying scenic spot info: ", e);
                    }
                    break;
                default:
                    log.warn("Unsupported element ID format.");
                    return; // 对于不支持的类型，直接返回，不再继续处理
            }

            // 设置购物车项信息
            if (name != null && price != null) { // 确保数据完整
                shoppingCartVO.setPrice(price);
                shoppingCartVO.setName(name);
                shoppingCartVO.setId(shoppingCart.getEleId());
                shoppingCartVO.setCount(shoppingCart.getEleCount());
                shoppingCartVO.setPicture(shoppingCart.getElePhoto());
                cartList.add(shoppingCartVO);
            }
        });

        return Result.success(cartList);
    }

//    删除购物车中的商品
    @DeleteMapping("del")
    public Result deleteCart(@RequestBody ShoppingDelDto shoppingDelDto) {
    
        // 检查ids是否为null或空数组
        if (shoppingDelDto.getIds() == null || shoppingDelDto.getIds().length == 0) {
            return Result.error("未提供有效的商品ID");
        }
        // 获取当前用户ID
        Integer userId = BaseContext.getCurrentId();
        // 检查userId是否为null
        if (userId == null) {
            return Result.error("用户ID无效");
        }
        String[] ids = shoppingDelDto.getIds();
        // 根据用户id和ids删除购物车中的商品
        shoppingCartService.deleteByIds(userId, ids);
        return Result.success();
    }

//    创建订单
    @GetMapping("order/{id}")
    public Result<Orders> getOrder(@PathVariable("id") Integer id) {

//        Orders order = orderService.getById(id);

        return Result.success();
    }
}