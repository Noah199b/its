var key=null;
$(document).ready(function(){
	$(".search")
	.on("click",".btn_search",getPageType);
	getPageType(3);
});
//获取消息页面
function getResourcePage(){
	var params={
			"type":$(".tl_tab").val(),
			"pageNo":1,
			"search":key
	}
	$.post("getResourcePage.do",params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			var page=result.data.page;
			$("#Pagination").pagination({
				   currentPage:page.pageCurrent,// 当前页数
				   totalPage:result.data.count,// 总页数
				   isShow: true,// 是否显示首尾页
				   count:page.pageSize,// 显示个数
				   homePageText: "首页",// 首页文本
				   endPageText: "尾页",// 尾页文本
				   prevPageText: "上一页",// 上一页文本
				   nextPageText: "下一页",// 下一页文本
				   callback: function(current) {
					   PageCallback(current);
				   }
				});	
			setResourceInfo(result.data.resource,result.data.valid);
		}else if(result.state==0){
			
		}
	})
}
//分页回调函数
function PageCallback(current){
	var params={
			"type":$(".tl_tab").val(),
			"pageNo":current,
			"search":key
	}
	$.post("getResourcePage.do",params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			setResourceInfo(result.data.resource,result.data.valid);
		}else if(result.state==0){
			
		}
	})
	
}

//0-未读 1-已读  2-全部
function getPageType(type){
	if(type==0){
		$("#rar_rsc").attr('class','active');
		$("#pdf_rsc").attr('class','');
		$("#vedio_rsc").attr('class','');
		$("#all_rsc").attr('class','');
		$(".tl_tab").val("0");
	}else if(type==1){
		$("#rar_rsc").attr('class','');
		$("#pdf_rsc").attr('class','active');
		$("#vedio_rsc").attr('class','');
		$("#all_rsc").attr('class','');
		$(".tl_tab").val("1");
	}else if(type==2){
		$("#rar_rsc").attr('class','');
		$("#pdf_rsc").attr('class','');
		$("#vedio_rsc").attr('class','active');
		$("#all_rsc").attr('class','');
		$(".tl_tab").val("2");
	}else if(type==2){
		$("#rar_rsc").attr('class','');
		$("#pdf_rsc").attr('class','');
		$("#vedio_rsc").attr('class','');
		$("#all_rsc").attr('class','active');
		$(".tl_tab").val("3");
	}else{
		$("#rar_rsc").attr('class','');
		$("#pdf_rsc").attr('class','');
		$("#vedio_rsc").attr('class','');
		$("#all_rsc").attr('class','active');
		$(".tl_tab").val("4");
		key=$("#topic").val();
	}
	getResourcePage();
}
//设置消息页面
function setResourceInfo(resource,valid){
	var div=$(".tl_list");
	div.html("");
	var ul=$("<ul></ul>");
	for(var i=0;i<resource.length;i++){
		var li=$("<li></li>");
		if(resource[i].type==0){
			li.append('<a class="reply">资料</a>');
		}else if(resource[i].type==1){
			li.append('<a class="reply">文献</a>');
		}else{
			li.append('<a class="reply">视频</a>');
		}	
		var div1=$('<div class="t_con"></div>');
		if(valid[i]==2){
			div1.append('<h3><a href="resDetail'+resource[i].type+'.do?id='+resource[i].id+'">'+resource[i].title+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评分：'+resource[i].score+'</a><span class="addressor">发布者：'+resource[i].createdUser+'<a style="background: url(images/renzheng.png)right no-repeat;padding-right: 55px;"></a>&nbsp;&nbsp;&nbsp;发布日期：'+new Date(resource[i].createdTime).Format("yyyy-MM-dd hh:mm:ss")+'&nbsp;&nbsp;&nbsp;'
					+'下载所需积分：'+resource[i].downloadIntegral+'积分</span></h3>');
		}else{
			div1.append('<h3><a href="resDetail'+resource[i].type+'.do?id='+resource[i].id+'">'+resource[i].title+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评分：'+resource[i].score+'</a><span class="addressor">发布者：'+resource[i].createdUser+'&nbsp;&nbsp;&nbsp;发布日期：'+new Date(resource[i].createdTime).Format("yyyy-MM-dd hh:mm:ss")+'&nbsp;&nbsp;&nbsp;'
					+'下载所需积分：'+resource[i].downloadIntegral+'积分</span></h3>');
		}
		li.append(div1);
		ul.append(li);
	}
	div.append(ul);
}