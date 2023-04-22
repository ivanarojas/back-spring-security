package com.irojascorsico.websecurity.Auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @PostMapping(value="register")
    public String register(@RequestBody AuthRequest authRequest) {
        return "register is called";
    }
    
}
