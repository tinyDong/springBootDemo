package com.example.demo.GlobleExceptionHandler;

import com.example.demo.Dto.XDResponse;
import com.example.demo.controller.HelloController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class ExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public XDResponse allExceptionHandler(HttpServletRequest request,
                                          Exception exception) throws Exception {
        if (exception instanceof MethodArgumentNotValidException){
            logger.error("参数错误",exception);
            return XDResponse.failure(request.getRequestURI()+"接口"+ ((MethodArgumentNotValidException) exception).getBindingResult().getFieldError().getDefaultMessage());
        }
        return XDResponse.sysError();
    }
}
