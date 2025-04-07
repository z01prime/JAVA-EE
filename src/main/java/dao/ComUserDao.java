package dao;

import org.apache.ibatis.annotations.Param;

import entity.ComUser;

public interface ComUserDao {
	void insert(ComUser  cu);
	ComUser selectByName(String name);
	ComUser selectByNameAndPwd(@Param("name")String name,@Param("pwd")String pwd);
	

}
