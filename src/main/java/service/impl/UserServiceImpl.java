package service.impl;

import org.apache.ibatis.session.SqlSession;

import dao.UserDao;
import entity.User;
import service.UserService;
import util.MybatisUtil;

public class UserServiceImpl implements UserService {

	@Override
	public boolean iflogin(String name, String pwd) {
		SqlSession session=null;
		try {
			session = MybatisUtil.getSqlSession();
			UserDao dao = session.getMapper(UserDao.class);
			User user = dao.selectByNameAndPwd(name, pwd);
			session.commit();
			if(user==null) {
				return false;
			}
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				session.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally {
			MybatisUtil.closeSqlSession(session);
		}
		
	}

}
