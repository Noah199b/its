$(document).ready(function(){
	getOwnTopicPage();

});
//删除话题
function doDelete(btn){
	var flag=confirm("确定删除该话题吗？");
	if(flag){
		var url="doDelete.do";
		var params={
				"id":btn.value
		}
		$.post(url,params,function(result){
			console.log(JSON.stringify(result));
			if(result.state==1){
				alert("话题删除成功！");
				getOwnTopicPage();
			}else  if(result.state==0){
				alert("系统繁忙，请稍后重试！");
			}
		})
	}	
	return false;
}
//跳转到编辑页面
function toEdit(btn){
//	alert(btn.value);
	var url='toEdit.do?id='+btn.value;
	window.location.href=url;
}
function getOwnTopicPage(){
	$.post("getOwnTopicPage.do?pageNo=1",null,function(result){
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
			setPageInfo(result.data.content,result.data.replyCount);
		}else if(result.state==0){
			
		}
	})
}
//翻页调用  
function PageCallback(index, jq) {
	var url="getOwnTopicPage.do?pageNo="+index;
	$.post(url,null,function(result){		
		console.log(JSON.stringify(result));
		if(result.state==1){		
			setPageInfo(result.data.content,result.data.replyCount);
		}else if(result.state==0){
			alert("请求超时，请重试！");			
		}	
	});
}
//设置页面内容
function setPageInfo(content,count){	
	var div=$(".tl_list");
	div.html("");
	var ul=$("<ul></ul>");
	for(var i=0;i<content.length;i++){
		var li=$("<li></li>");
		li.append('<a href="tDetail.do?id='+content[i].id+'#reply" class="reply">'+count[i]+'回复</a>');
		var div1=$('<div class="t_con"></div>');
		var h3=$('<h3></h3>');		
		var div2=$('<div class="operation"></div>');
		div2.append('<button type="submit" class="btn btn_edit" value="'+ content[i].id +'" onclick="toEdit(this);">编辑</button>');
		div2.append('<button type="submit" class="btn btn_delete" value="'+ content[i].id +'" onclick="doDelete(this);">删除</button>');
		h3.append(div2);
		h3.append('<a href="tDetail.do?id='+content[i].id+'">'+content[i].title+'</a>');		
		h3.append('<span class="addressor">发布者：'+content[i].createdUser+'&nbsp;&nbsp;&nbsp;发布日期：'+new Date(content[i].createdTime).Format("yyyy-MM-dd hh:mm:ss")+'&nbsp;&nbsp;&nbsp;</span>');
		div1.append(h3);
		div1.append('<p>'+content[i].contentText+'......</p>');
		li.append(div1);
		ul.append(li);
	}
	div.append(ul);
}