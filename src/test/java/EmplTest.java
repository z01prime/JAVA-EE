import dao.EmplDao;
import entity.Dept;
import entity.Empl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MybatisUtil;

import java.util.ArrayList;
import java.util.List;

public class EmplTest {
	@Test
	public void selectAll() {
		SqlSession session = MybatisUtil.getSqlSession();
		EmplDao dao = session.getMapper(EmplDao.class);
		List<Empl> list = dao.selectAll();
		for (Empl empl : list) {
			System.out.println(empl);
		}
	}
	@Test
	public void del() {
		SqlSession session = MybatisUtil.getSqlSession();
		EmplDao dao=session.getMapper(EmplDao.class);
		dao.delete(3);
		session.commit();
		MybatisUtil.closeSqlSession(session);
	}
	@Test
	public void insert() {
		SqlSession session = MybatisUtil.getSqlSession();
		EmplDao dao=session.getMapper(EmplDao.class);
		dao.insert(new Empl(2, "alis", 8000, 25, "Ů",new Dept(2,"���۲�")));
		session.commit();
		MybatisUtil.closeSqlSession(session);
	}
	@Test
	public void update() {
		SqlSession session = MybatisUtil.getSqlSession();
		EmplDao dao=session.getMapper(EmplDao.class);
		dao.update(new Empl(1,"���",4500,22,"Ů",new Dept(1,"������")));
		session.commit();
		MybatisUtil.closeSqlSession(session);
	}
	
	@Test
	public void selectById() {
		SqlSession session = MybatisUtil.getSqlSession();
		EmplDao dao = session.getMapper(EmplDao.class);
		Empl em=dao.selectById(2);
		System.out.println(em);
		MybatisUtil.closeSqlSession(session);
	}
	@Test
	public void mohu() {
		SqlSession session = MybatisUtil.getSqlSession();
		EmplDao dao = session.getMapper(EmplDao.class);
		List<Empl> mohu = dao.selectMohu(null,"22", "23","1");
		for (Empl empl : mohu) {
			System.out.println(empl);
		}
	}
	@Test
	public void deletemany() {
		SqlSession session = MybatisUtil.getSqlSession();
		EmplDao dao=session.getMapper(EmplDao.class);
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		dao.deleteMany(ids);
		
		MybatisUtil.closeSqlSession(session);
	}

}
