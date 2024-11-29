package com.gooodstudy.goodstudyspring.controller;

import com.gooodstudy.goodstudyspring.security.*;
import com.gooodstudy.goodstudyspring.security.model.JwtRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest, HttpServletRequest httpServletRequest) throws Exception {
        return new ResponseEntity<>(authService.authenticate(authenticationRequest, httpServletRequest), HttpStatus.OK);
    }

    @PostMapping("/logoutu")
    public ResponseEntity<?> logout(HttpServletRequest httpServletRequest) {
        authService.logout(httpServletRequest);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }



}
