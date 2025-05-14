package servlet.api;


import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/chat/chat-stream")
public class ChatStreamServlet extends HttpServlet {
    private AnythingLLMService service = new AnythingLLMService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");

        String workspace = req.getParameter("workspace");
        String message = req.getParameter("message");

        PrintWriter out = resp.getWriter();

        try {
            JSONObject response = service.chat(workspace, message);
            String answer = response.getString("textResponse");

            for (char c : answer.toCharArray()) {
                out.print(c);
                out.flush();
                Thread.sleep(20); // 控制打字速度
            }
        } catch (Exception e) {
            out.println("错误: " + e.getMessage());
        }
    }
}

