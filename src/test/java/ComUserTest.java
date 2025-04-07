import dao.ComUserDao;
import entity.ComUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MybatisUtil;

public class ComUserTest {
   @Test
   public void selectByN() {
	   SqlSession session = MybatisUtil.getSqlSession();
	   ComUserDao dao = session.getMapper(ComUserDao.class);
	   ComUser cu=dao.selectByName("张三");
	   System.out.println(cu);
	   MybatisUtil.closeSqlSession(session);
   }
   @Test
   public void selectByNameAndPwd() {
	   SqlSession session = MybatisUtil.getSqlSession();
	   ComUserDao dao = session.getMapper(ComUserDao.class);
	   ComUser cu=dao.selectByNameAndPwd("张三","123456");
	   System.out.println(cu);
	   MybatisUtil.closeSqlSession(session);
   }
   @Test
   public void insert() {
	   SqlSession session = MybatisUtil.getSqlSession();
	   ComUserDao dao = session.getMapper(ComUserDao.class);
	   dao.insert(new ComUser(12,"玛雅","124578"));;
	  session.commit();
	   MybatisUtil.closeSqlSession(session);
   }
}
