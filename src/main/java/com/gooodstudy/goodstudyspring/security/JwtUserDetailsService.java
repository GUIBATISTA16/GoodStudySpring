package com.gooodstudy.goodstudyspring.security;

import com.gooodstudy.goodstudyspring.model.Dados;
import com.gooodstudy.goodstudyspring.repository.DadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    DadosRepository dadosRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Dados person = dadosRepository.findByEmail(email);

        if(person == null)
                throw new UsernameNotFoundException("User not found with email: " + email);

        return new User(email, person.getPassword(),true,true,true,true,new ArrayList<>());
    }



    private List<GrantedAuthority> getGrantedAuthorities() {
        /*List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;*/
        // TODO
        return null;
    }
}