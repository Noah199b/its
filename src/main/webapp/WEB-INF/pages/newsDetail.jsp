<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<script charset="utf-8" src="editor/wangEditor.min.js"></script>
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
					<a href="indexUI.do">首页</a>&nbsp;>&nbsp;新闻热点&nbsp;>&nbsp;教育新闻
				</div>
				<div class="inside_box">
					<div class="sidemenu fl">
						<div class="s_title">新闻热点</div>
						<ul>
							<li class="on"><a href="newsUI.do">新闻热点</a></li>
						</ul>
					</div>
					<div class="ic_wrap fr">
						<h3 class="n_title">${its_news.title}<span class="n_date">发布日期：
						<fmt:formatDate value="${its_news.createdTime}" type="date" pattern="yyyy-MM-dd"/>
						&nbsp;&nbsp;&nbsp;总访问量：${its_news.totalVisits}</span></h3>
						<!--<h4 class="n_title" style="text-align: right;">——${its_news.subTitle}</h4>-->
						${news_content}
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