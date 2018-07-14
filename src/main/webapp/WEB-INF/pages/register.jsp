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
					<a href="indexUI.do">首页</a>&nbsp;>&nbsp;用户注册
				</div>
				<div class="register_box">
					<div class="tc_login">
						<div class="login_register fl">
							<form  id="form_register_id" method="POST" name="form_register" target="_top">
								<div align="center">
									<span class="error">请务必填写所有选项(填写的用户名已有时提示)</span>
									<i class="icon-mobile-phone"></i>
									<input type="text" name="name" id="username_id" required="required" placeholder="请输入用户名(字母或数字组成)" autocomplete="off" class="input_yh">
									<input type="password" name="pass" id="password_first" required="required" placeholder="请输入密码(字母或数字组成)" autocomplete="off" class="input_mm">
									<input type="password" name="pass_agin" id="password_id" required="required" placeholder="请确认密码" autocomplete="off" class="input_mm">
									<input type="email" name="email" id="email_id" required="required" placeholder="请输入邮箱(方便找回密码)" autocomplete="off" class="input_el">
								</div>
								<div align="center">
									<input type="submit" class="button btn_register" title="Sign In" value="注册">
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
		<script src="its/register/register.js" type="text/javascript"></script>
	</body>
</heml>