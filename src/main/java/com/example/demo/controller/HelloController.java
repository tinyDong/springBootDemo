package com.example.demo.controller;

import com.example.demo.Dto.User;
import com.example.demo.Dto.XDResponse;
import com.example.demo.configBean.TestConfigBean;
import com.example.demo.configBean.XdConfigBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;


@Controller
@EnableConfigurationProperties({XdConfigBean.class, TestConfigBean.class})
public class HelloController {

    public final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    XdConfigBean xdConfigBean;

    @Autowired
    TestConfigBean testConfigBean;

    @RequestMapping(value="/hello",method = RequestMethod.POST)
    @ResponseBody
    public XDResponse index(@RequestBody @Valid User u) {
        logger.info("name={}=======,want={},u={}", testConfigBean.getName(), testConfigBean.getWant(),u);
        User user=new User();
        user.setName("asd");
        user.setAge(10);
        return XDResponse.success(user);
    }

}


