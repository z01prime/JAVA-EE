import dao.UserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MybatisUtil;

public class UserTest {
	@Test
	public void selectnp() {
	SqlSession session = MybatisUtil.getSqlSession();	
	UserDao dao = session.getMapper(UserDao.class);
	User user = dao.selectByNameAndPwd("admin", "123456");
	System.out.println(user);
	MybatisUtil.closeSqlSession(session);
	}

}
