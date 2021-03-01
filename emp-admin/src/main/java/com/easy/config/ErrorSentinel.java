package com.easy.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.easy.result.EasyResult;

/**
 * @Packge com.easy.config
 * @Autor linNaibin
 * @Description
 * @Version 1.0
 * @Date 2021/3/1 16:27
 */
public class ErrorSentinel {

    // static
    // 参数需要一致、返回需要一致
    // since 1.6 可以添加 Throwable
    public static EasyResult<Object> error(Throwable e)   {
        System.out.println(e);
        System.out.println("进入这里了？！！");
        return EasyResult.failed(e.getMessage());
    }
    public static EasyResult<Object> block(BlockException e) {

        return EasyResult.failed("服务器熔断了");
    }
}
