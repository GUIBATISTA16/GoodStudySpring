package com.gooodstudy.goodstudyspring.security;

import com.gooodstudy.goodstudyspring.model.Utilizador;
import com.gooodstudy.goodstudyspring.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UtilizadorRepository utilizadorRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Utilizador person = utilizadorRepository.findByEmail(email);

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