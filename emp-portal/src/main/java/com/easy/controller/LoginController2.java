package com.easy.controller;


import com.easy.pojo.VO.UserInfoVo;
import com.easy.result.EasyResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class LoginController2 {



    @Autowired
    public LoginController2() {

    }

    @ApiOperation(value = "登录", notes = "登录")
    @ResponseBody
    @PostMapping("/login22233")
    public EasyResult<Object> login(@RequestBody UserInfoVo user) {
System.out.println(" denglu ...");
        return EasyResult.success(null);
    }


}
