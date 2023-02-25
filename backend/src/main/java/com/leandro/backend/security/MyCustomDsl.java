package com.leandro.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.leandro.backend.filter.CustomAuthenticationFilter;
import com.leandro.backend.filter.CustomAuthorizationFilter;

public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity>{
    
    //@Autowired
    //private ApplicationContext applicationContext;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        ApplicationContext appcontext = http.getSharedObject(ApplicationContext.class);
        http.addFilter(new CustomAuthenticationFilter(authenticationManager, appcontext))
            .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    public static MyCustomDsl customDsl() {
        return new MyCustomDsl();
    }

}
