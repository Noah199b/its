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
		<link rel="stylesheet" href="css/reply.style.css" />
		<link href="css/video-js.css" rel="stylesheet" type="text/css">
		<style>
			.btn_reply,.btn_download{
				padding: 0px 8px 0px 8px; background: #36A803; border: solid 1px #019A0D; color: #fff; font-size: 13px; cursor: pointer;margin-right: 2px;
			}
		</style>
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
					<a href="index.html">首页</a>&nbsp;>&nbsp;教学资源
				</div>
				<div class="inside_box">
					<div class="sidemenu fl">
						<div class="s_title">教学资源</div>
						<ul>
							<li class="on"><a>视频资料</a></li>
						</ul>
					</div>
					<div class="ic_wrap fr">
						<h3 class="n_title">资源下载界面
							<span class="n_date">上传日期：2016-06-06
							&nbsp;&nbsp;&nbsp;资源评分：4.8
							&nbsp;&nbsp;&nbsp;资源类型：2-视频资料</span>
						</h3>
						<div class="n_link">
	                        <ul>
								<li>资源简述：
                                	<a id="description">啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦</a>
                                </li>
	                            <li>
							                        下载所需积分：<a id="downloadIntegral">2积分</a>&nbsp;&nbsp;&nbsp;
							                         资源大小：<a id="size">512M</a>&nbsp;&nbsp;&nbsp;
							                         下载次数：<a id="downloadCount">222</a>&nbsp;&nbsp;&nbsp;
						                                     资源下载：&nbsp;&nbsp;&nbsp;
                                	<button type="submit" class="btn_download"
                                    style=" padding: 0px 8px 0px 8px; background: #36A803; border: solid 1px #019A0D; color: #fff; font-size: 13px; cursor: pointer;margin-right: 2px;">本地下载</button>
                                  	 &nbsp;&nbsp;&nbsp; 资源拥有：<a id="createdUser">TEST</a>
                                </li>
	                              <li>
	                              <br>
	                                <div class="m">
	                                 <video id="my-video" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="auto" width="740" height="400"poster="/uploads/images/video-bg.jpg" data-setup="{}">
	                                    <source src="${video_resource.path}" type="video/mp4">
	                                    <p class="vjs-no-js"> To view this video please enable JavaScript, and consider upgrading to a web browser that 
	                                    	<a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
	                                    </p>
	                                  </video>
	                                  <script src="js/video.min.js"></script> 
	                                  <script src="js/zh-CN.js"></script> 
	                                </div>
	                            </li>                   
	                        </ul>
	                    </div>
						<!--reply start-->
						 <%@include file="reply.jsp" %>
						<!-- reply end -->
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<!--footer start-->
		 <%@include file="footer.jsp" %>
		<!-- footer end -->
		<script type="text/javascript" src="js/comment.js"></script>
		<script src="js/DateFormat.js" type="text/javascript"></script>	
		<script src="js/pdfobject.js"></script>
		<script src="its/resource/resource2.js" type="text/javascript"></script>
	</body>
</html>