import entity.Dept;
import entity.Empl;
import org.junit.Test;
import service.EmplService;
import service.impl.EmplServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class EmplServiceTest {
	@Test
	public void selectAll() {
		EmplService es=new EmplServiceImpl();
		List<Empl> list = es.selectAll();
		for (Empl empl : list) {
			System.out.println(empl);
		}
	}
	@Test
	public void delete() {
		EmplService es = new EmplServiceImpl();
		es.delete(3);
	}
	@Test
	public void insert() {
		EmplService es = new EmplServiceImpl();
		es.insert(new Empl(12,"˹�ʹ�",5660,24,"��",new Dept(3,"���²�")));
	}
	@Test
	public void update() {
		EmplService es=new EmplServiceImpl();
		es.update(new Empl(1,"���",4500,22,"Ů",new Dept(1,"������")));
	}
	@Test
	public void selectById() {
		EmplService es=new EmplServiceImpl();
		Empl e = es.selectById(3);
		System.out.println(e);
	}
	@Test
	public void mohu() {
		EmplService es=new EmplServiceImpl();
		List<Empl> list = es.selectMohu(null, "18", "22","1");
		System.out.println(list);
	}
	@Test
	public void deletemany() {
		EmplService es=new EmplServiceImpl(); 
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		es.deleteMany(ids);
	
	}

}
