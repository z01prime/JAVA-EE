package servlet;

import entity.Empl;
import entity.UserProfile;
import service.EmplService;
import service.UserProfileService;
import service.impl.EmplServiceImpl;
import service.impl.UserProfileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

@WebServlet("/admin/exportTxt")
public class ExportTxtServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应类型为文本文件，并设置文件名
        response.setContentType("text/plain; charset=UTF-8"); // 强制UTF-8编码
        String fileName = "员工信息.txt";
        response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));  // 处理中文文件名

        // 获取员工信息
        EmplService emplService = new EmplServiceImpl();
        UserProfileService userProfileService = new UserProfileServiceImpl();
        List<Empl> emplList = emplService.selectAll();  // 获取所有员工信息

        // 创建一个输出流，用来将员工信息写入到文本文件中
        PrintWriter writer = response.getWriter();

        // 遍历所有员工，按要求的格式写入文本
        for (Empl empl : emplList) {
            StringBuilder sb = new StringBuilder();
            sb.append("姓名：").append(empl.getName()).append(", ");
            sb.append("编号：").append(empl.getId()).append(", ");
            sb.append("薪水：").append(empl.getSalary()).append(", ");
            sb.append("年龄：").append(empl.getAge()).append(", ");
            sb.append("性别：").append(empl.getSex()).append(", ");
            sb.append("部门：").append(empl.getDept().getName()).append(", ");
            UserProfile profile = userProfileService.getProfileById(empl.getId());
            String pf =  profile != null ? profile.getProfile() : "无";
            sb.append("个人简介：").append(pf);
            // 写入一条记录，并换行
            writer.println(sb.toString());
        }

        // 刷新输出流
        writer.flush();
        // 完成后不再调用 writer.close()，因为它是响应流的一部分，Servlet容器会自动关闭
    }
}
