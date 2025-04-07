package util;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {	
	public static SqlSessionFactory ssf =null;
	static {
		try {
			InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");

			ssf = new SqlSessionFactoryBuilder().build(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}	
	//��ȡsqlsession�ķ���
	public static SqlSession getSqlSession() {		
                  
		SqlSession session = ssf.openSession();
		return session;
	}
	
	
	//�ر�sqlsession�ķ���
	public static void closeSqlSession(SqlSession session) {
		if(session!=null)
		   session.close();
	} 
	
}
