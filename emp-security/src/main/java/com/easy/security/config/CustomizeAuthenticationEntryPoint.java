package com.easy.security.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Packge com.easy.security.config
 * @Autor linNaibin
 * @Description 默认情况下，如果没有权限，会跳转到相应的页面， 在这里，我们自定义（返回json）<br/>
 * //异常处理(权限拒绝、登录失效等)
 * and().exceptionHandling().
 * authenticationEntryPoint(authenticationEntryPoint).//匿名用户访问无权限资源时的异常处理
 * @Version 1.0
 * @Date 2021/2/7 16:46
 */
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write("{\"code\":403,\"msg\":\"权限不够\"}");
    }
}
