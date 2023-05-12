package com.zt.controller;

import com.zt.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {
    // 原始方式
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request) {
        // 获取请求参数
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("name: " + name +"; age :" + age);
        return "OK";
    }

    //
    @RequestMapping("/simpleParam2")
    public String simpleParam2(@RequestParam(name = "name", required = false) String username, Integer age) {
        // 获取请求参数
        System.out.println("name: " + username +"; age :" + age);

        return "OK";
    }

    // 实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "OK";
    }

    // 数组参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }
    // 集合参数
    @RequestMapping("/listParam")
    public String listParam(@RequestParam  List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }

    // 日期请求参数
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "OK";
    }

    // JSON 请求参数
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "OK";
    }

    // 路径请求参数
    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id + name);
        return "OK";
    }
}
