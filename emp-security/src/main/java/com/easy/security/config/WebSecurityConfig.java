package com.easy.security.config;

import com.easy.security.filter.JwtLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

/**
 * @Packge com.easy.security.config
 * @Autor linNaibin
 * @Description 安全配置类 : <br/>
 * 1. 访问路径URL的授权策略，如登录、Swagger访问免登录认证等
 * <p>
 * 2. 指定了登录认证流程过滤器 JwtLoginFilter，由它来触发登录认证
 * <p>
 * 3. 指定了自定义身份认证组件 JwtAuthenticationProvider，并注入 UserDetailsService
 * <p>
 * 4. 指定了访问控制过滤器 JwtAuthenticationFilter，在授权时解析令牌和设置登录状态
 * <p>
 * 5. 指定了退出登录处理器，因为是前后端分离，防止内置的登录处理器在后台进行跳转
 * @Version 1.0
 * @Date 2021/2/3 15:38
 */
@Configuration
@EnableWebSecurity //开启 Security 服务
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启全局 Security 注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义登录身份认证组件

        //
        // 这里我们还指定了密码的加密方式（5.0 版本强制要求设置），因为我们数据库是明文存储的，所以明文返回即可
        // BCryptPasswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
        http.cors().and().csrf().disable();
        //  http.formLogin().loginProcessingUrl("/login22233");
        //         .and()
        //         .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
        //  .anyRequest()               // 任何请求,登录后可以访问
        //        .authenticated()

        //   http.formLogin().loginPage("https://www.baidu.com")
        ///           .and()

        // 定义哪些URL需要被保护、哪些不需要被保护  >>>>
        http.authorizeRequests()
                // 跨域预检请求
                // OPTIONS
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // 登录URL
                //.antMatchers("/login").permitAll()

                // swagger
                // 规定 xx url 拥有全部权限
                .antMatchers("/swagger**/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                //    .antMatchers("/v2/**").hasAuthority("query_user")
                // 其他所有请求需要身份认证
                .anyRequest().authenticated()
                .and()
                .logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
        // .and().addFilterBefore(new JwtLoginFilter(), UsernamePasswordAuthenticationFilter.class)
        ;


        // 退出登录处理器
        // http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
        // 开启登录认证流程过滤器
        // http.addFilterBefore(new JwtLoginFilter(), UsernamePasswordAuthenticationFilter.class);
        // 访问控制时登录状态检查过滤器
        //  http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);

        //                // 登录成功后的处理器  - 方式②
        ////                .successHandler((req, resp, authentication) -> {
        ////                    resp.setContentType("application/json;charset=utf-8");
        ////                    PrintWriter out = resp.getWriter();
        ////                    out.write("登录成功...");
        ////                    out.flush();
        ////                })
        //                // 配置登录失败的回调
        //                .failureHandler((req, resp, exception) -> {
        //                    resp.setContentType("application/json;charset=utf-8");
        //                    PrintWriter out = resp.getWriter();
        //                    out.write("登录失败...");
        //                    out.flush();
        //                })
        //                .permitAll()//和表单登录相关的接口统统都直接通过
        //                .and()
        //                .logout().logoutUrl("/logout")
        //                // 配置注销成功的回调
        //                .logoutSuccessHandler((req, resp, authentication) -> {
        //                    resp.setContentType("application/json;charset=utf-8");
        //                    PrintWriter out = resp.getWriter();
        //                    out.write("注销成功...");
        //                    out.flush();
        //                })

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**");
    }
}
