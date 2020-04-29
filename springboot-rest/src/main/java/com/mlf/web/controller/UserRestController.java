package com.mlf.web.controller;


import com.mlf.web.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @PostMapping(value = "/echo/user",
            consumes = "application/json;charset=UTF-8", //过滤请求头
            produces = "application/json;charset=GBK")
    public User user(@RequestBody User user){
        return user;
    }
}
