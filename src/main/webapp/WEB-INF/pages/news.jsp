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
					<a href="indexUI.do">首页</a>&nbsp;>&nbsp;新闻热点
				</div>
				<div class="inside_box">
					<div class="sidemenu fl">
						<div class="s_title" >新闻热点</div>
						<input type="hidden" id="newsTypeId" value="1"/>
						<ul>
							<li class="on" id="eduNews"><a href="javascript:changeType(1);">教育新闻</a></li>
							<li id="timeNews"><a href="javascript:changeType(0);">事实热点</a></li>
						</ul>
					</div>
					<div class="ic_wrap fr">
						<ul class="news_list">
							<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</a><span class="date">[2016-06-17]</span></li>
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
		<script src="js/DateFormat.js" type="text/javascript"></script>	
		<script type="text/javascript" src="its/news/news.js"></script>
	</body>
</html>