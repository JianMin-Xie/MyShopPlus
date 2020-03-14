package com.xjm.myshop.plus.business.service;

import com.google.common.collect.Lists;
import com.xjm.myshop.plus.provider.api.UmsAdminService;
import com.xjm.myshop.plus.provider.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xjm
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //给每个用户授权 USER 权限
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(grantedAuthority);


        UmsAdmin umsAdmin = umsAdminService.get(s);
        //账号存在
        if (umsAdmin != null) {
            return new User(umsAdmin.getUsername(),umsAdmin.getPassword(),grantedAuthorities);
        }
        //账号不存在
        else{
            return null;
        }
    }
}
