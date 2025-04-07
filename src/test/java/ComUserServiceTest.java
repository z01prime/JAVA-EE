import org.junit.Test;
import service.ComUserService;
import service.impl.ComUserServiceImpl;

public class ComUserServiceTest {
@Test
public void selectN() {
	ComUserService cus=new ComUserServiceImpl();
	boolean login = cus.login("qwere", "1654");
	System.out.println(login);
}
@Test
public void reg() {
	ComUserService cus=new ComUserServiceImpl();
	boolean reg=cus.regist("make", "123456", "123456");
	System.out.println(reg);
}
}
