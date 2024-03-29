package com.lxq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SelfDrivingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelfDrivingApplication.class, args);
        log.info("服务启动成功");
    }

}
