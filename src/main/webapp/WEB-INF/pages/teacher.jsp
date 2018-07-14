<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="keywords" content="互助教学系统" />
		<meta name="description" content="互助教学系统-教师学生学习分享" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>互助教学系统-教师学生学习分享</title>		
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/popup.css"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/baguetteBox.min.css">
		<link rel="stylesheet" href="css/thumbnail-gallery.css">
		<link rel="stylesheet" type="text/css" href="css/search/normalize.css" />
		<link rel="stylesheet" href="css/search/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="css/search/demo.css">
		<link rel="stylesheet" href="css/search/style.css">		
		<link rel="stylesheet" type="text/css" href="css/jquery.pagination.css"/>
	</head>
	<body>
		<!-- header start -->
		 <%@include file="header.jsp" %>
		<!-- header end -->
		<div class="search d1">
			<form method="POST" id="searchId">
			  <input type="text" placeholder="用户名/教师姓名/学历/专业/毕业院校" id="search_key">
			  <button type="button" id="btn_search"></button>
			</form>
		</div>
		<!--inside content start-->
		<div class="htmleaf-container">
			<div class="container gallery-container">
			    
			    <div class="tz-gallery">
	
			        <div class="row">
	
			            <!-- <div class="col-sm-6 col-md-4">
			                <div class="thumbnail">
			                    <a class="lightbox" href="ownTopic1UI.do?id=?">
			                        <img src="images/park.jpg" alt="Park">
			                    </a>
			                    <div class="caption">
			                        <h3>Thumbnail label</h3>
			                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			                    </div>
			                </div>
			            </div>
			            <div class="col-sm-6 col-md-4">
			                <div class="thumbnail">
			                    <a class="lightbox" href="images/bridge.jpg">
			                        <img src="images/bridge.jpg" alt="Bridge">
			                    </a>
			                    <div class="caption">
			                        <h3>Thumbnail label</h3>
			                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			                    </div>
			                </div>
			            </div>
			            <div class="col-sm-6 col-md-4">
			                <div class="thumbnail">
			                    <a class="lightbox" href="images/tunnel.jpg">
			                        <img src="images/tunnel.jpg" alt="Tunnel">
			                    </a>
			                    <div class="caption">
			                        <h3>Thumbnail label</h3>
			                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			                    </div>
			                </div>
			            </div>
			            <div class="col-sm-6 col-md-4">
			                <div class="thumbnail">
			                    <a class="lightbox" href="images/coast.jpg">
			                        <img src="images/coast.jpg" alt="Coast">
			                    </a>
			                    <div class="caption">
			                        <h3>Thumbnail label</h3>
			                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			                    </div>
			                </div>
			            </div>
			            <div class="col-sm-6 col-md-4">
			                <div class="thumbnail">
			                    <a class="lightbox" href="images/rails.jpg">
			                        <img src="images/rails.jpg" alt="Rails">
			                    </a>
			                    <div class="caption">
			                        <h3>Thumbnail label</h3>
			                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			                    </div>
			                </div>
			            </div>
			            <div class="col-sm-6 col-md-4">
			                <div class="thumbnail">
			                    <a class="lightbox" href="images/traffic.jpg">
			                        <img src="images/traffic.jpg" alt="Traffic">
			                    </a>
			                    <div class="caption">
			                        <h3>Thumbnail label</h3>
			                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			                    </div>
			                </div>
			            </div> -->
			        </div>
	
			    </div>
	
			</div>
			
		</div>
		<!--分页-->
		<div class="pages">
			<div id="Pagination"></div>
		</div>
		<!--footer start-->
		 <%@include file="footer.jsp" %>
		<!-- footer end -->
		<script type="text/javascript" src="js/baguetteBox.min.js"></script>
		<script type="text/javascript">
			baguetteBox.run('.tz-gallery');
		</script>
   	 	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="js/jquery.pagination.min.js" type="text/javascript"></script>		
		<script type="text/javascript" src="its/teacher/teacher.js"></script>
</body>
</heml>