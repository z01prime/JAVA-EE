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
@WebServlet("/admin/update")
public class UpdateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double salary=Double.parseDouble(req.getParameter("salary"));
		int age=Integer.parseInt(req.getParameter("age"));
		String sex=req.getParameter("sex");
		int idd=Integer.parseInt(req.getParameter("idd"));
		
		//调用service
		EmplService es = new EmplServiceImpl();
		es.update(new Empl(id,name,salary,age,sex,new Dept(idd)));
		
		//动态获取项目名
		String path=req.getContextPath();
		
		res.sendRedirect(path+"/admin/showAll");
		
	}
}
