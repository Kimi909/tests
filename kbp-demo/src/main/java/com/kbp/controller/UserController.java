package com.kbp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/9/28.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user){

        return  user;

    }

    @PostMapping("/post")
    public  String postStr(){
        return  "post------" + "abcdasdfghjkl";
    }

    @GetMapping("/get")
    public String getStr(){
        return  "get------" + "hhhhhhhhhhhhhh";
    }

}
