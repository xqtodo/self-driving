package com.lxq.config;

import com.lxq.properties.AliOssProperties;
import com.lxq.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lxq
 * @Date: 2024/3/19 20:46
 */
@Configuration
@Slf4j
public class OssConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties){
        log.info("创建阿里云文件上传工具类：{}",aliOssProperties);
        return new AliOssUtil(aliOssProperties.getEndpoint(),
                            aliOssProperties.getAccessKeyId(),
                            aliOssProperties.getAccessKeySecret(),
                            aliOssProperties.getBucketName());
    }
}
