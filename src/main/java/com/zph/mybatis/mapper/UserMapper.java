package com.zph.mybatis.mapper;

import java.util.List;

import com.zph.mybatis.pojo.User;

/**
 * @auther zph
 * @date 2022/8/6 - 19:10
 */
public interface UserMapper {
   int insertUser();

   int deleteUser();

   int updateUser();

   User selectUser();

   List<User> selectUsers();
}
