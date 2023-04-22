package com.irojascorsico.websecurity.Users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    
    private final UserService userService;

    @GetMapping()
    public List<User> getUsers(@RequestParam String param) {
        return  userService.getUsers();
    }
    
}
