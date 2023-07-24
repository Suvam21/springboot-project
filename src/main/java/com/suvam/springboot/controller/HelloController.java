package com.suvam.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                          // It will automatically be considered as an component 
public class HelloController {
    
    @GetMapping("/")               // This annotation is used to map the request to the method
    public String sayHi() {
        return "First SpringBoot Application, with dev tools ";
    }

}