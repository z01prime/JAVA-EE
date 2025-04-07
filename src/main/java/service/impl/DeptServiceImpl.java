package service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.DeptDao;
import entity.Dept;
import service.DeptService;
import util.MybatisUtil;

public class DeptServiceImpl implements DeptService {

	@Override
	public List<Dept> selectAll() {
		SqlSession session=null;
		List<Dept> list =null;
		try {
			session = MybatisUtil.getSqlSession();
			DeptDao dao = session.getMapper(DeptDao.class);
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

}
