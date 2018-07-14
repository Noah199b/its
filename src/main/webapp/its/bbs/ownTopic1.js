var search;
$(document).ready(function(){
	search=window.location.search;
	getOwnTopicPage();
});

function getOwnTopicPage(){
	$.post("getOwnTopic1Page.do"+search+"&pageNo=1",null,function(result){
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
			setUserInfo(result.data.user,result.data.auth);
			setPageInfo(result.data.content,result.data.replyCount);
		}else if(result.state==0){
			
		}
	})
}
//翻页调用  
function PageCallback(index, jq) {
	var url="getOwnTopic1Page.do"+search+"&pageNo="+index;
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

	var ul=$(".ul_list");
	ul.html("");
	for(var i=0;i<content.length;i++){
		var li=$("<li></li>");
		li.append('<a href="tDetail.do?id='+content[i].id+'#reply" class="reply">'+count[i]+'回复</a>');
		var div1=$('<div class="t_con"></div>');
		div1.append('<h3><a href="tDetail.do?id='+content[i].id+'">'+content[i].title+'</a><span class="addressor">发布者：'+content[i].createdUser+'&nbsp;&nbsp;&nbsp;发布日期：'+new Date(content[i].createdTime).Format("yyyy-MM-dd hh:mm:ss")+'&nbsp;&nbsp;&nbsp;</span></h3>');
		div1.append('<p>'+content[i].contentText+'......</p>');
		li.append(div1);
		ul.append(li);
	}
}
function setUserInfo(user,auth){
	var div=$(".personal_info");
	var div1=$("<div class='p_img' style='border:0'></div>");
	div1.append("<img src='"+user.avatar+"'style='height:82px;width:82px;'/>");
	div.append(div1);
	if(user.valid==2){
		div.append("<p><b><a style='background: url(images/renzheng.png)right no-repeat;padding-right: 55px;'>"+user.username+"</a></b></p><br>");
		div.append("<p style='text-align: left;'><span style='color: red;'>*</span><b>姓名：</b>"+auth.name+"</p><br>");
		div.append("<p style='text-align: left;'><span style='color: red;'>*</span><b>学历：</b>"+auth.edu+"</p><br>");
		div.append("<p style='text-align: left;'><span style='color: red;'>*</span><b>专业：</b>"+auth.speciality+"</p><br>");
		div.append("<p style='text-align: left;'><span style='color: red;'>*</span><b>毕业院校：</b>"+auth.school+"</p><br>");
		div.append("<p style='text-align: left;'><span style='color: red;'>*</span><b>微信：</b>"+auth.wechat+"</p><br>");
		div.append("<p style='text-align: left;'><span style='color: red;'>*</span><b>QQ：</b>"+auth.qq+"</p>");
		div.append("<p style='text-align: left;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+auth.qq+"&site=qq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+auth.qq+":51' alt='点击这里在线问答' title='点击这里在线问答'/></a></p><br>");
	}else{
		div.append("<p><b>"+user.username+"</b></p><br>");
		div.append("<p style='text-align: left;'><span style='color: red;'>*</span><b>昵称：</b>"+user.name+"</p><br>");		
	}
	div.append("<p style='text-align: left;'><span style='color: red;'>*</span><b>邮箱：</b>"+user.email+"</p><br>");
	div.append("<p style='text-align: left;'><span style='color: red;'>*</span><b>留言：</b>"+user.autograph+"</p><br>");
}