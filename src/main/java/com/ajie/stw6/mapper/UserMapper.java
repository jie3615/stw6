package com.ajie.stw6.mapper;

import com.ajie.stw6.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wyj
 * @since 2022/1/17
 */
//@Mapper
public interface UserMapper {

    /**
     * 查询列表
     * @return
     */
    @Select("select * from ajie_test")
    List<User> getUserList();

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Delete("delete from ajie_test where id=#{id}")
    int deleteUser(int id);

    /**
     * 插入用户
     * @param user
     * @return
     */
    @Insert("insert into ajie_test (username,password) values (#{username},#{password})")
    int insertUser(User user);




}
