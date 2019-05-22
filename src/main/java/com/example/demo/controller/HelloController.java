package com.example.demo.controller;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Dto.User;
import com.example.demo.Dto.XDResponse;
import com.example.demo.Serviece.OrderService;
import com.example.demo.configBean.TestConfigBean;
import com.example.demo.configBean.XdConfigBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
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

@Api(value="用户controller",tags={"用户操作接口"})
@Controller
@EnableConfigurationProperties({XdConfigBean.class, TestConfigBean.class})
public class HelloController {

    public final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    XdConfigBean xdConfigBean;

    @Autowired
    TestConfigBean testConfigBean;

    @Autowired
    private OrderService orderService;

    @ApiOperation(value="测试接口0", notes="用于第一个测试的接口",tags={"标签0"}, response = XDResponse.class)
    @RequestMapping(value="/hello",method = RequestMethod.POST)
    @ResponseBody
    public XDResponse hello(@RequestBody @Valid @ApiParam(name="用户对象",value="传入json格式",required=true) User u) {
        logger.info("name={}=======,want={},u={}", testConfigBean.getName(), testConfigBean.getWant(),u);
        User user=new User();
        user.setName("asd");
        user.setAge(10);
        return XDResponse.success(user);
    }

    @RequestMapping(value="/order",method = RequestMethod.POST)
    @ResponseBody
    public XDResponse hello2(@RequestBody OrderDto orderDto) {
        return XDResponse.success(orderService.handle(orderDto));
    }

}


