package com.lxq.controller;

import com.lxq.pojo.dto.RouteDto;
import com.lxq.pojo.dto.VehicleDto;
import com.lxq.pojo.entity.Routes;
import com.lxq.pojo.entity.Vehicles;
import com.lxq.result.Result;
import com.lxq.service.VehiclesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lxq
 * @Date: 2024/5/27 下午11:59
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final VehiclesService vehiclesService;

    @GetMapping("getCars")
    public Result<List<VehicleDto>> getSpots(){
        // 查询所有路线信息
        log.info("查询所有车辆");
        List<VehicleDto> CarDtoList = new ArrayList<>();
        List<Vehicles> carList = vehiclesService.list();
        carList.forEach(item -> {
            VehicleDto vehicleDto = new VehicleDto();
            BeanUtils.copyProperties(item,vehicleDto);
            CarDtoList.add(vehicleDto);
        });
        return Result.success(CarDtoList);
    }

    @PostMapping("modifyCars")
    public Result<Void> modifySpot(@RequestBody VehicleDto vehicleDto){
        log.info("修改车辆信息");
        Vehicles vehicles = new Vehicles();
        BeanUtils.copyProperties(vehicleDto,vehicles);
        // 修改车辆信息
        vehiclesService.updateById(vehicles);
        return Result.success();
    }


    @PostMapping("addCars")
    public Result<Void> addSpot(@RequestBody VehicleDto vehicleDto){
        log.info("添加车辆信息");
        Vehicles vehicles = new Vehicles();
        BeanUtils.copyProperties(vehicleDto,vehicles);
        // 添加车辆信息
        vehiclesService.save(vehicles);
        return Result.success();
    }

    @DeleteMapping("deleteCars/{id}")
    public Result<Void> deleteSpot(@PathVariable Integer id){
        log.info("删除车辆信息");
        // 删除景点信息
        vehiclesService.removeById(id);
        return Result.success();
    }
}
