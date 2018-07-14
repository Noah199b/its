$(document).ready(function(){
   $("#form_publish_id")
   .on("click",".submit_btn",doPublish)
});

function doPublish(){
	var content=$(".froala-element").html();
	var contentText=$(".froala-element").text();	
	if(contentText.length>=100){
		contentText=contentText.substr(0,100);
	}
	var params={//根据id获得数据
			  "title":$("#title").val(),
			  "content":content,
			  "contentText":contentText,
			  "userId":$(".submit_btn").val()
		  }
	var url="doPublish.do";	
	$.post(url,params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			alert("话题发表成功，将跳转到话题！积分+5");
			$(window).attr('location','tDetail.do?id='+result.data.id);//跳转话题到话题
		}else if(result.state==0){
			alert(result.message);
		}
	});	
	return false;
}
