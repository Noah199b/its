<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
					<a href="index.html">首页</a>&nbsp;>&nbsp;本站活动&nbsp;>&nbsp;活动安排
				</div>
				<div class="inside_box">
					<div class="sidemenu fl">
						<div class="s_title">本站活动</div>
						<ul>
							<li class="on"><a href="activeUI.do">活动安排</a></li>
						</ul>
					</div>
					<div class="ic_wrap fr">
						<h3 class="e_title" >${active.name}</h3>
						<p>状态：
							<c:choose>
								<c:when test="${active.valid==0}">
								0-失效
								</c:when>
								<c:otherwise>
								1-有效
								</c:otherwise>						
							</c:choose>
						</p>
						<p>活动编码：${active.code}</p>
						<p>活动时间：<fmt:formatDate value="${active.beginDate}" type="date" pattern="yyyy-MM-dd"/>
							 到
							<fmt:formatDate value="${active.endDate}" type="date" pattern="yyyy-MM-dd"/>
						</p>
						<p>活动详情：</p>
						<p><b>${active.note}</b></p>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<!--footer start-->
		 <%@include file="footer.jsp" %>
		<!-- footer end -->
		
		
	</body>
</html>