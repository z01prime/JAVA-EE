package service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.EmplDao;
import entity.Empl;
import service.EmplService;
import util.MybatisUtil;

public class EmplServiceImpl implements EmplService {

	@Override
	public List<Empl> selectAll() {
		SqlSession session=null;
		List<Empl> list =null;
		try {
			session = MybatisUtil.getSqlSession();
			EmplDao dao = session.getMapper(EmplDao.class);
			 list = dao.selectAll();
			session.commit();
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
		return list;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		SqlSession session=null;
		try {
			session = MybatisUtil.getSqlSession();
			EmplDao dao = session.getMapper(EmplDao.class);
			
			dao.delete(id);
			session.commit();
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

	@Override
	public void insert(Empl e) {
		// TODO Auto-generated method stub
				SqlSession session=null;
				try {
					session = MybatisUtil.getSqlSession();
					EmplDao dao = session.getMapper(EmplDao.class);
					
					dao.insert(e);
					session.commit();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					try {
						session.rollback();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						throw new RuntimeException(e2);
					}
					throw new RuntimeException(e1);
				}finally {
					MybatisUtil.closeSqlSession(session);
				}
		
	}

	@Override
	public void update(Empl em) {
		// TODO Auto-generated method stub
		SqlSession session=null;
		try {
			session = MybatisUtil.getSqlSession();
			EmplDao dao = session.getMapper(EmplDao.class);
			
			dao.update(em);
			session.commit();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			try {
				session.rollback();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e2);
			}
			throw new RuntimeException(e1);
		}finally {
			MybatisUtil.closeSqlSession(session);
		}

	}

	@Override
	public Empl selectById(int id) {
		SqlSession session=null;
		Empl em =null;
		try {
			session = MybatisUtil.getSqlSession();
			EmplDao dao = session.getMapper(EmplDao.class);
			 em = dao.selectById(id);
			session.commit();
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
		return em;
	}
		//Ä£ºý²éÑ¯
	@Override
	public List<Empl> selectMohu(String name, String ageBegin, String ageEnd,String dept) {
		SqlSession session=null;
		List<Empl> list =null;
		try {
			session = MybatisUtil.getSqlSession();
			EmplDao dao = session.getMapper(EmplDao.class);
			 list = dao.selectMohu(name, ageBegin, ageEnd,dept);
			session.commit();
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
		return list;
	}

	@Override
	public void deleteMany(List<Integer> ids) {
		SqlSession session =null;
		try {
			 session = MybatisUtil.getSqlSession();
			EmplDao dao = session.getMapper(EmplDao.class);
			dao.deleteMany(ids);
			session.commit();
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
