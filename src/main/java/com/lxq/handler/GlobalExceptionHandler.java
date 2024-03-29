package com.lxq.handler;

import com.lxq.exception.BaseException;
import com.lxq.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: lxq
 * @Date: 2024/3/29 16:23
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result exceptionHandler(BaseException e) {
        log.error("全局异常信息：{}",e.getMessage());
        return Result.error(e.getMessage());
    }
}
