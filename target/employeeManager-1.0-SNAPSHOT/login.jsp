<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>登录页面</title>
	<style>
		body {
			margin: 0;
			padding: 20px;
			font-family: Arial, sans-serif;
			/*background: #f0f2f5;*/
			background: url('img/logo_bg.jpg') no-repeat center center fixed;
		}
		.login_box {
			max-width: 400px;
			margin: 50px auto;
			padding: 20px;
			background: white;
			border-radius: 8px;
			box-shadow: 0 2px 4px rgba(0,0,0,0.1);
		}
		.login_title {
			font-size: 24px;
			text-align: center;
			margin-bottom: 20px;
		}
		.form_text_ipt input {
			width: 100%;
			padding: 10px;
			margin: 8px 0;
			border: 1px solid #ddd;
			border-radius: 4px;
			box-sizing: border-box;
		}
		.form_btn button {
			width: 100%;
			padding: 12px;
			background: #1890ff;
			color: white;
			border: none;
			border-radius: 4px;
			cursor: pointer;
			margin-top: 15px;
		}
		.form_btn button:hover {
			background: #40a9ff;
		}
		.form_reg_btn {
			text-align: center;
			margin-top: 15px;
		}
		.ececk_warning {
			color: red;
			font-size: 12px;
			display: none; /* 默认隐藏错误提示 */
		}
		.other_login {
			margin-top: 20px;
			border-top: 1px solid #eee;
			padding-top: 15px;
		}
	</style>
</head>
<body>
<div class="login_box">
	<div class="login_title">用户登录</div>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<div class="form_text_ipt">
			<input name="name" type="text" placeholder="请输入用户名" required>
		</div>
		<div class="ececk_warning"><span>用户名不能为空</span></div>

		<div class="form_text_ipt">
			<input name="pwd" type="password" placeholder="请输入密码" required>
		</div>
		<div class="ececk_warning"><span>密码不能为空</span></div>

		<div style="display: flex; justify-content: space-between; margin: 10px 0">
			<label><input type="checkbox"> 记住登录</label>
			<a href="#" style="color: #666; text-decoration: none">忘记密码？</a>
		</div>

		<div class="form_btn">
			<button type="submit">立即登录</button>
		</div>

		<div class="form_reg_btn">
			没有账号？<a href="reg.jsp" style="color: #1890ff">立即注册</a>
		</div>
	</form>

	<div class="other_login">
		<div style="text-align: center; color: #666; margin-bottom: 10px">其他登录方式</div>
		<div style="display: flex; justify-content: center; gap: 15px">
			<a href="#">QQ</a>
			<a href="#">微信</a>
			<a href="#">微博</a>
		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath}/layui/jquery.min.js"></script>
<script>
	// 基础验证（示例）
	$(document).ready(function(){
		$('form').submit(function(e){
			let valid = true;
			$('input[required]').each(function(){
				if($(this).val().trim() === ''){
					$(this).next('.ececk_warning').show();
					valid = false;
				}else{
					$(this).next('.ececk_warning').hide();
				}
			});
			return valid;
		});
	});
</script>
</body>
</html>
