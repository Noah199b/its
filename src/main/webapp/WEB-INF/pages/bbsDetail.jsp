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
					<a href="indexUI.do">首页</a>&nbsp;>&nbsp;微·论坛
				</div>
						<div class="inside_box">
					<div class="topic_wrap fl">
						<div class="t_label">
							<h2>话题内容</h2>
						</div>
						<div class="tl_con">
						
							<div class="reply_wrap" id="reply">
								<!--<div class="r_title">共4个回复</div>  -->
								<!--<ul class="talk_list">
									<li class="backview">
										<div class="det_l">
											<a href="ownTopic1.html" class="avatar"><img src="images/favicon.jpg"/></a>
										</div>
										<div class="li_cont">
											<div class="info">
												<span class="i_name"><a href="ownTopic1.html">用户名称</a><span class="date">2016-06-17 14:00</span></span>
											</div>
											<div class="li_t editor_style">
												<p>回复内容</p>
											</div>
											<div class="info replyinfo">
												<span class="replynum"><a href="javascript:void(0);">全部回复(1)</a></span>
											</div>
											<div class="del_reply_wp">
												<ul class="del_repy">
													<li class="cl">
														<a href="ownTopic1.html" class="avatar"><img src="images/favicon.jpg"/></a>
														<div class="cl_cont">
															<div class="info">
																<span class="i_name"><a href="ownTopic1.html">用户名称</a><span class="date">2016-06-17 14:00</span></span>
															</div>
															<div class="li_t editor_style">
																<p>回复内容</p>
															</div>
														</div>
													</li>
												</ul>
												<div class="del_reply_input_cl">
													<form action="" method="post">
														<textarea placeholder="回复XX" name="content"></textarea>
														<div class="del_reply_btn">
															<a href="javascript:void(0);" class="cancel">取消</a>
															<button type="submit" class="btn submit_btn">回复</button>
														</div>
														<div class="clear"></div>
													</form>
												</div>
											</div>
										</div>
									</li>
									<li class="backview">
										<div class="det_l">
											<a href="ownTopic1.html" class="avatar"><img src="images/favicon.jpg"/></a>
										</div>
										<div class="li_cont">
											<div class="info">
												<span class="i_name"><a href="ownTopic1.html">用户名称</a><span class="date">2016-06-17 14:00</span></span>
											</div>
											<div class="li_t editor_style">
												<p>回复内容</p>
											</div>
											<div class="info replyinfo">
												<span class="replynum"><a href="javascript:void(0);">发表回复</a></span>
											</div>
											<div class="del_reply_wp">
												<div class="del_reply_input_cl">
													<form action="" method="post">
														<textarea placeholder="回复XX" name="content"></textarea>
														<div class="del_reply_btn">
															<a href="javascript:void(0);" class="cancel">取消</a>
															<button type="submit" class="btn submit_btn">回复</button>
														</div>
														<div class="clear"></div>
													</form>
												</div>
											</div>
										</div>
									</li>
								</ul>  -->
							</div>
							<div class="editor">
								<div class="avatar">
									<a href="javascript:void(0);"><img src="${its_user.avatar}"/></a>
								</div>
								<section id="editor">
							        <div id='edit'></div>
							    </section>
							    <button type="submit" class="btn submit_btn">发表</button>
							</div>
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
		<script src="js/DateFormat.js" type="text/javascript"></script>
		<script src="its/bbs/tDetail.js" type="text/javascript"></script>
	</body>
</html>