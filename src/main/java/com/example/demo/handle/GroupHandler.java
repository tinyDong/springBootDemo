package com.example.demo.handle;

import com.example.demo.Dto.OrderDto;
import com.example.demo.annotation.HandlerType;
import org.springframework.stereotype.Component;

@HandlerType("2")
@Component
public class GroupHandler extends AbstractHandler{
    @Override
    public String handle(OrderDto orderDto) {
        return "处理团体订单";
    }
}
