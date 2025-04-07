package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ComUser;
import service.ComUserService;
import service.impl.ComUserServiceImpl;
@WebServlet("/reg")
public class RegistServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path=req.getContextPath();
		String name=req.getParameter("name");
		String pwd1=req.getParameter("pwd1");
		String pwd2=req.getParameter("pwd2");

		ComUserService us=new ComUserServiceImpl();
		boolean ifRegist=us.regist(name, pwd1, pwd2);
		if(ifRegist){
		           us.insert(new ComUser(5,name,pwd1));
			res.sendRedirect(path+"/login");
		}else {
			res.sendRedirect(path+"/reg");
		}
	}

}
