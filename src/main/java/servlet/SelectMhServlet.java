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
@WebServlet("/admin/select")
public class SelectMhServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//�ղ�
		String name=req.getParameter("name");
		String ageBegin=req.getParameter("ageBegin");
		String ageEnd=req.getParameter("ageEnd");
		String dept=req.getParameter("dept");
		
		DeptService ds = new DeptServiceImpl();
		List<Dept> dept1 = ds.selectAll();
				
		//list����������
		req.setAttribute("dept1", dept1);
		
		//����service
		EmplService es=new EmplServiceImpl();
		List<Empl> list = es.selectMohu(name, ageBegin, ageEnd,dept);
		
		//list��������
		req.setAttribute("list", list);
		//����ת��
		req.getRequestDispatcher("/emplist.jsp").forward(req, res);
	}

}
