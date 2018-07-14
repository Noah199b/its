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
					<a href="indexUI.do">首页</a>&nbsp;>&nbsp;用户相关>&nbsp;消息中心
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
							<div class="tl_tab fl">
								<a href="javascript:getPageType(2);" id="all_msg" class="active">全部消息</a>
								<a href="javascript:getPageType(0);" id="no_msg">未读消息</a>
								<a href="javascript:getPageType(1);" id="yes_msg">已读消息</a>
							</div>
						</div>
						<div class="tl_list">
							<ul>
								<li>
									<a href=" " class="reply">已读</a>
									<div class="t_con">
										<h3><a href="message1UI.do">话题标题话题标题话题标题话题标题话题标题话题标题话题标题</a><span class="addressor">发布者：名称&nbsp;&nbsp;&nbsp;发布日期：2016-06-17&nbsp;&nbsp;&nbsp;</span></h3>
									</div>
								</li>
								<li>
									<a href=" " class="reply">已读</a>
									<div class="t_con">
										<h3><a href="tDetail.html">话题标题话题标题话题标题话题标题话题标题话题标题话题标题</a><span class="addressor">发布者：名称&nbsp;&nbsp;&nbsp;发布日期：2016-06-17&nbsp;&nbsp;&nbsp;</span></h3>
										<p>话题内容话题内容话题内容话题内容话，题内容话题内容话题内容话题内容，话题内容话题内容话题内容话题内容话题，内容话题内容话题内容话题内容话题内容话。题内容话题内容话题内容话题内容话题内容...</p>
									</div>
								</li>
								<li>
									<a href=" " class="reply">已读</a>
									<div class="t_con">
										<h3><a href="tDetail.html">话题标题话题标题话题标题话题标题话题标题话题标题话题标题</a><span class="addressor">发布者：名称&nbsp;&nbsp;&nbsp;发布日期：2016-06-17&nbsp;&nbsp;&nbsp;</span></h3>
										<p>话题内容话题内容话题内容话题内容话，题内容话题内容话题内容话题内容，话题内容话题内容话题内容话题内容话题，内容话题内容话题内容话题内容话题内容话。题内容话题内容话题内容话题内容话题内容...</p>
									</div>
								</li>
								<li>
									<a href=" " class="reply">已读</a>
									<div class="t_con">
										<h3><a href="tDetail.html">话题标题话题标题话题标题话题标题话题标题话题标题话题标题</a><span class="addressor">发布者：名称&nbsp;&nbsp;&nbsp;发布日期：2016-06-17&nbsp;&nbsp;&nbsp;</span></h3>
										<p>话题内容话题内容话题内容话题内容话，题内容话题内容话题内容话题内容，话题内容话题内容话题内容话题内容话题，内容话题内容话题内容话题内容话题内容话。题内容话题内容话题内容话题内容话题内容...</p>
									</div>
								</li>
								<li>
									<a href="" class="reply">已读</a>
									<div class="t_con">
										<h3><a href="tDetail.html">话题标题话题标题话题标题话题标题话题标题话题标题话题标题</a><span class="addressor">发布者：名称&nbsp;&nbsp;&nbsp;发布日期：2016-06-17&nbsp;&nbsp;&nbsp;</span></h3>
										<p>话题内容话题内容话题内容话题内容话，题内容话题内容话题内容话题内容，话题内容话题内容话题内容话题内容话题，内容话题内容话题内容话题内容话题内容话。题内容话题内容话题内容话题内容话题内容...</p>
									</div>
								</li>
								<li>
									<a href=" " class="reply">新回复</a>
									<div class="t_con">
										<h3><a href="tDetail.html">话题标题话题标题话题标题话题标题话题标题话题标题话题标题</a><span class="addressor">发布者：名称&nbsp;&nbsp;&nbsp;发布日期：2016-06-17&nbsp;&nbsp;&nbsp;</span></h3>
										<p>话题内容话题内容话题内容话题内容话，题内容话题内容话题内容话题内容，话题内容话题内容话题内容话题内容话题，内容话题内容话题内容话题内容话题内容话。题内容话题内容话题内容话题内容话题内容...</p>
									</div>
								</li>
								<li>
									<a href=" " class="reply">新回复</a>
									<div class="t_con">
										<h3><a href="tDetail.html">话题标题话题标题话题标题话题标题话题标题话题标题话题标题</a><span class="addressor">发布者：名称&nbsp;&nbsp;&nbsp;发布日期：2016-06-17&nbsp;&nbsp;&nbsp;</span></h3>
										<p>话题内容话题内容话题内容话题内容话，题内容话题内容话题内容话题内容，话题内容话题内容话题内容话题内容话题，内容话题内容话题内容话题内容话题内容话。题内容话题内容话题内容话题内容话题内容...</p>
									</div>
								</li>
								<li>
									<a href=" " class="reply">新回复</a>
									<div class="t_con">
										<h3><a href="tDetail.html">话题标题话题标题话题标题话题标题话题标题话题标题话题标题</a><span class="addressor">发布者：名称&nbsp;&nbsp;&nbsp;发布日期：2016-06-17&nbsp;&nbsp;&nbsp;</span></h3>
										<p>话题内容话题内容话题内容话题内容话，题内容话题内容话题内容话题内容，话题内容话题内容话题内容话题内容话题，内容话题内容话题内容话题内容话题内容话。题内容话题内容话题内容话题内容话题内容...</p>
									</div>
								</li>
							</ul>
						</div>
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
		<script src="its/message/message.js" type="text/javascript"></script>
	</body>
</html>