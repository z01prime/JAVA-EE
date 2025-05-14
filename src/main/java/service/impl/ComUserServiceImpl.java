package service.impl;


import org.apache.ibatis.session.SqlSession;

import dao.ComUserDao;
import entity.ComUser;
import service.ComUserService;
import util.MybatisUtil;

public class ComUserServiceImpl implements ComUserService{

	public boolean login(String name, String pwd) {
		SqlSession session=MybatisUtil.getSqlSession();
		try {			 
			ComUserDao ud=session.getMapper(ComUserDao.class);
			ComUser u=ud.selectByNameAndPwd(name, pwd);
			session.commit();
			if(u==null){
				return false;
			}else {
				return true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				session.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.closeSqlSession(session);
		}		
		
	}

	public boolean regist(String name, String pwd1, String pwd2) {
		SqlSession session=MybatisUtil.getSqlSession();
		boolean ifregist=false;
		try {
			 
			    ComUserDao dao = session.getMapper(ComUserDao.class);
			   ComUser cu=dao.selectByName(name);
			if(name!=null&&pwd1!=null&&pwd2!=null&&!name.equals("")&&!pwd1.equals("")&&!pwd2.equals("")&&pwd1.equals(pwd2)&&cu==null){
				
				ifregist= true;
			}
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				session.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException("名字查询异常");
		}finally{
			MybatisUtil.closeSqlSession(session);
		}
		return ifregist;
	}

	public void insert(ComUser u) {
		SqlSession session=MybatisUtil.getSqlSession();
		try {
			 
			ComUserDao ud=session.getMapper(ComUserDao.class);
			ud.insert(u);
			session.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				session.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException("添加异常");
			}
			throw new RuntimeException("添加异常");
		}finally{
			MybatisUtil.closeSqlSession(session);
		}
		
	}

}
