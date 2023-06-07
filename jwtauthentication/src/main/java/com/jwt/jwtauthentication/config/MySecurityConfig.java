package com.jwt.jwtauthentication.config;

import com.jwt.jwtauthentication.services.CustomUserDetailService;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfiguration {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    public Filter springSecurityFilterChain() throws Exception {    }

}
