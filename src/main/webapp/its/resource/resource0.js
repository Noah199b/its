var search;
$(document).ready(function(){
	$(".n_link")
	.on("click",".btn_download",download);
	search=window.location.search;
	getResourceRARPage();
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
function getResourceRARPage(){	
	$.post("getResourceObject.do"+search,null,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			setResourceRARInfo(result.data.resource,result.data.valid);
		}else if(result.state==0){
			
		}
	})
}
//设置消息页面
function setResourceRARInfo(resource,valid){
	//1.设置每一行数据的作者+时间
	$(".userAndDate").html(resource.createdUser+'&nbsp;&nbsp;&nbsp;'+new Date(resource.createdTime).Format("yyyy-MM-dd"));
	//2.设置资源标题及创建时间
	if(valid==2){
		$(".n_title").html(resource.title+'<span class="n_date">上传作者：'+resource.createdUser+'<a style="background: url(images/renzheng.png)right no-repeat;padding-right: 55px;"></a>&nbsp;&nbsp;&nbsp;上传日期：'+new Date(resource.createdTime).Format("yyyy-MM-dd hh:mm:ss")+'</span>');
	}else{
		$(".n_title").html(resource.title+'<span class="n_date">上传作者：'+resource.createdUser+'&nbsp;&nbsp;&nbsp;上传日期：'+new Date(resource.createdTime).Format("yyyy-MM-dd hh:mm:ss")+'</span>');
	}
	//3.设置资源评分
	$("#score").text(resource.score);
	//4.设置资源大小
	$("#size").text((resource.size/1024).toFixed(3)+" KB");
	//5.设置下载次数
	$("#downloadCount").text(resource.downloadCount);
	//6.设置下载所需积分
	$("#downloadIntegral").text(resource.downloadIntegral);
	//7.设置资源简述
	$("#description").text(resource.description);
	//8.设置资源id
	$(".btn_download").val(resource.id);
}