package com.chenxw.demo.service;

import com.chenxw.demo.pojo.User;
import com.chenxw.demo.response.Response;

public interface UserService {

    public Response<String> register(User user);

    public Response<String> login(String username, String password);

    Response<String> queryScore();

    Response<String> logout();
}
