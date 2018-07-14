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
					<a href="indexUI.do">首页</a>&nbsp;>&nbsp;微·论坛
				</div>
				<div class="inside_box">
					<div class="topic_wrap fl">
						<div class="t_label">
							<div class="tl_tab fl">
								<a href="javascript:changeType(0);" id="hot_week" class="active">本周热门</a>
								<a href="javascript:changeType(1);" id="newest" >最新发表</a>
							</div>
							<div class="search fr">
								<input type="text" name="topic" id="topic" value="" placeholder="请输入话题名称" class="input_tp" maxlength="50"/>
								<button type="button" class="btn btn_search">搜索</button>
							</div>
						</div>
						<div class="tl_list">
							
						</div>
						<!--分页-->
						<div class="pages">
							<div id="Pagination"></div>
						</div>
					</div>
					<!--right start-->
					 <%@include file="right.jsp" %>
					<!--right end -->
					<div class="clear"></div>
				</div>
			</div>
		</div>

		<!--footer start-->
		 <%@include file="footer.jsp" %>
		<!-- footer end -->
		<script src="js/jquery.pagination.min.js" type="text/javascript"></script>
		<script src="js/DateFormat.js" type="text/javascript"></script>
		<script src="its/bbs/bbs.js" type="text/javascript"></script>
	</body>
</html>