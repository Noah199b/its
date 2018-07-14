$(document).ready(function(){
	$(".search")
	.on("click",".btn_search",changeType);	
	changeType(0);
});
function changeType(type){
	if(type==0){//本周热门
		$("#hot_week").attr('class','active');
		$("#newest").attr('class','');
		$(".tl_tab").val("0");
	}else if(type==1){//最新发表
		$("#hot_week").attr('class','');
		$("#newest").attr('class','active');
		$(".tl_tab").val("1");
	}else{
		$("#hot_week").attr('class','');
		$("#newest").attr('class','');
		$(".tl_tab").val("2");
	}
	getPageInfo();
}
function getPageInfo(){	
	var type=$(".tl_tab").val();
	var url="doGetPage.do?type="+type+"&pageNo=1";
	var params={
			"key":$("#topic").val()
	}
	$.post(url,params,function(result){		
		console.log(JSON.stringify(result));
		if(result.state==1){			
			var page=result.data.page;
			$("#Pagination").pagination({
				   currentPage:page.pageCurrent,// 当前页数
				   totalPage:result.data.pageCount,// 总页数
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
			setPageInfo(result.data.content,result.data.replyCount,result.data.valid);
		}else if(result.state==0){
			alert("请求超时，请重试！");			
		}		
	});	
}
//翻页调用  
function PageCallback(index, jq) { 
	var type=$(".tl_tab").val();
	var url="doGetPage.do?type="+type+"&pageNo="+index;
	var params={
			"key":$("#topic").val()
	}
	$.post(url,params,function(result){		
		console.log(JSON.stringify(result));
		if(result.state==1){			
			setPageInfo(result.data.content,result.data.replyCount,result.data.valid);
		}else if(result.state==0){
			alert("请求超时，请重试！");			
		}	
	});
}
	
function setPageInfo(content,count,valid){	
	var div=$(".tl_list");
	div.html("");
	var ul=$("<ul></ul>");
	for(var i=0;i<content.length;i++){
		var li=$("<li></li>");
		li.append('<a href="tDetail.do?id='+content[i].id+'#reply" class="reply">'+count[i]+'回复</a>');
		var div1=$('<div class="t_con"></div>');
		if(valid[i]==2){
			div1.append('<h3><a href="tDetail.do?id='+content[i].id+'">'+content[i].title+'</a><span class="addressor">发布者：'+content[i].createdUser+'<a style="background: url(images/renzheng.png)right no-repeat;padding-right: 55px;"></a>&nbsp;&nbsp;&nbsp;发布日期：'+new Date(content[i].createdTime).Format("yyyy-MM-dd hh:mm:ss")+'&nbsp;&nbsp;&nbsp;</span></h3>');
		}else{
			div1.append('<h3><a href="tDetail.do?id='+content[i].id+'">'+content[i].title+'</a><span class="addressor">发布者：'+content[i].createdUser+'&nbsp;&nbsp;&nbsp;发布日期：'+new Date(content[i].createdTime).Format("yyyy-MM-dd hh:mm:ss")+'&nbsp;&nbsp;&nbsp;</span></h3>');
		}
		div1.append('<p>'+content[i].contentText+'......</p>');
		li.append(div1);
		ul.append(li);
	}
	div.append(ul);
}