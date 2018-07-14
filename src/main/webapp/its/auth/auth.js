function doSendCode(){
	var url="doSendCode.do";
	var params={
			"mail":$("#email").val(),
			"user":$("#username").val()
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
	$(".alert-info").show();
	$("#verifyYz").attr("disabled", true);
	var i=59;
	var interval=setInterval(function(){								
		$("#verifyYz").text(i+"s后可发送");
		i--;
		if(i==0){
			$("#verifyYz").attr("disabled", false);
			$("#verifyYz").text("发送验证码");
			clearInterval(interval);
		}
	},1000);
}