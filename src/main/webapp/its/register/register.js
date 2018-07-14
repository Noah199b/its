$(document).ready(function(){
   $("#form_register_id")
   .on("click",".btn_register",doRegister)
   .on("blur","#username_id",doCheckUsername)
   .on("blur","#password_id",doCheckPassword)
});

function doCheckPassword(){
	var params={//根据id获得数据
			  "pwd1":$("#password_first").val(),
			  "pwd2":$("#password_id").val()
	}
	var url="doCheckPassword.do";
	$.post(url,params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==0){
			$('.error').text(result.message);
			$(".btn_register").attr("disabled", true); 
		}else{
			$('.error').text("密码输入正确！");
			$(".btn_register").attr("disabled", false); 
		}
	});	
}
function doCheckUsername(){
	var params={//根据id获得数据
			  "username":$("#username_id").val()
	}
	var url="doCheckUsername.do";
	$.post(url,params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==0){
			$('.error').text(result.message);
			$(".btn_register").attr("disabled", true);
		}else{
			$('.error').text("该用户名可用！");
			$(".btn_register").attr("disabled", false); 
		}
	});	
}
function doRegister(){
	var params={//根据id获得数据
			  "username":$("#username_id").val(),
			  "password":$("#password_id").val(),
			  "email":$("#email_id").val(),
			  "valid":1,
			  "createdUser":$("#username_id").val(),
		  }
	var url="doRegister.do";
	$.post(url,params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			alert("注册成功！将跳转到主界面！");
			$(window).attr('location','indexUI.do');
		}else if(result.state==0){
			$('.error').text(result.message);
		}
	});	
	return false;
}
