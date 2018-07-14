<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
   	 	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="js/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
		<div class="header_wrap">
			<div class="header">
				<span class="wel_word fl">欢迎访问互助教学系统-教师学生学习分享！</span>
				<span class="corner fr">
					<ul>
						<li><a href="indexUI.do">首页</a>|</li>
						<li><a href="javascript:;" class="bounceInDown">举报</a>|</li>
						<li class="register_li"><a href="authenticateUI.do">名师认证</a>|</li>	
						<c:choose>
							<c:when test="${empty its_user}">
								<li class="register_li"><a href="registerUI.do">注册</a>|</li>
								<li class="login_li"><a href="javascript:void(0);" class="tc">登录</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="uploadUI.do?id=${its_user.id}">上传</a>|</li>
								<li><a id="integral_user_id">积分：${its_user.integral}</a>|</li>
								<li><a id="message_user_id" href="messageUI.do">我的消息(${its_message})</a>|</li>
								<li class="user_li nLi">
									<c:choose>
										<c:when test="${its_user.valid==2}">
											<a id="login_user_id" href="javascript:void(0);" style="background: url(images/renzheng.png)right no-repeat;padding-right: 55px;">${its_user.username}</a>
										</c:when>
										<c:otherwise>
											<a id="login_user_id" href="javascript:void(0);">${its_user.username}</a>									
										</c:otherwise>
									</c:choose>	
									<div class="user_handle">
										<a href="personalUI.do?id=${its_user.id}">个人中心</a>
										<a href="ownTopicUI.do?id=${its_user.id}">我的话题</a>
										<a href="ownResourceUI.do">我的资源</a>
										<a href="passwordUI.do">修改密码</a>
										<a href="doExit.do">退出</a>
									</div>
								</li>
								<script type="text/javascript">
									$(document).ready(function(){
										refresh();
										setInterval(function(){								
											refresh();
										},3000);
									});
									function refresh(){
										$.post("getMessageAndIntegral.do?"+Date.parse(new Date),null,function(result){
											if(result.state==1){
												$("#integral_user_id").text("积分："+result.data.integral);
												$("#message_user_id").text("我的消息("+result.data.message+")");							
											}
										})
									}
								</script>
							</c:otherwise>
						</c:choose>						
					</ul>
					<div class="clear"></div>
				</span>
				<div class="clear"></div>
			</div>
			<div id="gray"></div>
			<c:if test="${empty its_user}">
				<div class="popup" id="popup">				
				<div class="top_nav" id='top_nav'>
					<div align="center">
						<i></i>
						<span>登录账号</span>
						<a class="guanbi"></a>
					</div>
				</div>					
				<div class="min">					
					<div class="tc_login">											
						<div class="login_register">
							<form id="form_login_id" method="POST" name="form_login" target="_top">
								<div align="center">
									<span id="login_error"class="error"></span>
									<i class="icon-mobile-phone"></i>
									<input type="text" name="name" id="name_id" required="required" placeholder="用户名" autocomplete="off" class="input_yh">
									<input type="password" name="pass" id="pass_id" required="required" placeholder="密码" autocomplete="off" class="input_mm">
								</div>
								<dd>
									<div class="user">
										<!-- <input type="checkbox" name="user" id="user" value="记住用户" class="r_user" />记住用户 -->
										<a href="passwordUI.do" target="_blank">忘记密码？</a>
									</div>
								</dd>
								<div align="center">
									<input type="submit" class="button btn_login" title="Sign In" value="登录">
								</div>
								<dd>
									<div align="center"><a href="registerUI.do" target="_blank">立即注册！</a></div>
								</dd>
							</form>
						</div>
					</div>
				</div>
			</div>
		</c:if>				
		</div>
		
		<div class="box">
			
		
		</div>
		<!-- 举报框 -->
		
		
		<div id="dialogBg"></div>
		<div id="dialog" class="animated">
			<img class="dialogIco" width="50" height="50" src="images/ico.png" alt="" />
			<div class="dialogTop">
				<a href="javascript:;" class="claseDialogBtn">关闭</a>
			</div>
			<form  method="post" id="editForm">
				<ul class="editInfos">
					<li><label><font color="#ff0000">* </font>昵称：<input type="text" name=""  value="" class="ipt" id="reportUser"/></label></li>
					<li><label><font color="#ff0000">* </font>链接：<input type="text" name=""  value="" class="ipt" id="reportLink"/></label></li>
					<li><label><font color="#ff0000">* </font>原因：<input type="text" name="" required value="" class="ipt" id="reportReason"/></label></li>
					<li><label><font color="#ff0000">* </font>举报用户填写昵称，举报其它填写链接（如果两项都不为空，默认按举报用户处理）</label></li>
					<li><input type="button" value="确认提交" class="submitBtn" onclick="doReport()"/></li>
				</ul>
			</form>
		</div>
		<script type="text/javascript">
			var w,h,className;
			function getSrceenWH(){
				w = $(window).width();
				h = $(window).height();
				$('#dialogBg').width(w).height(h);
			}
			window.onresize = function(){  
				getSrceenWH();
			}  
			$(window).resize();  
			$(function(){
				getSrceenWH();	
				//显示弹框
				$('.bounceInDown').click(function(){
					className = $(this).attr('class');
					$('#dialogBg').fadeIn(300);
					$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
				});
				
				//关闭弹窗
				$('.claseDialogBtn').click(function(){
					$('#dialogBg').fadeOut(300,function(){
						$('#dialog').addClass('bounceOutUp').fadeOut();
					});
				});
			});
			
			function doReport(){
				var url="doReport.do";
				var params={
						"user":$("#reportUser").val(),
						"link":$("#reportLink").val(),
						"reason":$("#reportReason").val()
				}
				$.post(url,params,function(result){
					if(result.state==1){
						alert("举报成功！");
						window.location.reload();
					}else{
						alert(result.message);
					}
				})
			}
		</script>
		<script src="its/login/login.js" type="text/javascript"></script>