var search;
$(document).ready(function(){
	$(".n_link")
	.on("click",".btn_download",download);
	search=window.location.search;
	getResourceMP4Page();
});
//下载当前资源
function download(){
	$.post("checkDownload.do"+search,null,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			var flag;
			if(result.data==0){
				flag=confirm("下载该资源会扣除相应的积分，确定继续吗？");
			}else{
				flag=true;
			}	
			if(flag){
				var url="download.do"+search;
				document.location.href=url;
			}			
		}else if(result.state==0){
			alert(result.message);
		}
	});
}
//获取消息页面
function getResourceMP4Page(){	
	$.post("getResourceObject.do"+search,null,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			setResourceMP4Info(result.data.resource,result.data.valid);
		}else if(result.state==0){
			
		}
	})
}
//设置消息页面
function setResourceMP4Info(resource,valid){
	//1.设置标题
	//2.设置副标题
	$(".n_title").html(resource.title
			+'<span class="n_date">上传日期：'+new Date(resource.createdTime).Format("yyyy-MM-dd hh:mm:ss")
			+'&nbsp;&nbsp;&nbsp;资源评分：'+resource.score
			+'&nbsp;&nbsp;&nbsp;资源类型：2-视频资料'
			+'</span>');	
	//3.设置下载信息
	$("#size").text((resource.size/1024).toFixed(3)+" KB");
	$("#downloadCount").text(resource.downloadCount);
	$("#downloadIntegral").text(resource.downloadIntegral);
	if(valid==2){
		$("#createdUser").html(resource.createdUser+"<a style='background: url(images/renzheng.png)right no-repeat;padding-right: 55px;'></a>");
	}else{
		$("#createdUser").html(resource.createdUser);
	}
	//4.设置资源ID
	$(".btn_download").val(resource.id);
	//5.设置资源简述
	$("#description").text(resource.description);
}