package com.irojascorsico.websecurity.Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping
    public String getMethodName() {
        return "Hello from protected method";
    }

    
}
