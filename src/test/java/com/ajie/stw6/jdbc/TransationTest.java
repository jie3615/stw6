package com.ajie.stw6.jdbc;

import com.ajie.stw6.mapper.UserMapper;
import com.ajie.stw6.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

/**
 * @author wyj
 * @since 2022/1/17
 */
@SpringBootTest
public class TransationTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @Test
    public void test01() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(dataSource);
        try {
            User user = User.builder().username("ststs").password("1213").build();


            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("insert into ajie_test (username,password) values ('" + user.getUsername() + "', '" + user.getPassword() + "')");
            int i = 1 / 0;
            connection.commit();
        } catch (Exception exception) {

            exception.printStackTrace();
            connection.rollback();
        }

    }

    @Test
    public void test02() {
        System.out.println("Hello");
        System.out.println(sqlSessionFactory);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        System.out.println(userList);
        int i = mapper.deleteUser(2);
        System.out.println(i);
    }
    @Test
    public void test03() {
        System.out.println("Hello");
        System.out.println(sqlSessionFactory);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.insertUser(User.builder().username(UUID.randomUUID().toString().substring(0,8)).password(UUID.randomUUID().toString().substring(0,4)).build());
        System.out.println(i);

    }



}
