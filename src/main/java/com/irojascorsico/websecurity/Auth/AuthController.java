package com.irojascorsico.websecurity.Auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;

    @PostMapping(value="register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
       return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping(value="authenticate")
    public ResponseEntity<AuthResponse>  authenticate(@RequestBody AuthRequest request) {
       return ResponseEntity.ok(authService.authenticate(request)) ;
    }
    
}
