import entity.Dept;
import org.junit.Test;
import service.DeptService;
import service.impl.DeptServiceImpl;

import java.util.List;

public class DeptServiceTest {
@Test
public void selectAll() {
	DeptService ds=new DeptServiceImpl();
	List<Dept> list = ds.selectAll();
	for (Dept dept : list) {
		System.out.println(dept);
	}
	
}
}
