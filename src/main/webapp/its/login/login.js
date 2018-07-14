$(document).ready(function(){
   $("#form_login_id")
   .on("click",".btn_login",doLogin)
});

function doLogin(){
	var params={//根据id获得数据
			  "username":$("#name_id").val(),
			  "password":$("#pass_id").val()
		  }
	var url="doLogin.do";
	$.post(url,params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			alert("登录成功！");
			window.location.reload();//刷新页面
		}else if(result.state==0){
			$('#login_error').text(result.message);
		}
	});	
	return false;
}
