import dao.DeptDao;
import entity.Dept;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MybatisUtil;

import java.util.List;

public class DeptTest {
@Test
public void selectAll() {
	SqlSession session = MybatisUtil.getSqlSession();
	DeptDao dao = session.getMapper(DeptDao.class);
	List<Dept> list = dao.selectAll();
	for (Dept dept : list) {
		System.out.println(dept);
	}
}
}
