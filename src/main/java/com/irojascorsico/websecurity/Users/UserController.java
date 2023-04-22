package com.irojascorsico.websecurity.Users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    
    @GetMapping()
    public String getUsers(@RequestParam String param) {
        return  "Secure method is called";
    }
    
}
