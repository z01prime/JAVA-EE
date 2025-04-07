package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/shop/*")
public class MustLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//��ȡsession
		HttpServletRequest hreq = (HttpServletRequest)req;
		HttpServletResponse hres = (HttpServletResponse)res; 
		HttpSession session = hreq.getSession();
		String name = (String)(session.getAttribute("name"));
		
		//��̬��ȡ��ǰ��Ŀ��
		String path=hreq.getContextPath();
		if(name==null) {
			//û�е�¼,�ض��򵽵�¼ҳ��
			hres.sendRedirect(path+"/login.jsp");
			return;
		}
		
		//����
		chain.doFilter(hreq, hres);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
