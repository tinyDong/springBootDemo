package com.example.demo.controller;

import com.example.demo.configBean.TestConfigBean;
import com.example.demo.configBean.XdConfigBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableConfigurationProperties({XdConfigBean.class, TestConfigBean.class})

public class HelloController {

    public final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    XdConfigBean xdConfigBean;

    @Autowired
    TestConfigBean testConfigBean;

    @RequestMapping("/hello")
    public String index() {
        logger.info("name={}=======,want={}", testConfigBean.getName(), testConfigBean.getWant());
        return "Hello World" + testConfigBean.getName() + testConfigBean.getWant();
    }

}


