$(document).ready(function(){
   $("#form_password_id")
   .on("click","#send",doSendCode)
   .on("click","#rePassword",doRePassword)
});

function doRePassword(){
	var url="doRePassword.do";
	var params={
			"mail":$("#emial").val(),
			"code":$("#code").val(),
			"user":$("#user_id").val(),
			"pwd":$("#newPass_id").val()
	}
	$.post(url,params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			alert("密码修改成功！");
			window.location.href="indexUI.do";
		}else{
			alert(result.message);
		}
	});	
	return false;
}

function doSendCode(){
	var url="doSendCode.do";
	var params={
			"mail":$("#emial").val(),
			"user":$("#user_id").val()
	}
	$.post(url,params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			doAfter();
		}else{
			alert(result.message);
		}
	});	
	return false;
}
function doAfter(){
	$("#send").attr("disabled", true);
	var i=59;
	var interval=setInterval(function(){								
		$("#send").text(i+"s后可重新发送！");
		i--;
		if(i==0){
			$("#send").attr("disabled", false);
			$("#send").text("发送验证码");
			clearInterval(interval);
		}
	},1000);
}