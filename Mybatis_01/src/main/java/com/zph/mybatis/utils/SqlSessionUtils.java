package com.zph.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @auther zph
 * @date 2022/8/6 - 23:46
 */
public class SqlSessionUtils {

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;  //设置jdbc中的事务提交为自动提交，默认为手动提交
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = sqlSessionFactoryBuilder.build(is);
            sqlSession = factory.openSession(true);
        } catch (IOException e) {
            System.out.println("获取mybatis核心配置文件失败");
        } finally {
            return sqlSession;
        }
    }
}
