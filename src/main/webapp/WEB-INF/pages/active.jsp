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
		<link rel="stylesheet" type="text/css" href="css/jquery.pagination.css"/>
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
						<ul class="news_list">
							<!-- <li><a href="eDetail.html">活动名称活动名称活动名称活动名称活动名称</a></li> -->
						</ul>
						<!--分页-->
						<div class="pages">
							<div id="Pagination"></div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>

		<!--footer start-->
		 <%@include file="footer.jsp" %>
		<!-- footer end -->
		<script src="js/jquery.pagination.min.js" type="text/javascript"></script>
		<script src="its/active/active.js" type="text/javascript"></script>	
	</body>
</html>