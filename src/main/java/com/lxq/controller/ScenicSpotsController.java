package com.lxq.controller;

import com.lxq.constant.MessageConstant;
import com.lxq.pojo.entity.ScenicSpots;
import com.lxq.result.Result;
import com.lxq.service.ScenicSpotsService;
import com.lxq.utils.AliOssUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @Author: lxq
 * @Date: 2024/3/29 21:48
 */
@RestController
@Slf4j
@RequestMapping("spots")
@RequiredArgsConstructor
public class ScenicSpotsController {


    private final ScenicSpotsService scenicSpotsService;
    @Autowired(required = false)
    private AliOssUtil aliOssUtil;


    //TODO: 图片上传,阿里云OSS，返回图片地址，还未测试
    @PostMapping("upload")
    public Result<String> uploadImage(MultipartFile file){
        log.info("图片上传");
        try {
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String objName = UUID.randomUUID().toString() + extension;
            String filePath = aliOssUtil.upload(file.getBytes(), objName);
            return Result.success(filePath);
        } catch (IOException e) {
            log.error("图片上传失败");
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }


    //新增景点
    @PostMapping("add")
    public Result addSpots(@RequestBody ScenicSpots spots){
        log.info("新增景点:{}",spots);
        scenicSpotsService.save(spots);
        return Result.success();
    }
}















