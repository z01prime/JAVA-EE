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
@WebServlet("/admin/showOne")
public class showOne extends HttpServlet {
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

			@Override
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
				int id=Integer.parseInt(req.getParameter("id"));			
				
				EmplService es = new EmplServiceImpl();
				 Empl empl = es.selectById(id);
				 
				 req.setAttribute("empl", empl);

					DeptService ds = new DeptServiceImpl();
					List<Dept> list = ds.selectAll();

					req.setAttribute("dept", list);
				 
				 req.getRequestDispatcher("/updateEmp.jsp").forward(req, res);
				 
				
		}
}
