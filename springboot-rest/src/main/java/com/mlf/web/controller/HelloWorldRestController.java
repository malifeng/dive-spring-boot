package com.mlf.web.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
    @GetMapping(value = "/hello-world")
    public String helloWorld(@RequestParam(required = false) String message){
        return "Hello,World!"+message;

    }
}
