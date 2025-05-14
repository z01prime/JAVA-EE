<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,entity.Empl"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--	<title>员工管理系统</title>--%>
<%--	<style>--%>
<%--		body {--%>
<%--			margin: 0;--%>
<%--			font-family: Arial, sans-serif;--%>
<%--			/*background: #f0f2f5;*/--%>
<%--			background: #f0f2f5 url('./img/bg4.png') no-repeat center/cover;--%>
<%--			min-height: 100vh;--%>
<%--		}--%>
<%--		.header {--%>
<%--			background: rgba(255, 255, 255, 0.6);--%>
<%--			padding: 0 20px;--%>
<%--			display: flex;--%>
<%--			justify-content: space-between;--%>
<%--			align-items: center;--%>
<%--			box-shadow: 0 2px 4px rgba(0,0,0,0.1);--%>
<%--		}--%>
<%--		.nav-right {--%>
<%--			display: flex;--%>
<%--			align-items: center;--%>
<%--		}--%>
<%--		.nav-item {--%>
<%--			position: relative;--%>
<%--			padding: 20px;--%>
<%--			cursor: pointer;--%>
<%--		}--%>
<%--		.nav-item:hover .dropdown {--%>
<%--			display: block;--%>
<%--		}--%>
<%--		.dropdown {--%>
<%--			display: none;--%>
<%--			position: absolute;--%>
<%--			right: 0;--%>
<%--			top: 100%;--%>
<%--			background: white;--%>
<%--			box-shadow: 0 2px 8px rgba(0,0,0,0.1);--%>
<%--			min-width: 120px;--%>
<%--		}--%>
<%--		.dropdown a {--%>
<%--			display: block;--%>
<%--			padding: 10px;--%>
<%--			text-decoration: none;--%>
<%--			color: #333;--%>
<%--		}--%>
<%--		.content {--%>
<%--			max-width: 1200px;--%>
<%--			margin: 20px auto;--%>
<%--			background: rgba(255,250,232,0.9);--%>
<%--			padding: 20px;--%>
<%--			border-radius: 8px;--%>
<%--		}--%>
<%--		table {--%>
<%--			width: 100%;--%>
<%--			border-collapse: collapse;--%>
<%--			margin-top: 20px;--%>
<%--		}--%>
<%--		th, td {--%>
<%--			padding: 12px;--%>
<%--			border-bottom: 1px solid #eee;--%>
<%--			text-align: left;--%>
<%--		}--%>
<%--		th {--%>
<%--			background: #f8f9fa;--%>
<%--		}--%>
<%--		tr:hover {--%>
<%--			background: #f8f9fa;--%>
<%--		}--%>
<%--		.search-form {--%>
<%--			display: flex;--%>
<%--			gap: 15px;--%>
<%--			flex-wrap: wrap;--%>
<%--			margin-bottom: 20px;--%>
<%--		}--%>
<%--		.form-group {--%>
<%--			display: flex;--%>
<%--			align-items: center;--%>
<%--			gap: 10px;--%>
<%--		}--%>
<%--		input, select {--%>
<%--			padding: 8px 12px;--%>
<%--			border: 1px solid #ddd;--%>
<%--			border-radius: 4px;--%>
<%--		}--%>
<%--		button {--%>
<%--			padding: 8px 20px;--%>
<%--			background: #1890ff;--%>
<%--			color: white;--%>
<%--			border: none;--%>
<%--			border-radius: 4px;--%>
<%--			cursor: pointer;--%>
<%--		}--%>
<%--		button:hover {--%>
<%--			background: #40a9ff;--%>
<%--		}--%>
<%--	</style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="header">--%>
<%--	<div>员工信息管理系统</div>--%>
<%--	<div class="nav-right">--%>
<%--		<c:choose>--%>
<%--			<c:when test="${empty name}">--%>
<%--				<a href="login.jsp" class="nav-item">点击登录</a>--%>
<%--			</c:when>--%>
<%--			<c:otherwise>--%>
<%--				<div class="nav-item">--%>
<%--					<div class="user-info">--%>
<%--						<img src="${pageContext.request.contextPath}/img/user.png" width="30" style="vertical-align: middle">--%>
<%--							${name}--%>
<%--					</div>--%>
<%--					<div class="dropdown">--%>
<%--						<a href="${pageContext.request.contextPath}/loginOut">退出登录</a>--%>
<%--					</div>--%>
<%--				</div>--%>
<%--			</c:otherwise>--%>
<%--		</c:choose>--%>
<%--	</div>--%>
<%--</div>--%>

<%--<div class="content">--%>
<%--	<form action="${pageContext.request.contextPath}/list" method="post" class="search-form">--%>
<%--		<div class="form-group">--%>
<%--			<label>姓名:</label>--%>
<%--			<input type="text" name="name">--%>
<%--		</div>--%>
<%--		<div class="form-group">--%>
<%--			<label>年龄:</label>--%>
<%--			<input type="number" name="ageBegin" placeholder="最小">--%>
<%--			<span>-</span>--%>
<%--			<input type="number" name="ageEnd" placeholder="最大">--%>
<%--		</div>--%>
<%--		<div class="form-group">--%>
<%--			<label>部门:</label>--%>
<%--			<select name="dept">--%>
<%--				<option value="" disabled selected>选择部门</option>--%>
<%--				<c:forEach items="${dept1}" var="dept">--%>
<%--					<option value="${dept.id}">${dept.name}</option>--%>
<%--				</c:forEach>--%>
<%--			</select>--%>
<%--		</div>--%>
<%--		<button type="submit">搜索</button>--%>
<%--	</form>--%>

