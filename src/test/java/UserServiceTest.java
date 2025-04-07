import org.junit.Test;
import service.UserService;
import service.impl.UserServiceImpl;

public class UserServiceTest {
@Test
public void selectnp() {
	UserService us = new UserServiceImpl();
	boolean b = us.iflogin("����", "123456");
	System.out.println(b);
	
}
}
