package com.irojascorsico.websecurity.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.irojascorsico.websecurity.Config.JwtService;
import com.irojascorsico.websecurity.Users.Role;
import com.irojascorsico.websecurity.Users.User;
import com.irojascorsico.websecurity.Users.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
   

   public  AuthResponse register(RegisterRequest request)
   {
        User user= User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();

        userRepository.save(user);

        var jwtToken =jwtService.generateToken(user);

        return AuthResponse.builder()
            .token(jwtToken)
            .build();
   }

    public AuthResponse authenticate(AuthRequest request) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

            var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            return AuthResponse.builder()
                .token(jwtToken)
                .build();

    }
}
