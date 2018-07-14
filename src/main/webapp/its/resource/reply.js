var resourceId;
$(document).ready(function(){
	$(".quiz_content")
	.on("click",".btn_reply",doResourceReply);
	resourceId=window.location.search;
	getReplyObject();
});
//资源评分+回复
function doResourceReply(){
	var content=$("#resource_reply").val();
	var score=$(".rater-star-result").text().substr(0,1);
	if(!score){
		alert("您还没有对该资源进行打分，请打分后重试！");
		return false;
	}
//	alert(score);
	var url="doResourceReply.do"+resourceId;
	var params={
			"content":content,
			"score":score
	}
	$.post(url,params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			alert("评论成功！积分+2");
			getReplyObject();
		}else if(result.state==0){
			alert(result.message);
		}
	})	
	return false;
}
//获取回复内容
function getReplyObject(){	
	$.post("getReplyObject.do"+resourceId,null,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			setReplyObject(result.data);
		}else if(result.state==0){
			
		}
	})
	return false;
}
//设置消息页面
function setReplyObject(reply){
	var ul=$(".reply_list");
	ul.html("");
	for(var i=0;i<reply.length;i++){
		var li=$("<li>"+reply[i].createdUser+":</li>")
		var a=$("<a>"+reply[i].content+"</a>")
		var span=$("<span class='date'>"+ new Date(reply[i].createdTime).Format("yyyy-MM-dd hh:mm:ss") +"&nbsp;&nbsp;&nbsp;评分："+ reply[i].score +".0</span>")
		li.append(a);
		li.append(span);
		ul.append(li);
	}
}