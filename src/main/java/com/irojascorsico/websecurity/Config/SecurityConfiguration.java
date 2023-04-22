package com.irojascorsico.websecurity.Config;

import javax.management.relation.Role;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import org.springframework.security.web.SecurityFilterChain;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http
        .csrf(csrf -> csrf
                .disable())
        .authorizeHttpRequests(authRequest -> 
            authRequest
                .requestMatchers( "/auth/**").permitAll()
                .anyRequest().authenticated());
        
        return http.build();  
    }
    
}

//https://docs.spring.io/spring-security/reference/5.8/migration/servlet/config.html
