package com.easy.controller;


import com.easy.pojo.VO.UserInfoVo;
import com.easy.result.EasyResult;
import com.easy.service.EasyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Packge com.easy.controller
 * @Autor linNaibin
 * @Description 算术公式 controller
 * @Version 1.0
 * @Date 2020/12/18 16:47
 */
@RequestMapping("/")
@Api(tags = "登录模块")
@Controller
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    private EasyService symbolService;

    @Autowired
    public LoginController(EasyService symbolService) {
        this.symbolService = symbolService;
    }

    @ApiOperation(value = "登录", notes = "登录")
    @ResponseBody
    @PostMapping("/login222")
    public EasyResult<Object> login(@RequestBody UserInfoVo user) {
        LOG.info("开始获取算数公式...");

        return EasyResult.success(null);
    }


}
