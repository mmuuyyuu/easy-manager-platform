package com.easy.security.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Packge com.easy.security.interceptor
 * @Autor linNaibin
 * @Description 动态配置用户权限 antMatchers("/getUser").hasAuthority("query_user") ，
 * @Version 1.0
 * @Date 2021/2/7 17:07
 */
public class CustomizeAbstractSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private FilterInvocationSecurityMetadataSource securityMetadataSource;

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return null;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      //  FilterInvocation fi = new FilterInvocation(servletRequest, servletResponse, filterChain);
      //  invoke(fi);
    }

    @Override
    public void destroy() {

    }
}
