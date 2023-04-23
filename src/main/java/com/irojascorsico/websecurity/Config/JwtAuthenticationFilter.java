package com.irojascorsico.websecurity.Config;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {@Override
    
    protected void doFilterInternal(@NonNull HttpServletRequest request, @Nonnull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        
                final String authHeader = request.getHeader("Authorizadion");
                if (authHeader== null || !authHeader.startsWith("Bearer "))
                {
                    filterChain.doFilter(request, response);
                    return;
                }
                filterChain.doFilter(request, response);
    }
    
}
