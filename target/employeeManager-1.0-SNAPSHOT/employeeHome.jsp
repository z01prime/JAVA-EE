<%@ page import="entity.Empl, entity.UserProfile" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>员工主页</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fc;
            margin: 0;
            padding: 0;
            color: #333;
        }
        .header {
            background-color: #1890ff;
            color: #fff;
            padding: 20px;
            text-align: center;
        }
        h1 {
            margin: 0;
            font-size: 24px;
        }
        .content {
            padding: 20px;
            margin: 20px auto;
            background-color: #fff;
            width: 80%;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .content p {
            font-size: 18px;
            line-height: 1.6;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #1890ff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
        }
        .btn:hover {
            background-color: #1c77cc;
        }
        .footer {
            background-color: #1890ff;
            color: #fff;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
        .profile-edit {
            margin-top: 20px;
        }
        textarea {
            width: 100%;
            height: 150px;
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #ccc;
            resize: none;
        }

        /* 新增的样式：按钮容器和右对齐 */
        .button-container {
            display: flex;
            justify-content: flex-end; /* 右对齐 */
            gap: 10px; /* 按钮间距 */
            margin-top: 20px; /* 给按钮容器加点上边距 */
        }
    </style>
</head>
<body>

<div class="header">
    <h1>欢迎来到员工主页</h1>
</div>

<div class="content">
    <%
        // 获取员工对象
        Empl empl = (Empl) request.getAttribute("empl");
        UserProfile userProfile = (UserProfile) request.getAttribute("userProfile"); // 获取个人简介
        if (empl != null) {
    %>
    <p><strong>姓名:</strong> <%= empl.getName() %></p>
    <p><strong>年龄:</strong> <%= empl.getAge() %></p>
    <p><strong>部门:</strong> <%= empl.getDept().getName() %></p>

    <!-- 显示个人简介 -->
    <p><strong>个人简介:</strong></p>
    <p><%= userProfile != null ? userProfile.getProfile() : "暂无个人简介" %></p>

    <!-- 编辑个人简介 -->
    <div class="profile-edit">
        <form action="<%= request.getContextPath() + "/updateProfile" %>" method="post">
            <input type="hidden" name="id" value="<%= empl.getId() %>" />
            <textarea name="profile" placeholder="编辑个人简介，保存后即可在页面上显示"></textarea>
            <button type="submit" class="btn">保存个人简介</button>
        </form>
    </div>

    <%
    } else {
    %>
    <p>员工信息不存在，请重新登录。</p>
    <% } %>

    <!-- 按钮容器 -->
    <div class="button-container">
        <a href="<%= request.getContextPath() + "/loginOut" %>" class="btn">退出登录</a>
    </div>
</div>

<div class="footer">
    <p>员工管理系统</p>
</div>

</body>
</html>
