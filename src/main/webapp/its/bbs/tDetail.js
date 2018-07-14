var search;
$(document).ready(function(){
	$(".editor")
	.on("click",".submit_btn",pubParentReply);
	$(".reply_wrap")
	.on("click",".sub_submit_btn",pubSubReply);
	search=window.location.search;
	getPageObject();
});

function pubParentReply(){
	var url="pubParentReply.do"+search;
	var params={
			"content":$(".froala-element").html(),			
	}
	$.post(url,params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			alert("回复成功！积分+2");
			window.location.reload();
		}else if(result.state==0){
			alert(result.message);
		}
	})
	return false;
}

function pubSubReply(){
	var parentId=$(this).val();	
	var url="pubSubReply.do"+search;
	var params={
			"content":$(".subreply_"+parentId).val(),
			"parentId":parentId		
	}
	$.post(url,params,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			alert("回复成功！积分+1");
			window.location.reload();
		}else if(result.state==0){
			alert(result.message);
		}
	})
	return false;
}

function getPageObject(){	
	var url ="getTDetail.do"+search;
	$.post(url,null,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			setPageContent(result.data.content,result.data.valid);
			setpageComment(result.data.replyCount,result.data.reply,result.data.subCount,result.data.subreply,result.data.parentValid,result.data.subValids);
		}else if(result.state==0){
			
		}		
	});	
}
//设置话题内容
function setPageContent(content,valid){
	if(valid==2){
		var html="<h3>"+content.title +
		"<span class='addressor'>发布者："+content.createdUser+"<a style='background: url(images/renzheng.png)right no-repeat;padding-right: 55px;'></a>&nbsp;&nbsp;&nbsp;" +
		"发布日期："+new Date(content.createdTime).Format("yyyy-MM-dd hh:mm:ss")+"&nbsp;&nbsp;&nbsp;访问："+content.totalVisits+"&nbsp;&nbsp;&nbsp;</span>" +
		"</h3>" +
		"<div>"+content.content+"</div>";
		$(".reply_wrap").before(html);
	}else{
		var html="<h3>"+content.title +
		"<span class='addressor'>发布者："+content.createdUser+"&nbsp;&nbsp;&nbsp;" +
		"发布日期："+new Date(content.createdTime).Format("yyyy-MM-dd hh:mm:ss")+"&nbsp;&nbsp;&nbsp;访问："+content.totalVisits+"&nbsp;&nbsp;&nbsp;</span>" +
		"</h3>" +
		"<div>"+content.content+"</div>";
		$(".reply_wrap").before(html);
	}
}
//设置回复内容
function setpageComment(count,reply,subcount,subreply,parentValid,subValids){
	
	var div1=$(".reply_wrap");
	var div2=$("<div class='r_title'>共"+count+"个回复</div>");
	var ul=$("<ul class='talk_list'></ul>");
	if(count!=0){
		for(var i=0;i<reply.length;i++){
			var li=$("<li class='backview'></li>");
			var div8=$("<div class='det_l'></div>");
			var a1=$("<a href='ownTopic1UI.do?id="+reply[i].userId+"' class='avatar'></a>");
			a1.append ("<img src='"+reply[i].spare1+"'/>");
			div8.append(a1);
			var div3=$("<div class='li_cont'></div>");
			var div9=$("<div class='info'></div>");
			if(parentValid[i]==2){
				div9.append("<span class='i_name'><a href='ownTopic1UI.do?id="+reply[i].userId+"' style='background: url(images/renzheng.png)right no-repeat;padding-right: 55px;'>"+reply[i].createdUser+"</a><span class='date'>"+new Date(reply[i].createdTime).Format("yyyy-MM-dd hh:mm:ss")+"</span></span><br>");
			}else{
				div9.append("<span class='i_name'><a href='ownTopic1UI.do?id="+reply[i].userId+"'>"+reply[i].createdUser+"</a><span class='date'>"+new Date(reply[i].createdTime).Format("yyyy-MM-dd hh:mm:ss")+"</span></span><br>");
			}
			div3.append(div9);			
			div3.append("<div class='li_t editor_style'>");
			div3.append(reply[i].content);
			div3.append("</div>");
			var div10=$("<div class='info replyinfo'></div>");
			var span1=$("<span class='replynum'></span>");
			span1.append("<a href='javascript:void(0);'>全部回复("+subcount[i]+")</a>");
			div10.append(span1);
			div3.append(div10);
			var div4=$("<div class='del_reply_wp'></div>");
			var ul2=$("<ul class='del_repy'></ul>");
			if(subreply[i].length!=0){
				for(var j=0;j<subreply[i].length;j++){
					var li2=$("<li class='cl'></li>");
					var a2=$("<a href='ownTopic1UI.do?id="+subreply[i][j].userId+"' class='avatar'></a>");
					a2.append("<img src='"+subreply[i][j].spare1+"'/>");
					li2.append(a2);
					
					var div6=$("<div class='cl_cont'></div>");
					
					var div11=$("<div class='info'></div>");
					var span2=$("<span class='i_name'></span>");
					if(subValids[i][j]==2){
						span2.append("<a href='ownTopic1UI.do?id="+subreply[i][j].userId+"' style='background: url(images/renzheng.png)right no-repeat;padding-right: 55px;'>"+subreply[i][j].createdUser+"</a><span class='date'>"+new Date(subreply[i][j].createdTime).Format("yyyy-MM-dd hh:mm:ss")+"</span>");
					}else{
						span2.append("<a href='ownTopic1UI.do?id="+subreply[i][j].userId+"'>"+subreply[i][j].createdUser+"</a><span class='date'>"+new Date(subreply[i][j].createdTime).Format("yyyy-MM-dd hh:mm:ss")+"</span>");
					}
					div11.append(span2);
					div6.append(div11);
					
					var div12=$("<div class='li_t editor_style'></div>");
					div12.append("<p>"+subreply[i][j].content+"</p>");
					div6.append(div12);
					
					li2.append(div6);
					ul2.append(li2);
				}			
			}					
			var div5=$("<div class='del_reply_input_cl'></div>");
			var form=$("<form action='' method='post'></form>");
			form.append("<textarea placeholder='回复"+reply[i].createdUser+"' name='content' class='subreply_"+reply[i].id+"'></textarea>");		
			var div7=$("<div class='del_reply_btn'></div>");
			div7.append("<a href='javascript:void(0);' class='cancel'>取消</a>");
			div7.append("<button type='submit' value='"+reply[i].id+"' class='btn sub_submit_btn'>回复</button>");
			form.append(div7);
			form.append("<div class='clear'></div>");
			div5.append(form);
			div4.append(ul2);
			div4.append(div5);
			div3.append(div4);
			li.append(div8);
			li.append(div3);
			ul.append(li);
		}		
	}else{		
		ul.append("<p>暂无回复内容！</p>");
	}	
	div1.append(div2);
	div1.append(ul);
}


