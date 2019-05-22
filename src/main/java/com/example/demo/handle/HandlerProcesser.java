package com.example.demo.handle;

import com.example.demo.annotation.HandlerType;
import com.example.demo.utils.ClassScaner;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
@Slf4j
public class HandlerProcesser implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String,Class> handlerMap  = Maps.newHashMapWithExpectedSize(3);
        ClassScaner.scan("com.example.demo.handle",HandlerType.class).forEach(clazz ->{
            HandlerType handlerType =  (HandlerType) clazz.getAnnotation(HandlerType.class);
            handlerMap.put(handlerType.value(),clazz);
        });
        HandlerContext context = new HandlerContext();
        context.setHandlerMap(handlerMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(),context);
        log.info("执行任务");
    }
}
