package com.gooodstudy.goodstudyspring.security;


import com.gooodstudy.goodstudyspring.model.Dados;
import com.gooodstudy.goodstudyspring.repository.DadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;


public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    DadosRepository dadosRepository;


    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Dados utilizador = dadosRepository.findByEmail(authentication.getName());
        if (utilizador != null) {
            if (bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), utilizador.getPassword())) {
                List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
                /*
                TODO quando o utilizador tiver roles no modelo de dados deve descomentar este código e adaptar para criar os SimpleGrantedAuthority
                TODO que serão os roles correspondentes às autorizações concedidas ao utilizador
                for (Role role : utilizador.get().getRoleSet()) {
                    grantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));
                }*/
                return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), grantedAuthorityList);
            } else {
                throw new BadCredentialsException("Wrong Password");
            }
        } else {
            throw new BadCredentialsException("Wrong Email");
        }
    }
}