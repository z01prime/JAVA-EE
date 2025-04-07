package service;

import entity.ComUser;
public interface ComUserService {
	void insert(ComUser u);
	boolean login(String name,String pwd);
	boolean regist(String name,String pwd1,String pwd2);

}
