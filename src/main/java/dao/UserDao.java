package dao;

import org.apache.ibatis.annotations.Param;

import entity.User;

public interface UserDao {
  User selectByNameAndPwd(@Param("name")String name,@Param("pwd")String pwd);

}
