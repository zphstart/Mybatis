package com.zph.mybatis.mapper;

import java.util.List;

import com.zph.mybatis.pojo.User;

/**
 * @auther zph
 * @date 2022/8/6 - 23:33
 */
public interface UserMapper {

    List<User> selectUsers();
}
