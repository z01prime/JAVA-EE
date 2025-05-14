package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ComUserService;
import service.EmplService;
import service.UserService;
import service.impl.ComUserServiceImpl;
import service.impl.EmplServiceImpl;
import service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 获取项目名
        String path = req.getContextPath();

        // 收集请求参数
        String id = req.getParameter("id");  // 企业员工的 ID
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        // 调用service层进行登录验证
        ComUserService cs = new ComUserServiceImpl();
        UserService us = new UserServiceImpl();
        EmplService es = new EmplServiceImpl();

        // 验证用户是否是普通用户
        boolean ifLogin = us.iflogin(name, pwd);

        // 验证用户是否是企业用户
        boolean ifLogin1 = cs.login(name, pwd);

        // 登录成功后的处理
        HttpSession session = req.getSession();

        if (ifLogin) {
            // 普通用户登录成功，跳转到管理员页面
            session.setAttribute("name", name);
            res.sendRedirect(path + "/admin/showAll");
        } else if (ifLogin1) {
            // 企业用户登录成功，设置用户名
            session.setAttribute("name", name);

            // 判断是否传入了 id
            if (id != null && !id.trim().isEmpty()) {
                try {
                    // 将 id 转换为整数
                    int emplId = Integer.parseInt(id);

                    // 验证该 id 是否对应有效的企业员工
                    boolean ifIdExist = es.existsById(emplId);
                    if (ifIdExist) {
                        // 如果是有效的员工，跳转到该员工的个人主页
                        session.setAttribute("id", id);  // 保存员工 id 到 session
                        res.sendRedirect(path + "/employeeHome?id=" + id);  // 动态跳转到员工个人主页
                    } else {
                        // 如果 id 不存在或无效，跳转到员工列表页面
                        res.sendRedirect(path + "/list");
                    }
                } catch (NumberFormatException e) {
                    // 如果 id 格式错误，跳转到登录页面
                    res.sendRedirect(path + "/login.jsp");
                }
            } else {
                // 如果没有传入 id，直接跳转到员工列表页面
                res.sendRedirect(path + "/list");
            }
        } else {
            // 登录失败，返回到登录页面
            res.sendRedirect(path + "/login.jsp");
        }
    }
}
