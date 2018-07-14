$(document).ready(function(){
   $("#form_updateuser_id")
   .on("click",".btn_update",updateUserInfo)
   .on("click",".btn_updateAvatar",updateAvatar)
});

function updateUserInfo(){	
	var url="updateUserInfo.do";
	var param={
			"id":$("#userid").val(),
			"username":$("#name").val(),
			"name":$("#nc").val(),
			"autograph":$("#qm").val()
	};
	$.post(url,param,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			alert("用户信息修改成功！");
			window.location.href="ownTopicUI.do?id="+$("#userid").val();//跳转到我的话题
		}else if(result.state==0){
			$(".error").text(result.message);
		}		
	})
	return false;
}
//更新头像
function updateAvatar(){
	var url="updateAvatar.do";
	var imgData=$("#view").css("background-image");
	var params={
		"id":$("#userid").val(),
		"username":$('#name').val(),
		"avatar":imgData
	};
	$.post(url,params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			alert("头像保存成功！");	
			window.location.href="ownTopicUI.do?id="+$("#userid").val();//跳转到我的话题
		}else if(result.state==0){
			alert(result.message);
		}		
	})	
	return false;
}