package com.easy.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Packge com.easy.security.service
 * @Autor linNaibin
 * @Description 自定义认证service
 * @Version 1.0
 * @Date 2021/2/3 16:14
 */

@Component
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        // 从数据库中取出用户信息
        String password ="";
        // 判断用户是否存在
        if(password == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 权限
        Collection<GrantedAuthority> authorities = new ArrayList<>();


        authorities.add(new SimpleGrantedAuthority("角色名"));


        return new User(userName,password,null);
    }
}
