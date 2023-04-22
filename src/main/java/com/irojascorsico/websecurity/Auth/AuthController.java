package com.irojascorsico.websecurity.Auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irojascorsico.websecurity.Users.Role;
import com.irojascorsico.websecurity.Users.User;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    
    private final AuthService userService;

    @PostMapping(value="register")
    public void register(@RequestBody AuthRequest authRequest) {
       
       User user= new User();
       user.setEmail(authRequest.getEmail());
       user.setPassword(authRequest.getPassword()); 
       user.setFirstName(authRequest.getFirstName());
       user.setLastName(authRequest.getLastName());
       user.setRole(Role.USER);

       userService.saveUser(user);  
    }
    
}
