package com.example.demo.handle;

import com.example.demo.Dto.OrderDto;
import com.example.demo.annotation.HandlerType;
import org.springframework.stereotype.Component;

@HandlerType("3")
@Component
public class PromotionHandler extends AbstractHandler{
    @Override
    public String handle(OrderDto orderDto) {
        return "处理促销订单";
    }
}
