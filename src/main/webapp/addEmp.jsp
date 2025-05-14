<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>添加员工</title>
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
			background: white;
			padding: 30px;
			border-radius: 8px;
			box-shadow: 0 2px 8px rgba(0,0,0,0.1);
			max-width: 600px;
			margin: 0 auto;
		}
		.form-title {
			font-size: 20px;
			font-weight: bold;
			margin-bottom: 25px;
			text-align: center;
		}
		.form-group {
			display: flex;
			flex-direction: column;
			margin-bottom: 15px;
		}
		label {
			margin-bottom: 8px;
			font-weight: 500;
		}
		input, select {
			padding: 8px 12px;
			border: 1px solid #ddd;
			border-radius: 4px;
			box-sizing: border-box;
		}
		.radio-group {
			display: flex;
			gap: 30px;
		}
		.radio-group label {
			display: flex;
			align-items: center;
			font-weight: normal;
		}
		.radio-group input {
			margin-right: 6px;
		}
		.form-actions {
			text-align: center;
			margin-top: 20px;
		}
		.btn {
			padding: 8px 20px;
			border: none;
			border-radius: 4px;
			cursor: pointer;
			font-size: 14px;
		}
		.btn-primary {
			background: var(--primary-color);
			color: white;
		}
		.btn-reset {
			background: #f5f5f5;
			color: #666;
			margin-left: 10px;
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
			<h2 class="form-title">添加员工信息</h2>
			<form action="${pageContext.request.contextPath}/admin/add" method="post">
				<div class="form-group">
					<label>用户名</label>
					<input type="text" name="name" placeholder="请输入用户名" required>
				</div>
				<div class="form-group">
					<label>工资</label>
					<input type="text" name="salary" placeholder="请输入工资" required>
				</div>
				<div class="form-group">
					<label>年龄</label>
					<input type="text" name="age" placeholder="请输入年龄" required>
				</div>
				<div class="form-group">
					<label>性别</label>
					<div class="radio-group">
						<label><input type="radio" name="sex" value="男" checked> 男</label>
						<label><input type="radio" name="sex" value="女"> 女</label>
					</div>
				</div>
				<div class="form-group">
					<label>部门</label>
					<select name="id" required>
						<option value="">选择部门</option>
						<c:forEach items="${deptl}" var="dept">
							<option value="${dept.id}">${dept.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-actions">
					<button type="submit" class="btn btn-primary">立即添加</button>
					<button type="reset" class="btn btn-reset">重置</button>
				</div>
			</form>
		</div>
	</main>
</div>
</body>
</html>