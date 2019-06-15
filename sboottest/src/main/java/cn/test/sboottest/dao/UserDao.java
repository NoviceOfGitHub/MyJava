package cn.test.sboottest.dao;

import cn.test.sboottest.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select({"select * from user"})
    List<User> listAll();

    @Insert({"insert into user('name','password','email','age')values(#{name},#{password},#{email},#{age})"})
    int insert(User user);

    @Delete({"delete from user where id = #{userId}"})
    int remove(Integer userId);

    @Update({"update user set  name = #{username},password = #{password},email = #{email},age = #{age} where id = #{id}"})
    int update(User user);
}
