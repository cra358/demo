package com.chenxw.demo.mapper;

import com.chenxw.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
    List<User> getUserByUsername(@Param("username") String username);

    int insertUser(User user);

    int queryScoreById(@Param("id") Long id);

    int updateScoreById(@Param("id") Long id, @Param("score") Integer score);

    List<User> getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
