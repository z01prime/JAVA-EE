package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ComUserService;
import service.UserService;
import service.impl.ComUserServiceImpl;
import service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//动态获取项目名
		String path=req.getContextPath();
		//收参
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		//调用service
		ComUserService cs=new ComUserServiceImpl();
		UserService us = new UserServiceImpl();
		boolean ifLogin1=cs.login(name, pwd);
		boolean ifLogin=us.iflogin(name, pwd);
		if(ifLogin) {
		HttpSession session=req.getSession();
		session.setAttribute("name",name);
		
		res.sendRedirect(path+"/admin/showAll");
	}else if (ifLogin1) {
		HttpSession session=req.getSession();
		session.setAttribute("name",name);
		
		res.sendRedirect(path+"/list");
	}else{
		
		res.sendRedirect(path+"/login.jsp");
	}
	}

}
