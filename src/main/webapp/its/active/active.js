$(document).ready(function(){
	getActivePage();
});
function getActivePage(){
	$.post("getActivePage.do?pageNo=1",null,function(result){
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
			setPageInfo(result.data.active);
		}else if(result.state==0){
			
		}
	})
}
//翻页调用  
function PageCallback(index, jq) {
	var url="getActivePage.do?pageNo="+index;
	$.post(url,null,function(result){		
		console.log(JSON.stringify(result));
		if(result.state==1){		
			setPageInfo(result.data.active);
		}else if(result.state==0){
			alert("请求超时，请重试！");			
		}	
	});
}
//设置页面内容
function setPageInfo(active){	
	var ul=$(".news_list");
	for(var i=0;i<active.length;i++){
		var li=$("<li></li>");
		if(active[i].valid==0){
			var a=$("<a href='activeDetail.do?id="+active[i].id+"'>[失效]-["+active[i].code+"]-"+active[i].name+"</a>");
		}else{
			var a=$("<a href='activeDetail.do?id="+active[i].id+"'>[有效]-["+active[i].code+"]-"+active[i].name+"</a>");
		}
		li.append(a);
		ul.append(li);
	}
}