package com.example.demo.handle;

import com.example.demo.Dto.OrderDto;

public abstract class AbstractHandler {
    abstract public String handle(OrderDto orderDto);
}
