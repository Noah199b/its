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
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/gloab.css" rel="stylesheet">
		<link href="css/index.css" rel="stylesheet">
		<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="js/jquery.form.js" type="text/javascript"></script>
	</head>
	<body>
	<div class="inside_wrap">
		<div class="inside_con">
			<div class="adr">
				<a href="indexUI.do">首页</a>&nbsp;>&nbsp;名师认证
			</div>
			<div class="login-box f-mt10 f-pb50">
				<div class="main bgf">    
			    	<div class="reg-box-pan display-inline">  
			        	<div class="step">        	
			                <ul>
			                    <li class="col-xs-4 on">
			                        <span class="num"><em class="f-r5"></em><i>1</i></span>                	
			                        <span class="line_bg lbg-r"></span>
			                        <p class="lbg-txt">填写基本信息</p>
			                    </li>
			                    <li class="col-xs-4">
			                        <span class="num"><em class="f-r5"></em><i>2</i></span>
			                        <span class="line_bg lbg-l"></span>
			                        <span class="line_bg lbg-r"></span>
			                        <p class="lbg-txt">提交认证材料</p>
			                    </li>
			                    <li class="col-xs-4">
			                        <span class="num"><em class="f-r5"></em><i>3</i></span>
			                        <span class="line_bg lbg-l"></span>
			                        <p class="lbg-txt">结果</p>
			                    </li>
			                </ul>
			            </div>
			        	<div class="reg-box" id="verifyCheck" style="margin-top:20px;">
			            	<div class="part1">                	
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>用户名：</span>    
			                        <div class="f-fl item-ifo">
			                            <input type="hidden" maxlength="20" class="txt03 f-r3 required" tabindex="1" value="${its_user.id}" id="user_id"/>
			                            <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="1" readonly value="${its_user.username}" id="username"/>
			                            <label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>当前登录用户</span></label>
			                            <label class="focus valid"></label>
			                        </div>
			                    </div>
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>邮箱号：</span>    
			                        <div class="f-fl item-ifo">
			                            <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="2" readonly value="${its_user.email}" id="email"/>
			                            <label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>用户邮箱</span></label>
			                            <label class="focus valid"></label>
			                        </div>
			                    </div>
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>手机号：</span>    
			                        <div class="f-fl item-ifo">
			                            <input type="text" class="txt03 f-r3 required" keycodes="tel" tabindex="3" data-valid="isNonEmpty||isPhone" data-error="手机号码不能为空||手机号码格式不正确" maxlength="11" id="tel" /> 
			                            <span class="ie8 icon-close close hide"></span>                           
			                            <label class="icon-sucessfill blank hide"></label>
			                            <label class="focus">请填写11位有效的手机号码</label>
			                            <label class="focus valid"></label>
			                        </div>
			                    </div>
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>真实姓名：</span>    
			                        <div class="f-fl item-ifo">
			                            <input type="text" maxlength="10" class="txt03 f-r3 required" tabindex="4" data-valid="isNonEmpty||between:2-10||isZh" data-error="真实姓名不能为空||真实姓名长度2-10位||只能输入中文" id="name" />   
			                            <span class="ie8 icon-close close hide"></span>                         
			                            <label class="icon-sucessfill blank hide"></label>
			                            <label class="focus">2-10位，中文真实姓名</label>
			                            <label class="focus valid"></label>
			                        </div>
			                    </div>
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>身份证号：</span>    
			                        <div class="f-fl item-ifo">
			                            <input type="text" class="txt03 f-r3 required" tabindex="5" data-valid="isNonEmpty||isCard" data-error="身份证号不能为空||身份证号码格式不正确" maxlength="18" id="idNo" />    
			                            <span class="ie8 icon-close close hide"></span>                        
			                            <label class="icon-sucessfill blank hide"></label>
			                            <label class="focus">请填写18位有效的身份证号码</label>
			                            <label class="focus valid"></label>
			                        </div>
			                    </div>
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>专业：</span>    
			                        <div class="f-fl item-ifo">
			                            <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="6" id="speciality"/>
			                            <label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>您的专业</span></label>
			                            <label class="focus valid"></label>
			                        </div>
			                    </div>
			                   	<div class="item col-xs-12">
			                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>学历：</span>    
			                        <div class="f-fl item-ifo">
			                            <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="6" id="edu"/>
			                            <label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>您的学历</span></label>
			                            <label class="focus valid"></label>
			                        </div>
			                    </div>
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>毕业院校：</span>    
			                        <div class="f-fl item-ifo">
			                            <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="7" id="school"/>
			                            <label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>您的毕业院校</span></label>
			                            <label class="focus valid"></label>
			                        </div>
			                    </div>
			                   	<div class="item col-xs-12">
			                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>工作单位：</span>    
			                        <div class="f-fl item-ifo">
			                            <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="8" id="workspace"/>
			                            <label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>您的工作单位（详细）</span></label>
			                            <label class="focus valid"></label>
			                        </div>
			                    </div>
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>QQ：</span>    
			                        <div class="f-fl item-ifo">
			                            <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="9" id="qq"/>
			                            <label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>您的QQ,用于在线解答服务</span></label>
			                            <label class="focus valid"></label>
			                        </div>
			                    </div>
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>微信：</span>    
			                        <div class="f-fl item-ifo">
			                            <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="10" id="wechat"/>
			                            <label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>您的微信，您的QQ,用于在线解答服务</span></label>
			                            <label class="focus valid"></label>
			                        </div>
			                    </div>
			                    <div class="item col-xs-12" style="height:auto">
			                        <span class="intelligent-label f-fl">&nbsp;</span>  
			                        <p class="f-size14 required"  data-valid="isChecked" data-error="请先同意条款"> 
			                        	<input type="checkbox" checked /><a href="javascript:showoutc();" class="f-ml5">我已阅读并同意条款</a>
			                        </p>                       
			                        <label class="focus valid"></label> 
			                    </div> 
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl">&nbsp;</span>    
			                        <div class="f-fl item-ifo">
			                           <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part1">下一步</a>                         
			                        </div>
			                    </div> 
			                </div>
			                <div class="part2" style="display:none">
			                	<div class="alert alert-info" style="width:700px">验证码已发送至您的邮箱，请输入邮件中的验证码，确保您的邮箱真实有效。</div>                    
			                    <div class="item col-xs-12 f-mb10" style="height:auto">
			                        <span class="intelligent-label f-fl">邮箱：</span>    
			                        <div class="f-fl item-ifo c-blue" id="email_id">
			                            ${its_user.email}
			                        </div>
			                    </div>
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>验证码：</span>    
			                        <div class="f-fl item-ifo">
			                            <input type="text" maxlength="6" id="verifyNo" class="txt03 f-r3 f-fl required" tabindex="4" style="width:167px" data-valid="isNonEmpty||isInt" data-error="验证码不能为空||请输入6位数字验证码"/> 
			                           	<span class="btn btn-gray f-r3 f-ml5 f-size13" id="time_box" disabled style="width:97px;display:none;">发送验证码</span>
			                            <span class="btn btn-gray f-r3 f-ml5 f-size13" id="verifyYz" style="width:97px;" onclick="doSendCode();">发送验证码</span>
			                            <span class="ie8 icon-close close hide" style="right:130px"></span>
			                            <label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>请查收邮件，并填写邮件中的验证码（此验证码30分钟内有效）</span></label>   
			                            <label class="focus valid"></label>                        
			                        </div>
			                    </div>
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl">&nbsp;</span>    
			                        <div class="f-fl item-ifo">
			                           <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part2">下一步</a>                         
			                        </div>
			                    </div> 
			                </div>
			                <div class="part3" style="display:none">
			                	<form method="POST"
								id="uploadFormId" enctype="multipart/form-data">
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl"><b class="ftx04">*</b>身份证1：</span>
				                    <div class="f-fl item-ifo">
										<input type="file" class="file" name="mFile1"></input>
										<label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>正面</span></label>
			                            <label class="focus valid"></label>
				                    </div>
			                     </div>
			                     <div class="item col-xs-12">
									<span class="intelligent-label f-fl"><b class="ftx04">*</b>身份证2：</span>
				                    <div class="f-fl item-ifo">
										<input type="file" class="file" name="mFile2"></input>
										<label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>反面</span></label>
			                            <label class="focus valid"></label>
				                    </div>
			                     </div>
			                     <div class="item col-xs-12">
									<span class="intelligent-label f-fl"><b class="ftx04">*</b>辅助1：</span>
				                    <div class="f-fl item-ifo">
										<input type="file" class="file" name="mFile3"></input>
										<label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>其它证明1-3张</span></label>
			                            <label class="focus valid"></label>
				                    </div>
			                     </div>
			                     <div class="item col-xs-12">
									<span class="intelligent-label f-fl">辅助2：</span>
				                    <div class="f-fl item-ifo">
										<input type="file" class="file" name="mFile4"></input>
										<label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>其它证明1-3张</span></label>
			                            <label class="focus valid"></label>
				                    </div>
			                     </div>
			                     <div class="item col-xs-12">
									<span class="intelligent-label f-fl">辅助3：</span>
				                    <div class="f-fl item-ifo">
										<input type="file" class="file" name="mFile5"></input>
										<label class="icon-sucessfill blank hide"></label>
			                            <label class="focus"><span>其它证明1-3张</span></label>
			                            <label class="focus valid"></label>
				                    </div>
			                     </div>
			                    <div class="item col-xs-12">
			                        <span class="intelligent-label f-fl">&nbsp;</span>    
			                        <div class="f-fl item-ifo">
			                           <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part3">提交申请</a>                         
			                        </div>
			                    </div>
			                    </form>
			                </div>  
			                <div class="part4 text-center" style="display:none">
			                	<h3>提交成功，7个工作日内反馈审核结果到您的邮箱！</h3>
			                    <p class="c-666 f-mt30 f-mb50">页面将在 <strong id="times" class="f-size18">10</strong> 秒钟后，跳转到 <a href="indexUI.do" class="c-blue">首页</a></p>
			                </div>          
			            </div>
			        </div>
			    </div>
			</div>
			<div class="m-sPopBg" style="z-index:998;"></div>
			<div class="m-sPopCon regcon">
				<div class="m-sPopTitle"><strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b></div>
			    <div class="apply_up_content">
			    	<pre class="f-r0">
					<strong>同意以下服务条款，提交注册信息</strong>
			        </pre>
			    </div>
			    <center><a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3" href="javascript:closeClause();">已阅读并同意此条款</a></center>
			</div>
		</div>
	</div>
		<script>
		$(function(){
			//方便测试
			//$(".part1").hide();
			//$(".part3").show();
			//第一页的确定按钮
			$("#btn_part1").click(function(){
				var url="checkPart1.do"
				var params={
						"username":$("#username").val(),
						"email":$("#email").val(),
						"tel":$("#tel").val(),
						"name":$("#name").val(),
						"idNo":$("#idNo").val(),
						"edu":$("#edu").val(),
						"school":$("#school").val(),
						"workspace":$("#workspace").val(),
						"qq":$("#qq").val(),
						"wechat":$("#wechat").val(),
						"speciality":$("#speciality").val()
				}
				$.post(url,params,function(result){
					if(result.state==1){
						$(".part1").hide();
						$(".part2").show();
						$(".step li").eq(1).addClass("on");
						$(".alert-info").hide();
					}else{
						alert(result.message);
					}
				});
			});
			//第二页的确定按钮
			$("#btn_part2").click(function(){
				var url="checkPart2.do";
				var params={
						"code":$("#verifyNo").val(),
						"mail":$("#email").val()
				}
				$.post(url,params,function(result){
					if(result.state==1){
						$(".part2").hide();
						$(".part3").show();	
					}else{
						alert(result.message);
					}
				});

			});	
			//第三页的确定按钮
			$("#btn_part3").click(function(){
				$("#uploadFormId").ajaxSubmit({
					type:"post",
					url:"uploadOthers.do",
					dataType:"json",
					success:function(result){			
						if(result.state==1){
							$(".part3").hide();
							$(".part4").show();
							$(".step li").eq(2).addClass("on");	
							var i=10
							var interval=setInterval(function(){								
								$("#times").text(i);
								i--;
								if(i==0){
									window.location.href="indexUI.do";
									clearInterval(interval);
								}
							},1000);
						}else{
							alert(result.message);
						}			
					}
				});	
			});	
		});
		function showoutc(){$(".m-sPopBg,.m-sPopCon").show();}
		function closeClause(){
			$(".m-sPopBg,.m-sPopCon").hide();		
		}
		</script>	
		<script src="its/auth/auth.js" type="text/javascript"></script>
	</body>
</heml>