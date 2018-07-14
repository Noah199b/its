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
		<link rel="stylesheet" href="css/pro.style.css">
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
					<a href="index.html">首页</a>&nbsp;>&nbsp;上传
				</div>
				<div class="register_box">
					<div class="tc_login">
						<div class="login_register fl">
							<form method="POST"
								id="uploadFormId" enctype="multipart/form-data">
								<div align="center">
									<h3>上传资源</h3>
									<span class="error"></span>
									<input type="text" name="title" id="title" value="" placeholder="资源标题（5-30字）" maxlength=30 onblur="checkTitle(this);"/>
								    <input type="text" name="desc" id="desc" value="" placeholder="资源简述（10-100字）" maxlength=100 onblur="checkDesc(this);"/>
								    <input type="number" name="downloadIntegral" id="downloadIntegral" value="" placeholder="下载所需积分(0-99积分)" max="99" min="0"onblur="checkIntegral(this);"/>
									<input type="file" class="file" name="mFile"></input>
								</div>
								<div align="center">
									<input type="submit" class="button btn-upload" title="文件上传" value="上传">
								</div>
								<div class="box">
                                    <div class="tbox">
                                        <div class="tiao"></div>
                                    </div>
                                </div> 
							</form>
						</div>
						<div class="l_img fl">
							<img src="images/sj.jpg"/>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>

		<!--footer start-->
		 <%@include file="footer.jsp" %>
		<!-- footer end -->
		<script src="js/jquery.form.js" type="text/javascript"></script>
		<script src="its/resource/upload.js" type="text/javascript"></script>		
	</body>
</html>