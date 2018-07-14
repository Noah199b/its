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
					<div class="sidemenu fl">
						<div class="s_title">用户相关</div>
						<ul>
							<li><a href="personalUI.do">个人中心</a></li>
							<li><a href="ownTopicUI.do">我的话题</a></li>
							<li><a href="messageUI.do">消息中心</a></li>
							<li class="on"><a href="ownResourceUI.do">我的资源</a></li>
						</ul>
					</div>
					<div class="ic_wrap fr">
						<div class="personal_box">
							<div class="tl_list">
							
							</div>
							<!--分页-->
							<div class="pages">
								<div id="Pagination"></div>
							</div>
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
		<script src="js/DateFormat.js" type="text/javascript"></script>
		<script src="its/resource/ownResource.js" type="text/javascript"></script>
	</body>
</html>