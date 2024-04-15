package com.lxq.controller;

import com.lxq.constant.MessageConstant;
import com.lxq.result.Result;
import com.lxq.utils.AliOssUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @Author: lxq
 * @Date: 2024/3/29 21:48
 */
@RestController
@Slf4j
@RequestMapping("upload")
@RequiredArgsConstructor
public class uploadController {

//    @Autowired(required = false)
    private final AliOssUtil aliOssUtil;


    //TODO: 图片上传,阿里云OSS，返回图片地址，还未测试
    @PostMapping("image")
    @CrossOrigin
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
}















