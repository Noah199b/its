$(document).ready(function(){
	$("#searchId")
	.on("click","#btn_search",getObjects);
	getObjects();
});

function getObjects(){
	var url="getTeacherObjects.do";
	var params={
			"search":$("#search_key").val(),
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
			setPageInfo(result.data.user,result.data.auth);
		}else if(result.state==0){
			alert("请求超时，请重试！");
		}
	})
	return false;
}
//翻页调用  
function PageCallback(index, jq) {
	var url="getTeacherObjects.do";
	var params={
			"search":$("#search_key").val(),
			"pageNo":index
	}
	$.post(url,params,function(result){		
		console.log(JSON.stringify(result));
		if(result.state==1){		
			setPageInfo(result.data.user,result.data.auth);
		}else if(result.state==0){
			alert("请求超时，请重试！");			
		}	
	});
	return false;
}
function setPageInfo(user,auth){
	if(user.length==0){
		alert("查询无结果！");
		window.location.reload();
	}
	var div=$(".row");
	div.html("");
	for(var i=0;i<user.length;i++){
		var div1=$('<div class="col-sm-6 col-md-4"></div>');
		var div2=$('<div class="thumbnail"></div>');
		div2.append('<a class="lightbox" href="ownTopic1UI.do?id='+user[i].id+'"><img src="'+user[i].avatar+'" alt="Park"></a>');
		div2.append('<div class="caption">'
				+'<h3>'+auth[i].name+'&nbsp&nbsp·&nbsp&nbsp'+auth[i].email+'</h3><br>'
				+'<p>'+auth[i].edu+'&nbsp;&nbsp&nbsp·&nbsp;'+auth[i].speciality+'&nbsp&nbsp;·&nbsp;&nbsp'+auth[i].school+'</p>'
				+'<p>个性签名：'+user[i].autograph+'</p><br>'
				+"<p><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+auth[i].qq+"&site=qq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+auth[i].qq+":51' alt='点击这里在线问答' title='点击这里在线问答'/></a></p>"
				+'</div>');
		div1.append(div2);
		div.append(div1);
	}
	return false;
}