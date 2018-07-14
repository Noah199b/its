$(document).ready(function(){
	getOwnResourcePage();
});
//删除资源
function deleteResource(btn){
	var flag=confirm("确定删除该资源吗？");
	if(flag){
		var url="deleteResource.do";
		var params={
				"id":btn.value
		}
		$.post(url,params,function(result){
			console.log(JSON.stringify(result));
			if(result.state==1){
				alert("资源删除成功！");
				getOwnResourcePage();
			}else  if(result.state==0){
				alert("系统繁忙，请稍后重试！");
			}
		})
	}	
	return false;
}
function getOwnResourcePage(){
	$.post("getOwnResourcePage.do?pageNo=1",null,function(result){
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
			setPageInfo(result.data.resource);
		}else if(result.state==0){
			
		}
	})
}
//翻页调用  
function PageCallback(index, jq) {
	var url="getOwnResourcePage.do?pageNo="+index;
	$.post(url,null,function(result){		
		console.log(JSON.stringify(result));
		if(result.state==1){		
			setPageInfo(result.data.resource);
		}else if(result.state==0){
			alert("请求超时，请重试！");			
		}	
	});
}
//设置页面内容
function setPageInfo(resource){	
	var div=$(".tl_list");
	div.html("");
	var ul=$("<ul></ul>");
	for(var i=0;i<resource.length;i++){
		var li=$("<li></li>");
		//判断资源类型
		if(resource[i].type==0){
			li.append('<a class="reply">资料</a>');
		}else if(resource[i].type==1){
			li.append('<a class="reply">文献</a>');
		}else{
			li.append('<a class="reply">视频</a>');
		}		
		var div1=$('<div class="t_con"></div>');
		var h3=$('<h3></h3>');		
		var div2=$('<div class="operation"></div>');
		div2.append('<button type="submit" class="btn btn_delete" value="'+ resource[i].id +'" onclick="deleteResource(this);">删除</button>');
		h3.append(div2);
		h3.append('<a href="resDetail'+resource[i].type+'.do?id='+resource[i].id+'">'+resource[i].title+'</a>');		
		h3.append('<span class="addressor">发布者：'+resource[i].createdUser+'&nbsp;&nbsp;&nbsp;发布日期：'+new Date(resource[i].createdTime).Format("yyyy-MM-dd hh:mm:ss")+'&nbsp;&nbsp;&nbsp;</span>');
		div1.append(h3);
		div1.append('<p>'+resource[i].description+' ......</p>');
		li.append(div1);
		ul.append(li);
	}
	div.append(ul);
}