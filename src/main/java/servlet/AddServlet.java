package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Dept;
import entity.Empl;
import service.EmplService;
import service.impl.EmplServiceImpl;
@WebServlet("/admin/add")
public class AddServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//收参
		String name=req.getParameter("name");
		String salary=req.getParameter("salary");
		double salaryd=Double.parseDouble(salary);
		String age=req.getParameter("age");
		int ageInt=Integer.parseInt(age);
		String sex=req.getParameter("sex");
		String id=req.getParameter("id");
		int idInt=Integer.parseInt(id);
		//调用EmplService
		
		EmplService es = new EmplServiceImpl();
		es.insert(new Empl(12,name,salaryd,ageInt,sex,new Dept(idInt)));
		
		//动态获取项目名
				String path=req.getContextPath();
				
				res.sendRedirect(path+"/admin/showAll");
	}

}
