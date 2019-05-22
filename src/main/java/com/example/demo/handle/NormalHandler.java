package com.example.demo.handle;

import com.example.demo.Dto.OrderDto;
import com.example.demo.annotation.HandlerType;
import org.springframework.stereotype.Component;

@HandlerType("1")
@Component
public class NormalHandler extends AbstractHandler{
    @Override
    public String handle(OrderDto orderDto) {
        return "处理普通订单";
    }
}
