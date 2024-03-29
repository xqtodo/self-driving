package com.lxq.exception;

/**
 * @Author: lxq
 * @Date: 2024/3/29 16:24
 */
public class BaseException extends RuntimeException{
    public BaseException(){}

    public BaseException(String message){
        super(message);
    }
}
