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
		<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
		<link href="css/froala_editor.min.css" rel="stylesheet" type="text/css">
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
					<a href="indexUI.do">首页</a>&nbsp;>&nbsp;<a href="bbs.do">微·论坛</a>>&nbsp;发布话题
				</div>
				<div class="inside_box">
					<div class="public_wrap">
						<div class="public_box">
							<h2>发布话题:<span class="tishi">在这里你可以发布问题、感想、经验、心得等话题，自由发布自由交流</span></h2>
							<form id="form_publish_id" action="" method="post">
								<label for="title">话题标题（10-50字）:<span class="tishi">简短一些让其他人快速了解你的话题</span></label>
								<textarea name="title" id="title" value="" maxlength="50"></textarea>
								<div class="editor">
									<label for="title">话题内容(255-10240字节):</label>
									<section id="editor">
								        <div id='edit'></div>
								    </section>
								    <button type="submit" class="btn submit_btn" value="${its_user.id}">发表</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--footer start-->
		 <%@include file="footer.jsp" %>
		<!-- footer end -->
		
		<script src="js/froala_editor.min.js"></script>
		<!--[if lt IE 9]>
		    <script src="js/froala_editor_ie8.min.js"></script>
		<![endif]-->
		<script src="js/plugins/tables.min.js"></script>
		<script src="js/plugins/lists.min.js"></script>
		<script src="js/plugins/colors.min.js"></script>
		<script src="js/plugins/media_manager.min.js"></script>
		<script src="js/plugins/font_family.min.js"></script>
		<script src="js/plugins/font_size.min.js"></script>
		<script src="js/plugins/block_styles.min.js"></script>
		<script src="js/plugins/video.min.js"></script>
		<script type="text/javascript">
		$(function(){
		    $('#edit').editable({inlineMode: false, alwaysBlank: true});
		    $(".replyinfo .replynum").addClass("active");
		    $(".replyinfo .replynum").click(function(){
		    	var replyBox = $(this).parents(".replyinfo").siblings(".del_reply_wp");
		    	if(replyBox.css("display")=="block"){
		    		replyBox.css("display","none");
		    		$(this).removeClass("active");
		    	}else{
		    		replyBox.css("display","block");
		    		$(this).addClass("active");
		    	}
		    });
		});
		</script>
		<script src="its/bbs/public.js" type="text/javascript"></script>
	</body>
</html>