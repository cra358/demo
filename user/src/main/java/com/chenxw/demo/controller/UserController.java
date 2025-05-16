package com.chenxw.demo.controller;

import com.chenxw.demo.pojo.User;
import com.chenxw.demo.response.Response;
import com.chenxw.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public Response<String> register(@RequestBody User user) {
         return userService.register(user);
    }

    @PostMapping("/user/login")
    public Response<String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.login(username, password);
    }
    @GetMapping("/user/queryScore")
    public Response<String> queryScore() {
        return userService.queryScore();
    }
    @PostMapping("/user/logout")
    public Response<String> logout() {
        return userService.logout();
    }


}
