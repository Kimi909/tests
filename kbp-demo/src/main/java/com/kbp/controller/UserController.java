package com.kbp.controller;

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


    @PostMapping("/post")
    public  String postStr(){
        return  "post------" + "abcdasdfghjkl";
    }

    @GetMapping("/get")
    public String getStr(){
        return  "get------" + "hhhhhhhhhhhhhh";
    }

}
