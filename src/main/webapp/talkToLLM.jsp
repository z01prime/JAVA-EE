<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>与 LLM 对话</title>
    <script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
    <style>
        :root {
            --primary-color: #1890ff;
            --danger-color: #ff4d4f;
            --bg-color: #f0f2f5;
            --sidebar-bg: #2f4050;
            --highlight-color: #1a2531;
            --hover-color: #293846;
        }
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: var(--bg-color);
            min-height: 100vh;
        }
        .header {
            background: var(--sidebar-bg);
            color: white;
            padding: 0 20px;
            height: 60px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        .nav-link {
            color: white;
            text-decoration: none;
            margin-left: 25px;
        }
        .nav-link:first-child {
            margin-left: 0;
        }
        .container {
            display: flex;
            min-height: calc(100vh - 60px);
        }
        .sidebar {
            width: 200px;
            background: var(--sidebar-bg);
            padding: 20px 0;
        }
        .sidebar-item {
            padding: 12px 20px;
            color: white;
            text-decoration: none;
            display: block;
            transition: 0.3s;
        }
        .sidebar-item:hover {
            background: var(--hover-color);
        }
        .highlight-item {
            background: var(--highlight-color);
        }
        .highlight-item:hover {
            background: var(--hover-color);
        }
        .main-content {
            flex: 1;
            padding: 30px;
        }
        .form-container {
            max-width: 800px;
            margin: 0 auto;
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        .form-title {
            text-align: center;
            margin-bottom: 25px;
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: 500;
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 20px;
        }
        .form-actions {
            text-align: center;
            margin-top: 20px;
        }
        .btn {
            padding: 10px 25px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        .btn-primary {
            background: var(--primary-color);
            color: white;
        }
        #output {
            white-space: pre-wrap;
            font-family: monospace;
            margin-top: 30px;
            border: 1px solid #ccc;
            padding: 15px;
            background: #fefefe;
        }
        .user-info {
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .user-info img {
            width: 30px;
            height: 30px;
        }
    </style>
</head>
<body>
<div class="header">
    <div>
        <a href="${pageContext.request.contextPath}/admin/showAll" class="nav-link">控制台</a>
    </div>
    <div class="user-info">
        <img src="${pageContext.request.contextPath}/img/user.png" alt="用户">
        <span>${name}</span>
        <a href="${pageContext.request.contextPath}/loginOut" class="nav-link">退出</a>
    </div>
</div>

<div class="container">
    <nav class="sidebar">
        <a href="#" class="sidebar-item highlight-item">员工相关</a>
        <a href="${pageContext.request.contextPath}/admin/showAll" class="sidebar-item">员工管理</a>
        <a href="${pageContext.request.contextPath}/admin/addone" class="sidebar-item">添加员工</a>
        <a href="#" class="sidebar-item highlight-item">本地知识库</a>
        <a href="${pageContext.request.contextPath}/talkToLLM.jsp" class="sidebar-item">与LLM对话</a>
    </nav>

    <main class="main-content">
        <div class="form-container">
            <h1 class="form-title">与 AnythingLLM 对话</h1>
            <form id="chatForm">
                <label>工作区 标记：</label>
                <input type="text" id="workspace" name="workspace" value="javawebproject" required />

                <label>请输入你的问题：</label>
                <textarea id="message" name="message" rows="6" required></textarea>

                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
            </form>

            <div id="output"></div>
        </div>
    </main>
</div>

<script>
    document.getElementById("chatForm").addEventListener("submit", function (e) {
        e.preventDefault();

        const workspace = document.getElementById("workspace").value;
        const message = document.getElementById("message").value;
        const output = document.getElementById("output");

        output.innerHTML = "<em>思考中...</em>";

        fetch("${pageContext.request.contextPath}/chat/chat-stream?workspace=" + encodeURIComponent(workspace) + "&message=" + encodeURIComponent(message))
            .then(response => {
                const reader = response.body.getReader();
                const decoder = new TextDecoder();
                let rawBuffer = "";
                let renderedBuffer = "";
                let thinkRemoved = false;

                function read() {
                    reader.read().then(({ done, value }) => {
                        if (done) return;

                        const chunk = decoder.decode(value, { stream: true });
                        rawBuffer += chunk;

                        if (!thinkRemoved) {
                            const thinkRegex = /<think>[\s\S]*?<\/think>/;
                            if (thinkRegex.test(rawBuffer)) {
                                rawBuffer = rawBuffer.replace(thinkRegex, '');
                                thinkRemoved = true;
                            }
                        }

                        renderedBuffer = marked.parse(rawBuffer);
                        output.innerHTML = renderedBuffer;

                        read();
                    });
                }

                read();
            })
            .catch(error => {
                output.innerHTML = "<span style='color:red;'>发生错误：" + error + "</span>";
            });
    });
</script>
</body>
</html>
