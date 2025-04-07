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
		}
		.sidebar-item {
			padding: 12px 20px;
			color: white;
			text-decoration: none;
			display: block;
			transition: 0.3s;
		}
		.sidebar-item:hover {
			background: #293846;
		}
		.main-content {
			flex: 1;
			padding: 30px;
		}
		.form-container {
			max-width: 600px;
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
		.form-group {
			margin-bottom: 20px;
		}
		label {
			display: block;
			margin-bottom: 8px;
			font-weight: 500;
		}
		input, select {
			width: 100%;
			padding: 10px;
			border: 1px solid #ddd;
			border-radius: 4px;
			box-sizing: border-box;
		}
		.radio-group {
			display: flex;
			gap: 50px;
			/*padding: 10px 0;*/
		}
		.radio-group label {
			display: flex;
			align-items: center;
		}
		.form-actions {
			text-align: center;
			margin-top: 30px;
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
		.btn-reset {
			background: #f5f5f5;
			color: #666;
			margin-left: 15px;
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
		<a href="#" class="sidebar-item">首页</a>
		<a href="${pageContext.request.contextPath}/admin/showAll" class="sidebar-item">员工管理</a>
		<a href="${pageContext.request.contextPath}/admin/addone" class="sidebar-item">添加员工</a>
	</nav>

	<main class="main-content">
		<div class="form-container">
			<h1 class="form-title">添加员工信息</h1>
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