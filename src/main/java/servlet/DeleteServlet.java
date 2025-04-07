package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmplService;
import service.impl.EmplServiceImpl;
@WebServlet("/admin/delete")
public class DeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		

		String id=req.getParameter("id");
		int idInt=Integer.parseInt(id);
		

		EmplService es=new EmplServiceImpl();
		es.delete(idInt);

		String path=req.getContextPath();
		
		res.sendRedirect(path+"/admin/showAll");
	}

}
