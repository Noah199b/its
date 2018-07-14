<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
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
					<a href="indexUI.do">首页</a>&nbsp;>&nbsp;用户相关>&nbsp;<a href="messageUI.do">消息中心</a>>&nbsp;消息内容
				</div>
				<div class="inside_box">
					<div class="sidemenu fl">
						<div class="s_title">用户相关</div>
						<ul>
							<li><a href="personalUI.do">个人中心</a></li>
							<li><a href="ownTopicUI.do">我的话题</a></li>
							<li class="on"><a href="messageUI.do">消息中心</a></li>
							<li><a href="ownResourceUI.do">我的资源</a></li>
						</ul>
					</div>
					<div class="personal_box">
                      <div class="topic_wrap fl">
						<div class="t_label">
							<h2>消息内容</h2>
						</div>
						<div class="tl_list">
							<ul>
								<li>
								<c:choose>
									<c:when test="${its_user.username ne messageObject.user}">
										<a class="reply">非法地址</a>
										<div class="t_con">
											<p>当前消息地址非法，请单击下方链接返回上一层！</p>
											<h3><a href="messageUI.do">-->返回消息中心</a><span class="addressor">发布者：admin&nbsp;&nbsp;&nbsp;发布日期：<%=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) %>&nbsp;&nbsp;&nbsp;</span></h3>
										</div>
									</c:when>
									<c:when test="${messageObject.type == 1}">
										<a class="reply">用户</a>
										<div class="t_con">
											<p>${messageObject.content}</p>
											<h3><a href="tDetail.do?id=${messageObject.articleId}#reply">查看原文</a>&nbsp;&nbsp;&nbsp;<a href="messageUI.do">-->返回消息中心</a></h3>
										</div>
									</c:when>
									<c:otherwise>
										<a class="reply">系统</a>
										<div class="t_con">
											<p>${messageObject.content}</p>
											<h3><a href="messageUI.do">-->返回消息中心</a></h3>
										</div>
									</c:otherwise>
								</c:choose>	
								</li>												
							</ul>
						</div>
					</div>			
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>

		<!--footer start-->
		 <%@include file="footer.jsp" %>
		<!-- footer end -->
		
		<script src="its/login/personal.js" type="text/javascript"></script>
	</body>
</html>