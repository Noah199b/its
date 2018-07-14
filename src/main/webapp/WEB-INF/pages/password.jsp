<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="keywords" content="互助教学系统" />
		<meta name="description" content="互助教学系统-教师学生学习分享" />
		<title>互助教学系统-教师学生学习分享</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/popup.css"/>
	</head>
	<body>
		<!-- header start -->
		 <%@include file="header.jsp" %>
		<!-- header end -->
		
		<!-- nav start -->
		 <%@include file="nav.jsp" %>
		<!-- nav end -->
		
		<!--inside content start-->
		<div class="inside_wrap">
			<div class="inside_con">
				<div class="adr">
					<a href="indexUI.do">首页</a>&nbsp;>&nbsp;密码找回
				</div>
				<div class="register_box">
					<div class="tc_login">
						<div class="login_register fl">
							<form method="POST" name="form_register" target="_top" id="form_password_id">
								<div align="center">
									<h3>请填入您的邮箱进行密码找回</h3>
									<span class="error"></span>
									<i class="icon-mobile-phone"></i>
									<input type="text" name="name" id="user_id" required="required" placeholder="用户名" autocomplete="off" class="input_yh" value="${its_user.username}">
									<input type="email" name="email" id="emial" required="required" placeholder="请输入注册邮箱" autocomplete="off" class="input_el">
									<div class="authcode">
										<input type="text" name="code" id="code" required="required" placeholder="请输入验证码" autocomplete="off" class="input_yz fl">
										<button type="button" id="send" class="btn code fr">发送验证码</button>
										<div class="clear"></div>
									</div>
									<input type="password" name="pass" id="newPass_id" required="required" placeholder="新密码" autocomplete="off" class="input_mm">									
								</div>
								<div align="center">
									<input type="submit" class="button" title="Sign In" id="rePassword" value="确认修改">
								</div>
							</form>
						</div>
						<div class="l_img fl">
							<img src="images/sj.jpg"/>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
		<!--footer start-->
		 <%@include file="footer.jsp" %>
		<!-- footer end -->	
		<script src="its/register/password.js" type="text/javascript"></script>
	</body>
</html>