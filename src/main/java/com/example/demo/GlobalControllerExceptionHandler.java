package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: lixiaodong
 * @Date: 2021/8/6 上午10:15
 */
@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_MODIFIED)//返回304状态码
    @ResponseBody
    @ExceptionHandler(AsyncRequestTimeoutException.class) //捕获特定异常
    public void handleAsyncRequestTimeoutException(AsyncRequestTimeoutException e, HttpServletRequest request) {
        System.out.println("handleAsyncRequestTimeoutException");
    }

}
