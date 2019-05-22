package com.example.demo;

import com.example.demo.controller.HelloController;
import org.assertj.core.util.Strings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    public final static Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Test
    public void contextLoads() {
        try {
            int a=1/0;
        }catch (Exception e){
            logger.error("test e={}",e);
        }

    }

}
