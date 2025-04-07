package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Dept;
import service.DeptService;
import service.impl.DeptServiceImpl;
@WebServlet("/admin/addone")
public class DeptServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//调用service获取部门
		DeptService ds = new DeptServiceImpl();
		List<Dept> list = ds.selectAll();
				
		//list存入作用域
		req.setAttribute("deptl", list);
		 
		req.getRequestDispatcher("/addEmp.jsp").forward(req, res);
		
	}

}
