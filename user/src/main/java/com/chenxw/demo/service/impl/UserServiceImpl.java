package com.chenxw.demo.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.chenxw.demo.holder.LoginUserId;
import com.chenxw.demo.mapper.UserMapper;
import com.chenxw.demo.pojo.User;
import com.chenxw.demo.response.Response;
import com.chenxw.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Response<String> register(User user) {
        List<User> userList = userMapper.getUserByUsername(user.getUsername());
        if (userList.size() > 0) {
            return Response.fail("用户名已存在");
        }
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        userMapper.insertUser(newUser);
        return Response.success("注册成功");
    }

    @Override
    public Response<String> login(String username, String password) {
        System.out.println(LoginUserId.getUserId());
        List<User> userList = userMapper.getUserByUsernameAndPassword(username, password);
        if (userList.size() > 0) {
            // SaToken 登录用户，并返回 token 令牌
            StpUtil.login(userList.get(0).getId());
            // 获取 Token 令牌
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return Response.success(tokenInfo.tokenValue);
        }
        return Response.fail("登陆失败");
    }

    @Override
    public Response<String> queryScore() {
        Long userId = LoginUserId.getUserId();
        int score = userMapper.queryScoreById(userId);
        return Response.success(String.valueOf(score));
    }

    @Override
    public Response<String> logout() {
        StpUtil.logout();
        int score = userMapper.queryScoreById(LoginUserId.getUserId()) + 1;
        userMapper.updateScoreById(LoginUserId.getUserId(), score);
        return Response.success("退出登陆成功");
    }
}
