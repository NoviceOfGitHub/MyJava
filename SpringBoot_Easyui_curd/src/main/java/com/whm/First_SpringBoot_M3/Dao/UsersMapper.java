package com.whm.First_SpringBoot_M3.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.whm.First_SpringBoot_M3.entity.Users;
@Repository
public interface UsersMapper {
    int deleteByPrimaryKey(Integer uid);
    int deleteByMPrimaryKey(List<Integer> list);
    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    List<Users> selectAll();
    /*使用注解*/
    //总的数据
    //Users中数据记录数
    @Select("select count(*) from users")
    public int gettstunumber( );
    //User分页展示
    @Select("select * from users limit #{startRecord},#{pageSize}")
    public List<Users> stuinfo(@Param("startRecord")int startRecord,@Param("pageSize")int pageSize);
    
    @Insert("insert into users (uid,username,realname,password,usalary,update) values(0,#{username},#{realname},#{password},#{usalary},#{update})")
    public void addusers(@Param("username") String username,@Param("realname") String realname,@Param("password") String password,@Param("usalary") int usalary,@Param("update") String update);

    
    
}