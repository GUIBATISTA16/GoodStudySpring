package com.gooodstudy.goodstudyspring.security;

import com.gooodstudy.goodstudyspring.model.Dados;
import com.gooodstudy.goodstudyspring.repository.DadosRepository;
import com.gooodstudy.goodstudyspring.security.model.JwtRequest;
import com.gooodstudy.goodstudyspring.security.model.JwtResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    DadosRepository dadosRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    public JwtResponse authenticate(JwtRequest authenticationRequest, HttpServletRequest httpServletRequest) throws Exception {

        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);
        System.out.println(token);

        Dados utilizador = dadosRepository.findByEmail(authenticationRequest.getEmail());
        utilizador.setPassword(null);

        return new JwtResponse(token,utilizador);

    }

    public void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    public void logout(HttpServletRequest httpServletRequest) {
        String token = jwtTokenUtil.extractTokenFromRequest(httpServletRequest);
        if (token != null) {
            jwtTokenUtil.invalidateToken(token);
        }
        httpServletRequest.getSession().invalidate();
    }
}
