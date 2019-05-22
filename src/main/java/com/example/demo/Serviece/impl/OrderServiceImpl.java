package com.example.demo.Serviece.impl;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Serviece.OrderService;
import com.example.demo.handle.AbstractHandler;
import com.example.demo.handle.HandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private HandlerContext handlerContext;

    @Override
    public String handle(OrderDto orderDto) {
        try {
            AbstractHandler handler = handlerContext.getInstance(orderDto.getType());
            return handler.handle(orderDto);
        } catch (Exception e) {
            log.info("e = ",e);
        }
        return "失败";
    }
}
