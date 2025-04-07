package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.deploy.util.ArrayUtil;
import service.EmplService;
import service.impl.EmplServiceImpl;
@WebServlet("/admin/deletes")
public class DeletesServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ids1 = req.getParameter("ids");
		String[] split = ids1.split(",");
		List<Integer> list = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
		
				//��̬��ȡ��ǰ��Ŀ��
						String path=req.getContextPath();
				
				EmplService ps=new EmplServiceImpl();
				ps.deleteMany(list);
				
				
				res.sendRedirect(path+"/admin/showAll");
	}

}
