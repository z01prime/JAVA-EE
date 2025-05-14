//package servlet;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import entity.Empl;
//import service.EmplService;
//import service.impl.EmplServiceImpl;
//
//@WebServlet("/employeeHome")
//public class EmployeeHomeServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        // 获取请求参数
//        String idParam = req.getParameter("id");
//
//        // 如果id参数为空，则跳转回登录页
//        if (idParam == null || idParam.isEmpty()) {
//            res.sendRedirect(req.getContextPath() + "/login.jsp");
//            return;
//        }
//
//        try {
//            // 将id转换为整数
//            int id = Integer.parseInt(idParam);
//
//            // 创建服务层对象，获取员工信息
//            EmplService emplService = new EmplServiceImpl();
//            Empl empl = emplService.selectById(id);
//
//            // 如果员工不存在，跳转到登录页
//            if (empl == null) {
//                res.sendRedirect(req.getContextPath() + "/login.jsp");
//                return;
//            }
//
//            // 将员工对象存放到请求作用域
//            req.setAttribute("empl", empl);
//
//            // 转发到员工主页
//            req.getRequestDispatcher("/employeeHome.jsp").forward(req, res);
//        } catch (NumberFormatException e) {
//            // 如果id参数无法转换为整数，跳转回登录页
//            res.sendRedirect(req.getContextPath() + "/login.jsp");
//        }
//    }
//}

package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Empl;
import entity.UserProfile;
import service.EmplService;
import service.UserProfileService;
import service.impl.EmplServiceImpl;
import service.impl.UserProfileServiceImpl;

@WebServlet("/employeeHome")
public class EmployeeHomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 获取请求参数
        String idParam = req.getParameter("id");

        // 如果id参数为空，则跳转回登录页
        if (idParam == null || idParam.isEmpty()) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        try {
            // 将id转换为整数
            int id = Integer.parseInt(idParam);

            // 创建服务层对象，获取员工信息
            EmplService emplService = new EmplServiceImpl();
            Empl empl = emplService.selectById(id);

            // 如果员工不存在，跳转到登录页
            if (empl == null) {
                res.sendRedirect(req.getContextPath() + "/login.jsp");
                return;
            }

            // 创建UserProfileService对象，获取个人简介信息
            UserProfileService userProfileService = new UserProfileServiceImpl();
            UserProfile userProfile = userProfileService.getProfileById(id);

            // 将员工对象和个人简介对象存放到请求作用域
            req.setAttribute("empl", empl);
            req.setAttribute("userProfile", userProfile);

            // 转发到员工主页
            req.getRequestDispatcher("/employeeHome.jsp").forward(req, res);
        } catch (NumberFormatException e) {
            // 如果id参数无法转换为整数，跳转回登录页
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}

