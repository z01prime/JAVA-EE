<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,entity.Empl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>员工管理</title>
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
		.search-form {
			background: white;
			padding: 20px;
			border-radius: 8px;
			margin-bottom: 30px;
			box-shadow: 0 2px 8px rgba(0,0,0,0.1);
		}
		.form-group {
			display: flex;
			align-items: center;
			gap: 15px;
			margin-bottom: 15px;
		}
		label {
			min-width: 50px;
		}
		input, select {
			padding: 8px 12px;
			border: 1px solid #ddd;
			border-radius: 4px;
			flex: 1;
		}
		.btn {
			padding: 8px 20px;
			border: none;
			border-radius: 4px;
			cursor: pointer;
		}
		.btn-search {
			background: var(--primary-color);
			color: white;
		}
		table {
			width: 100%;
			background: white;
			border-collapse: collapse;
			box-shadow: 0 2px 8px rgba(0,0,0,0.1);
		}
		th, td {
			padding: 12px;
			text-align: left;
			border-bottom: 1px solid #eee;
		}
		th {
			background: #f8f9fa;
			font-weight: 500;
		}
		.action-link {
			padding: 6px 12px;
			border-radius: 4px;
			text-decoration: none;
			margin: 0 5px;
		}
		.delete-link {
			background: var(--danger-color);
			color: white;
		}
		.edit-link {
			background: #faad14;
			color: white;
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
		<form class="search-form" action="${pageContext.request.contextPath}/admin/select" method="post">
			<div class="form-group">
				<label>姓名:</label>
				<input type="text" name="name">
			</div>
			<div class="form-group">
				<label>年龄:</label>
				<input type="number" name="ageBegin" placeholder="最小">
				<input type="number" name="ageEnd" placeholder="最大">
			</div>
			<div class="form-group">
				<label>部门:</label>
				<select name="dept">
					<option value="">选择部门</option>
					<c:forEach items="${dept1}" var="dept">
						<option value="${dept.id}">${dept.name}</option>
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-search">搜索</button>
			</div>
		</form>

		<h2>员工列表</h2>
		<table>
			<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>薪水</th>
				<th>年龄</th>
				<th>性别</th>
				<th>部门</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="empl">
				<tr>
					<td>${empl.id}</td>
					<td>${empl.name}</td>
					<td>${empl.salary}</td>
					<td>${empl.age}</td>
					<td>${empl.sex}</td>
					<td>${empl.dept.name}</td>
					<td>
						<a href="${pageContext.request.contextPath}/admin/delete?id=${empl.id}"
						   class="action-link delete-link">删除</a>
						<a href="${pageContext.request.contextPath}/admin/showOne?id=${empl.id}"
						   class="action-link edit-link">修改</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</main>
</div>
</body>
</html>

