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
@WebServlet("/admin/showAll")
public class ShowAllServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DeptService ds = new DeptServiceImpl();
		List<Dept> dept1 = ds.selectAll();
				
		//list存入作用域
		req.setAttribute("dept1", dept1);
		//调用service
		EmplService es=new EmplServiceImpl();
		List<Empl> list = es.selectAll();
		//将list放入作用域
		req.setAttribute("list", list);
		
		//转发到jsp页面
		req.getRequestDispatcher("/emplist.jsp").forward(req, res);
		
	}

}
