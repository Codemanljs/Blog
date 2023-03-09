package com.ljs.blog.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ljs
 * @create 2023-03-09 15:15
 */
@Configuration
public class MybatisConfig {

    /*@Bean
    public SqlSession getSqlSession(){
        String resources="mybatis-config.xml";
        InputStream resource = null;
        try {
            resource = Resources.getResourceAsStream(resources);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            return sqlSession;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                resource.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }*/

}
