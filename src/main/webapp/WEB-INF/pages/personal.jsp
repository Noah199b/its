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
					<a href="indexUI.do">首页</a>&nbsp;>&nbsp;用户相关>&nbsp;个人中心
				</div>
				<div class="inside_box">
					<div class="sidemenu fl">
						<div class="s_title">用户相关</div>
						<ul>
							<li class="on"><a href="personalUI.do">个人中心</a></li>
							<li><a href="ownTopicUI.do">我的话题</a></li>
							<li><a href="messageUI.do">消息中心</a></li>
							<li><a href="ownResourceUI.do">我的资源</a></li>
						</ul>
					</div>
					<div class="ic_wrap fr">
						<div class="personal_box">
							<div class="touxiang">
								<h2>设置头像</h2>
								<div id="clipArea"></div>
								<div class="pb_wrap">
									<input type="file" id="file" >
									<button id="clipBtn">截取</button>
								</div>
								<div id="view"></div>
							</div>
							<div class="info_box">
								<h2>基本信息</h2>
								<form action=""  id="form_updateuser_id" method="post">
									<input type="text" name="userid" id="userid" readonly value="${its_user.id}" style="display: none;"/>
									<label for="name">用户名称</label>
									<input type="text" name="name" id="name" readonly value="${its_user.username}"/>
									<label for="nc">设置昵称</label>
									<input type="text" name="nc" id="nc" value="${its_user.name}" placeholder="可设置个人专属昵称" maxlength="10" />
									<label for="qm">个性签名</label>
									<input type="text" name="qm" id="qm" value="${its_user.autograph}" placeholder="可添加个性签名" maxlength="50"/>
									<label for="email">电子邮箱：</label>
									<input type="email" name="email" id="email" readonly value="${its_user.email}" />
									<button type="submit" class="btn btn_updateAvatar">保存头像</button>
									<button type="reset" class="btn">重置</button>		
									<button type="submit" class="btn btn_update">保存</button>
									<span id="updateuser_error" class="error"></span>
								</form>
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
		
		<script src="js/iscroll-zoom.js"></script>
		<script src="js/hammer.js"></script>
		<script src="js/lrz.all.bundle.js"></script>
		<script src="js/jquery.photoClip.js"></script>
		<script>
		//document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
		var clipArea = new bjj.PhotoClip("#clipArea", {
			size: [260, 260],
			outputSize: [640, 640],
			file: "#file",
			view: "#view",
			ok: "#clipBtn",
			loadStart: function() {
				console.log("照片读取中");
			},
			loadComplete: function() {
				console.log("照片读取完成");
			},
			clipFinish: function(dataURL) {
				console.log(dataURL);
			}
		});
		//clipArea.destroy();
		</script>
		<script src="its/login/personal.js" type="text/javascript"></script>
	</body>
</html>