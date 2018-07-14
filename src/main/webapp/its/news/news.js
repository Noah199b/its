$(document).ready(function(){
	getNewsObjects();
});
function getNewsObjects(){
	var url="getNewsObjects.do";
	var params={
			"newsType":$("#newsTypeId").val(),
			"pageNo":1
	}
	$.post(url,params,function(result){
//		console.log(JSON.stringify(result));
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
			setPageInfo(result.data.news);
		}else if(result.state==0){
			
		}
	})
}
//翻页调用  
function PageCallback(index, jq) {
	var url="getNewsObjects.do";
	var params={
			"newsType":$("#newsTypeId").val(),
			"pageNo":index
	}
	$.post(url,params,function(result){		
		console.log(JSON.stringify(result));
		if(result.state==1){		
			setPageInfo(result.data.news);
		}else if(result.state==0){
			alert("请求超时，请重试！");			
		}	
	});
}
function setPageInfo(news){
	var ul=$(".news_list");
	ul.html("");
	for(var i in news){
		var li=$("<li></li>");
		var url=news[i].type==1 ? news[i].link:"newsDetail.do?id="+news[i].id;
		var type=news[i].type==1 ?"外链":"站内";
		li.append('<a href="'+url+'">['+type+']-'+news[i].title+'</a>');
		li.append("<span class='date'>["+new Date(news[i].createdTime).Format("yyyy-MM-dd")+"]</span>");
		ul.append(li);
	}
}
function changeType(type){
	if(type==0){
		$("#eduNews").attr('class','');
		$("#timeNews").attr('class','on');		
	}else{
		$("#eduNews").attr('class','on');
		$("#timeNews").attr('class','');
	}
	$("#newsTypeId").val(type);	
	getNewsObjects();
}
