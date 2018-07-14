$(document).ready(function(){
	getPageType(2);
});
//获取消息页面
function getMessagePage(){
	var params={
			"type":$(".tl_tab").val(),
			"pageNo":1
	}
	$.post("getMessagePage.do",params,function(result){
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
			setMessageInfo(result.data.message);
		}else if(result.state==0){
			
		}
	})
}
//分页回调函数
function PageCallback(current){
	var params={
			"type":$(".tl_tab").val(),
			"pageNo":current
	}
	$.post("getMessagePage.do",params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			setMessageInfo(result.data.message);
		}else if(result.state==0){
			
		}
	})
	
}
//0-未读 1-已读  2-全部
function getPageType(type){
	if(type==0){
		$("#no_msg").attr('class','active');
		$("#yes_msg").attr('class','');
		$("#all_msg").attr('class','');
		$(".tl_tab").val("0");
	}else if(type==1){
		$("#yes_msg").attr('class','active');
		$("#no_msg").attr('class','');
		$("#all_msg").attr('class','');
		$(".tl_tab").val("1");
	}else{
		$("#all_msg").attr('class','active');
		$("#no_msg").attr('class','');
		$("#yes_msg").attr('class','');
		$(".tl_tab").val("2");
	}
	
	getMessagePage();
}
//设置消息页面
function setMessageInfo(message){
	var div=$(".tl_list");
	div.html("");
	var ul=$("<ul></ul>");
	for(var i=0;i<message.length;i++){
		var li=$("<li></li>");
		if(message[i].flag==0){
			li.append('<a class="reply">未读</a>');
		}else{
			li.append('<a class="reply">已读</a>');
		}		
		var div1=$('<div class="t_con"></div>');
		div1.append('<h3><a href="message1UI.do?id='+message[i].id+'">'+message[i].title+'</a><span class="addressor">发布者：'+message[i].createdUser+'&nbsp;&nbsp;&nbsp;发布日期：'+new Date(message[i].createdTime).Format("yyyy-MM-dd hh:mm:ss")+'&nbsp;&nbsp;&nbsp;</span></h3>');
		li.append(div1);
		ul.append(li);
	}
	div.append(ul);
}