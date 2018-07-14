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
					<a href="indexUI.do">首页</a>&nbsp;>&nbsp;本站概况
				</div>
				<div class="inside_box">
					<div class="sidemenu fl">
						<div class="s_title">本站概况</div>
						<ul>
							<li class="on"><a href="aboutUI.do">本站概况</a></li>
						</ul>
					</div>
					<div class="ic_wrap fr">
						<h1 style="text-align: center;">互助教学系统的设计与实现</h1><br>
						<p><b>摘  要：</b>随着我国宽带用户不断的增加，互联网技术为核心的信息技术的发展，为我国互助教学的实施奠定了坚实的基础。互助教学作为课内外辅助手段，越来越被广大使用所喜爱，为了迎接远程教育新时代的到来，我们需要研究一个互助教学系统，使用户在系统上提出的问题得到快速的解决。</p>
						<p>本文在对互助教学的历史与现状进行了基本的阐述，对当前网络交流环境进行综合分析及对发展趋势进行科学预测的基础上，从系统的内容需求、功能需求以及使用者心里需求等诸多方面，探讨了互助教学系统的开发模块，设计并实现了以互助为着眼点的互助教学系统。在研究互助教学系统开发的基本依据方面，主要研究互助教学的交互背景、网络教学的设计目的与意义，由此明确了开发的基本方向；在研究相关理论与技术方面，明确了开发的基本理论依据，在构建互助教学交互系统时，具体需要哪些基本工具来支持系统开发；在系统总体分析与总体框架设计方面，主要是明确系统中潜在的用户需求、硬件需求、方案设计，互助教学模块的系统分析，提出了系统的构建框架，并分析了系统实现过程当中具备哪些功能，以及重点讨论了互助教学中交流设计的方式，进一步明确了交流系统开发具备的特色：在系统设计与实现方面，着重设计了交流互动方式，使用户能够实现在线讨论，解决问题，资源分享等。</p>						
						<h1  style="text-align: center;">The Design And Implementation Of Mutual Assistance Teaching System</h1><br>
						<p><b>Abstract：</b>With the increasing number of broadband users in our country and the development of information technology with the core of Internet technology, it has laid a solid foundation for the implementation of mutual aid teaching in our country. As an auxiliary means in and out of class, mutual aid teaching is more and more popular in the extensive use. In order to meet the arrival of the new era of distance education, we need to study a mutual aid teaching system so that the problems raised by users in the system can be solved quickly.</p>
						<p>On the basis of analyzing the history and present situation of mutual aid teaching, synthetically analyzing the current network communication environment and scientifically predicting the development trend, this paper is based on the content demand of the system. This paper discusses the development module of the mutual aid teaching system, designs and realizes the mutual aid teaching system with mutual aid as the starting point, and studies the basic basis of the development of the mutual aid teaching system. This paper mainly studies the interactive background of mutual aid teaching, the design purpose and significance of network teaching, and defines the basic direction of development, the basic theoretical basis of development in the research of related theory and technology. What basic tools are needed to support the development of the system, and in the aspect of system overall analysis and overall framework design, it is mainly to clarify the potential user needs, hardware requirements, and project design of the system. The system analysis of the mutual aid teaching module, the construction frame of the system is put forward, and the functions of the system are analyzed, and the communication design method in the mutual aid teaching is discussed. The characteristics of communication system development are further clarified: in system design and implementation, the interactive communication mode is designed to enable users to realize online discussion, problem solving, resource sharing and so on.</p>
					</div>
					<div class="clear"></div>
				</div>
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
	</body>
</html>