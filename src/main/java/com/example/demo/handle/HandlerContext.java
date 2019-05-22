package com.example.demo.handle;

import com.example.demo.utils.BeanUtils;
import com.google.common.collect.Maps;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.WebApplicationObjectSupport;

import java.util.Map;

@Data
public class HandlerContext {

    private Map<String,Class> handlerMap;

   public AbstractHandler getInstance(String type) throws IllegalAccessException, InstantiationException {
        Class clazz = handlerMap.get(type);
       if (clazz == null) {
           throw new IllegalArgumentException("not found handler for type :" + type);
       }
       return (AbstractHandler) BeanUtils.getBean(clazz);

   }
}
