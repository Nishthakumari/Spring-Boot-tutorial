package com.jwt.jwtauthentication.controller;


import com.jwt.jwtauthentication.services.CustomUserDetailService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @RequestMapping(value = "/token" , method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(){

    }
}
