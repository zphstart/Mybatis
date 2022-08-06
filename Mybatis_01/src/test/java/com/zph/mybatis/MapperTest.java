package com.zph.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zph.mybatis.mapper.UserMapper;
import com.zph.mybatis.pojo.User;
import com.zph.mybatis.utils.SqlSessionUtils;

/**
 * @auther zph
 * @date 2022/8/6 - 19:18
 */
public class MapperTest {

    @Test
    public void userTest() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        int result = mapper.insertUser();
//        int result = mapper.deleteUser();
//        int result = mapper.updateUser();
//        sqlSession.commit();    //jdbc中事务手动提交
//        User user = mapper.selectUser();
        List<User> list = mapper.selectUsers();
        list.forEach(
                System.out::println
        );
    }

}
