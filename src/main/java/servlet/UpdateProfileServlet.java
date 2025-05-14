package servlet;

import service.UserProfileService;
import service.impl.UserProfileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    private UserProfileService userProfileService = new UserProfileServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String profile = request.getParameter("profile");
//        System.out.println("---------------------");
//        System.out.println(profile);
//        System.out.println("---------------------");

        // 更新或插入个人简介
        userProfileService.updateProfile(id, profile);

        // 重定向回员工主页
        response.sendRedirect(request.getContextPath() + "/employeeHome?id=" + id);
    }
}

