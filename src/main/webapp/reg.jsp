<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>用户注册</title>
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
			display: none;
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
	<div class="login_title">用户注册</div>
	<form action="${pageContext.request.contextPath}/reg" method="post" id="regForm">
		<div class="form_text_ipt">
			<input name="name" type="text" placeholder="用户名" required>
		</div>
		<div class="ececk_warning" id="nameError"><span>用户名不能为空</span></div>

		<div class="form_text_ipt">
			<input name="pwd1" type="password" placeholder="密码" required>
		</div>
		<div class="ececk_warning" id="pwd1Error"><span>密码不能为空</span></div>

		<div class="form_text_ipt">
			<input name="pwd2" type="password" placeholder="重复密码" required>
		</div>
		<div class="ececk_warning" id="pwd2Error"><span>两次密码不一致</span></div>

		<div class="form_btn">
			<button type="submit">立即注册</button>
		</div>

		<div class="form_reg_btn">
			已有账号？<a href="${pageContext.request.contextPath}/login.jsp" style="color: #1890ff">立即登录</a>
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

<%--<script src="${pageContext.request.contextPath}/layui/jquery.min.js"></script>--%>
<script>
	$(document).ready(function(){
		$('#regForm').submit(function(e){
			let valid = true;

			// 用户名验证
			if($('input[name="name"]').val().trim() === ''){
				$('#nameError').show();
				valid = false;
			}else{
				$('#nameError').hide();
			}

			// 密码验证
			const pwd1 = $('input[name="pwd1"]').val();
			const pwd2 = $('input[name="pwd2"]').val();

			if(pwd1 === ''){
				$('#pwd1Error').show();
				valid = false;
			}else{
				$('#pwd1Error').hide();
			}

			if(pwd2 === ''){
				$('#pwd2Error').text('密码不能为空').show();
				valid = false;
			}else if(pwd1 !== pwd2){
				$('#pwd2Error').text('两次密码不一致').show();
				valid = false;
			}else{
				$('#pwd2Error').hide();
			}

			return valid;
		});
	});
</script>
</body>
</html>