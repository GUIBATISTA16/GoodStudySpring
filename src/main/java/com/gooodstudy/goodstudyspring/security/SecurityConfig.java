package com.gooodstudy.goodstudyspring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers(
                                "/",
                                "/login",
                                "/createaccount",
                                "/home",
                                "/api/user/save",
                                "/api/especialidades",
                                "/css/**",
                                "/img/**",
                                "/js/**"
                        )
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin((form) -> form
                        .loginPage("/")
                        .permitAll()
                )
                .exceptionHandling(exp -> exp.authenticationEntryPoint(jwtAuthenticationEntryPoint) )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
        return new CustomAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return jwtUserDetailsService;
    }

}
