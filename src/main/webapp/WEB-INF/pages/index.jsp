<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<style>
            .video-text{
                background-color:black; width:172px; height:45px;  margin-top:-45px;  font-size:14px; font-weight:bold; color:white;text-align: center;position:absolute;opacity:0.4;
            }
            .video-img{
                height: 143px;width: 172px;
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
		
		<!--banner start-->
		<div class="banner">
			<div class="bd">
				<ul>
					<li class="first"><a href="javascript:void(0);"></a></li>
					<li class="second"><a href="javascript:void(0);"></a></li>
					<li class="third"><a href="javascript:void(0);"></a></li>
					<li class="fourth"><a href="javascript:void(0);"></a></li>
				</ul>
			</div>
			<div class="hd"><ul></ul></div>
		</div>
		<!--notice start-->
		<div class="notice_wrap">
			<div class="notice">
				<div class="bd fl">
					<b>通知公告：</b>
					<ul class="infoList">
						<c:forEach var="notice" items="${notice}" >
							<li><span class='date'>[<fmt:formatDate value="${notice.createdTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>]</span>
							<a>${notice.content}</a></li>
						</c:forEach>
					</ul>
				</div>
				<!--<a href="notice.html" class="more fr">更多+</a>  -->
				<div class="clear"></div>
			</div>
		</div>
		<!--content start-->
		<div class="content">
			<!--about、news and hot-->
			<div class="box1">
				<div class="fl">
					<div class="about">
						<div class="b_title">
							<h3>本站概况</h3>
							<a href="aboutUI.do" class="more">更多+</a>
						</div>
						<div class="b_wrap">
							<div class="a_img fl">
								<img src="images/about.jpg" />
							</div>
							<div class="a_text fl">
								<p><b>摘  要：</b>随着我国宽带用户不断的增加，互联网技术为核心的信息技术的发展，为我国互助教学的实施奠定了坚实的基础。互助教学作为课内外辅助手段，越来越被广大使用所喜爱，为了迎接远程教育新时代的到来，我们需要研究一个互助教学系统，使用户在系统上提出的问题得到快速的解决。</p>
								<p>本文在对互助教学的历史与现状进行了基本的阐述，对当前网络交流环境进行综合分析及对发展趋势进行科学预测的基础上，从系统的内容需求、功能需求以及使用者心里需求等诸多方面，探讨了互助教学系统的开发模块，设计并实现了以互助为着眼点的互助教学系统...</p>	
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="news">
						<div class="b_title">
							<h3>新闻热点</h3>
							<a href="newsUI.do" class="more">更多+</a>
						</div>
						<div class="b_wrap">
							<div class="fl n_list">
								<h4>教育 · 新闻</h4>
								<ul id="eduNewsId">
									<li class="special">
										<div class="n_img">
											<img src="images/n1.jpg" />
										</div>
										<div class="n_text" id="eduNews">
											
										</div>
									</li>
								</ul>
							</div>
							<div class="fr n_list">
								<h4>时事 · 热点</h4>
								<ul id="timeNewsId">
									<li class="special">
										<div class="n_img">
											<img src="images/n2.jpg" />
										</div>
										<div class="n_text" id="timeNews">
										
										</div>
									</li>
								</ul>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				<div class="hot fr">
					<div class="b_title">
						<h3>热门话题</h3>
						<a href="bbs.do" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<ul id="topicId">
							<!-- <li>
								<div class="h_img">
									<img src="images/favicon.jpg" />
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名称</a></b>
									<p>话题名称话题名称话题名称,话题名称话题名称话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>	 -->						
						</ul>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			
			<!--resource and exam-->
			<div class="box3">
				<div class="resource fl">
					<div class="b_title">
						<h3>教学资源</h3>
						<a href="resourceUI.do" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<div class="fl n_list">
							<h4>文献 · 资料</h4>
							<ul id="pdfId">
								<!--<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li>  -->
							</ul>
						</div>
						<div class="fr n_list">
							<h4>学习 · 资料</h4>
							<ul id="rarId">
								<!--<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li>  -->
							</ul>
						</div>
						<div class="clear"></div>
						<div class="t_list">
							<h4>教学 · 视频</h4>
							<ul id="videoId">
								<!--<li><a href="tcDetail.html"><img class="video-img"  src="/uploads/images/video-bg-index.jpg"/>
                                <div class="video-text">这是浮于图片之上的文字</div></a></li>  -->
							</ul>
						</div>
					</div>
				</div>
				<div class="exam fr">
					<div class="b_title">
						<h3>活动安排</h3>
						<a href="activeUI.do" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<div class="n_list">
							<ul id="activeId">
								<!-- <li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li> -->
							</ul>
						</div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<!--friendly link-->
			<div class="friendlink">
				<b>友情链接：</b><a href="">友情链接</a><a href="">友情链接</a><a href="">友情链接</a><a href="">友情链接</a><a href="">友情链接</a>
			</div>
		</div>
		
		<!--footer start-->
		 <%@include file="footer.jsp" %>
		<!-- footer end -->
		
		<script type="text/javascript">
			jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });
			jQuery(".notice").slide({mainCell:".bd ul",autoPage:true,effect:"top",autoPlay:true,vis:1});
			jQuery(".schoolmate .b_wrap").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"left",autoPlay:true,vis:5,trigger:"click"});
		</script>
		<script src="js/DateFormat.js" type="text/javascript"></script>	
		<script src="its/index/active.js" type="text/javascript"></script>
		<script src="its/index/resource.js" type="text/javascript"></script>	
		<script src="its/index/topic.js" type="text/javascript"></script>
		<script src="its/index/news.js" type="text/javascript"></script>	
	</body>
</html>
