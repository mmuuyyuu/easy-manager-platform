package com.easy.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.easy.config.ErrorSentinel;
import com.easy.config.SentinelConfig;
import com.easy.result.EasyResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Packge com.easy.controller
 * @Autor linNaibin
 * @Description
 * @Version 1.0
 * @Date 2021/3/1 16:03
 */
@RequestMapping("/")
@Api(tags = "hello")
@Controller
public class HelloWorldController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    @ApiOperation(value = "hello")
    @ResponseBody
    @GetMapping("/hello")
    // 指定资源名称 。（必填项，需要通过 value 值找到对应的规则进行配置）
    // 指定 fallback
    // 指定 存放fallback的类
    @SentinelResource(value = SentinelConfig.COMMON_RESOURCE, fallback = "error",fallbackClass = ErrorSentinel.class,blockHandler = "block",blockHandlerClass = ErrorSentinel.class)
    public EasyResult<Object> hello() {

        System.out.println("hello world ");
        int i =0 ;
        if(i <= 0) {
            throw  new RuntimeException(" erro r!!!");
        }

        return EasyResult.success(null);
    }
}
