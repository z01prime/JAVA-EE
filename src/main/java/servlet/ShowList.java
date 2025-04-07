package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Dept;
import entity.Empl;
import service.DeptService;
import service.EmplService;
import service.impl.DeptServiceImpl;
import service.impl.EmplServiceImpl;
@WebServlet("/list")
public class ShowList extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	//收参
			String name=req.getParameter("name");
			String ageBegin=req.getParameter("ageBegin");
			String ageEnd=req.getParameter("ageEnd");
			String dept=req.getParameter("dept");
			
			//调用service
			
			DeptService ds = new DeptServiceImpl();
			List<Dept> dept1 = ds.selectAll();
					
			//list存入作用域
			req.setAttribute("dept1", dept1);
			
			//list进作用于
			
	//调用service
	EmplService es=new EmplServiceImpl();
	
	List<Empl> list1 = es.selectMohu(name, ageBegin, ageEnd,dept);
	//将list放入作用域
	req.setAttribute("list", list1);
	
	
	//转发到jsp页面
	req.getRequestDispatcher("/list.jsp").forward(req, res);
	
}
}
