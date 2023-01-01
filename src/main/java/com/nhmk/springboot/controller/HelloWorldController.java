package com.nhmk.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //Http Get request
    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}
