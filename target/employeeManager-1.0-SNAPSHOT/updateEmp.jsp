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
		.container {
			display: flex;
			min-height: calc(100vh - 60px);
		}
		.sidebar {
			width: 200px;
			background: var(--sidebar-bg);
			padding: 20px 0;
			display: flex;
			flex-direction: column;
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
		<a href="${pageContext.request.contextPath}/admin/showAll" class="nav-link" style="margin-left: 0;">控制台</a>
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
			<h1 class="form-title">修改员工信息</h1>
			<form action="${pageContext.request.contextPath}/admin/update" method="post">
				<div class="form-group">
					<label>员工ID</label>
					<input type="text" name="id" value="${empl.id}" readonly>
				</div>
				<div class="form-group">
					<label>用户名</label>
					<input type="text" name="name" value="${empl.name}" required>
				</div>
				<div class="form-group">
					<label>工资</label>
					<input type="text" name="salary" value="${empl.salary}" required>
				</div>
				<div class="form-group">
					<label>年龄</label>
					<input type="text" name="age" value="${empl.age}" required>
				</div>
				<div class="form-group">
					<label>性别</label>
					<div class="radio-group">
						<label>
							<input type="radio" name="sex" value="男" ${empl.sex == '男' ? 'checked' : ''}> 男
						</label>
						<label>
							<input type="radio" name="sex" value="女" ${empl.sex == '女' ? 'checked' : ''}> 女
						</label>
					</div>
				</div>
				<div class="form-group">
					<label>部门</label>
					<select name="idd" required>
						<option value="${empl.dept.id}">${empl.dept.name}</option>
						<c:forEach items="${dept}" var="dept">
							<option value="${dept.id}">${dept.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-actions">
					<button type="submit" class="btn btn-primary">确认修改</button>
					<button type="reset" class="btn btn-reset">重置</button>
				</div>
			</form>
		</div>
	</main>
</body>
</html>