<%--	<table>--%>
<%--		<thead>--%>
<%--		<tr>--%>
<%--			<th>编号</th>--%>
<%--			<th>姓名</th>--%>
<%--			<th>薪水</th>--%>
<%--			<th>年龄</th>--%>
<%--			<th>性别</th>--%>
<%--			<th>部门</th>--%>
<%--		</tr>--%>
<%--		</thead>--%>
<%--		<tbody>--%>
<%--		<c:forEach items="${list}" var="empl">--%>
<%--			<tr>--%>
<%--				<td>${empl.id}</td>--%>
<%--				<td>${empl.name}</td>--%>
<%--				<td>${empl.salary}</td>--%>
<%--				<td>${empl.age}</td>--%>
<%--				<td>${empl.sex}</td>--%>
<%--				<td>${empl.dept.name}</td>--%>
<%--			</tr>--%>
<%--		</c:forEach>--%>
<%--		</tbody>--%>
<%--	</table>--%>
<%--</div>--%>

<%--<script>--%>
<%--	// 基础权限提示--%>
<%--	<c:if test="${not empty error}">--%>
<%--	alert('${error}');--%>
<%--	</c:if>--%>

<%--	// 下拉菜单交互--%>
<%--	$(document).ready(function(){--%>
<%--		$('.nav-item').hover(function(){--%>
<%--			$(this).find('.dropdown').stop(true).slideDown(200);--%>
<%--		}, function(){--%>
<%--			$(this).find('.dropdown').stop(true).slideUp(200);--%>
<%--		});--%>
<%--	});--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,entity.Empl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>员工管理系统</title>
	<style>
		body {
			margin: 0;
			font-family: Arial, sans-serif;
			/*background: #f0f2f5;*/
			background: #f0f2f5 url('./img/bg4.png') no-repeat center/cover;
			min-height: 100vh;
		}
		.header {
			background: rgba(255, 255, 255, 0.6);
			padding: 0 20px;
			display: flex;
			justify-content: space-between;
			align-items: center;
			box-shadow: 0 2px 4px rgba(0,0,0,0.1);
		}
		.nav-right {
			display: flex;
			align-items: center;
		}
		.nav-item {
			position: relative;
			padding: 20px;
			cursor: pointer;
		}
		.nav-item:hover .dropdown {
			display: block;
		}
		.dropdown {
			display: none;
			position: absolute;
			right: 0;
			top: 100%;
			background: white;
			box-shadow: 0 2px 8px rgba(0,0,0,0.1);
			min-width: 120px;
		}
		.dropdown a {
			display: block;
			padding: 10px;
			text-decoration: none;
			color: #333;
		}
		.content {
			max-width: 1200px;
			margin: 20px auto;
			background: rgba(255,250,232,0.9);
			padding: 20px;
			border-radius: 8px;
		}
		table {
			width: 100%;
			border-collapse: collapse;
			margin-top: 20px;
		}
		th, td {
			padding: 12px;
			border-bottom: 1px solid #eee;
			text-align: left;
		}
		th {
			background: #f8f9fa;
		}
		tr:hover {
			background: #f8f9fa;
		}
		.search-form {
			display: flex;
			gap: 15px;
			flex-wrap: wrap;
			margin-bottom: 20px;
		}
		.form-group {
			display: flex;
			align-items: center;
			gap: 10px;
		}
		input, select {
			padding: 8px 12px;
			border: 1px solid #ddd;
			border-radius: 4px;
		}
		button {
			padding: 8px 20px;
			background: #1890ff;
			color: white;
			border: none;
			border-radius: 4px;
			cursor: pointer;
		}
		button:hover {
			background: #40a9ff;
		}
	</style>
</head>
<body>
<div class="header">
	<div>员工信息管理系统</div>
	<div class="nav-right">
		<c:choose>
			<c:when test="${empty name}">
				<a href="login.jsp" class="nav-item">点击登录</a>
			</c:when>
			<c:otherwise>
				<div class="nav-item">
					<div class="user-info">
						<img src="${pageContext.request.contextPath}/img/user.png" width="30" style="vertical-align: middle">
							${name}
					</div>
					<div class="dropdown">
						<a href="${pageContext.request.contextPath}/loginOut">退出登录</a>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<div class="content">
	<form action="${pageContext.request.contextPath}/list" method="post" class="search-form">
		<div class="form-group">
			<label>姓名:</label>
			<input type="text" name="name">
		</div>
		<div class="form-group">
			<label>年龄:</label>
			<input type="number" name="ageBegin" placeholder="最小">
			<span>-</span>
			<input type="number" name="ageEnd" placeholder="最大">
		</div>
		<div class="form-group">
			<label>部门:</label>
			<select name="dept">
				<option value="" disabled selected>选择部门</option>
				<c:forEach items="${dept1}" var="dept">
					<option value="${dept.id}">${dept.name}</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit">搜索</button>
	</form>

	<table>
		<thead>
		<tr>
			<!-- 删除了 编号 列 -->
			<th>姓名</th>
			<th>薪水</th>
			<th>年龄</th>
			<th>性别</th>
			<th>部门</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="empl">
			<tr>
				<!-- 删除了 编号 列 -->
				<td>${empl.name}</td>
				<td>${empl.salary}</td>
				<td>${empl.age}</td>
				<td>${empl.sex}</td>
				<td>${empl.dept.name}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<script>
	// 基础权限提示
	<c:if test="${not empty error}">
	alert('${error}');
	</c:if>

	// 下拉菜单交互
	$(document).ready(function(){
		$('.nav-item').hover(function(){
			$(this).find('.dropdown').stop(true).slideDown(200);
		}, function(){
			$(this).find('.dropdown').stop(true).slideUp(200);
		});
	});
</script>
</body>
</html>


