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
					<a href="indexUI.do">首页</a>&nbsp;>&nbsp;用户相关>&nbsp;个人中心
				</div>
				<div class="inside_box">
					<div class="personal_wrap">
						<div class="personal_info">
												
						</div>
						<div class="tl_list">
							<h2>相关主题</h2>
							<ul class="ul_list"></ul>
							<!--分页-->
							<div class="pages">
								<div id="Pagination"></div>
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
		<script src="js/jquery.pagination.min.js" type="text/javascript"></script>
		<script src="js/DateFormat.js" type="text/javascript"></script>
		<script src="its/bbs/ownTopic1.js" type="text/javascript"></script>		
	</body>
</html>