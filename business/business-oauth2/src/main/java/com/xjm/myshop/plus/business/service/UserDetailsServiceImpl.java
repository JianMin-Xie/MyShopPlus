package com.xjm.myshop.plus.business.service;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String USERNAME="admin";
    private static final String PASSWORD="$2a$10$JzhLlBb4io2CjdQ5VEYbiuq7tswKkJrBAJfzsIEaVmVWZTebQWPj2";

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();

        return new User(USERNAME, PASSWORD, grantedAuthorities);
    }
}
