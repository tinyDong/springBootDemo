package com.example.demo.controller;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Collection;

/**
 * @Author: lixiaodong
 * @Date: 2021/3/10 下午2:18
 */
@Slf4j
@RestController
public class TestController {

    private Multimap<String, DeferredResult<String>> watchRequests = Multimaps.synchronizedSetMultimap(HashMultimap.create());


    @GetMapping("/watch")
    public DeferredResult test1(@RequestParam("namespace") String namespace){

        log.info("Request received");
        DeferredResult<String> deferredResult = new DeferredResult<>(30000L);
        //当deferredResult完成时（不论是超时还是异常还是正常完成），移除watchRequests中相应的watch key
        deferredResult.onCompletion(new Runnable() {
            @Override
            public void run() {
                System.out.println("remove key:" + namespace);
                watchRequests.remove(namespace, deferredResult);
            }
        });
        watchRequests.put(namespace, deferredResult);
        log.info("Servlet thread released");
        return deferredResult;
    }

    //模拟发布namespace配置
    @GetMapping(value = "/publish/{namespace}", produces = "text/html")
    public Object publishConfig(@PathVariable("namespace") String namespace) {
        if (watchRequests.containsKey(namespace)) {
            Collection<DeferredResult<String>> deferredResults = watchRequests.get(namespace);
            Long time = System.currentTimeMillis();
            //通知所有watch这个namespace变更的长轮训配置变更结果
            for (DeferredResult<String> deferredResult : deferredResults) {
                deferredResult.setResult(namespace + " changed:" + time);
            }
        }
        return "success";

    }

}
