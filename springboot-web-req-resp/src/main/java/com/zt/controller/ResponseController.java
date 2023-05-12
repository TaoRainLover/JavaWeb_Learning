package com.zt.controller;

import com.zt.pojo.Address;
import com.zt.pojo.Emp;
import com.zt.pojo.Result;
import com.zt.pojo.User;
import com.zt.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResponseController {
    @RequestMapping("/helloWorld")
    public Result helloWorld(){
        String str = "Hello World!";
        return Result.success(str);
    }

    @RequestMapping("/getUser")
    public Result getUser(){
        User usr = new User("张三", 19, new Address("四川", "成都"));
        return Result.success(usr);
    }



}
