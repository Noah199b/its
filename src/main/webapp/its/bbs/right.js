$(document).ready(function(){	
	getActiveUser();
})
function getActiveUser(){
	$.post("getActiveUser.do",null,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			setActiveUser(result.data.active);
		}
	})
}
function setActiveUser(active){
	var ul=$("<ul></ul>")
	for(var i=0;i<active.length;i++){
		var li=$("<li></li>")
		var div1=$("<div class='h_img'></div>");
		var a=$("<a href='ownTopic1UI.do?id="+active[i].id+"'></a>");
		a.append("<img src='"+active[i].avatar+"'/>");
		div1.append(a);
		var div2=$("<div class='h_text'></div>");
		var b=$("<b></b>")
		if(active[i].valid==2){
			b.append("<a href='ownTopic1UI.do?id="+active[i].id+"'style='background: url(images/renzheng.png)right no-repeat;padding-right: 55px;'>"+active[i].username+"</a>");
		}else{
			b.append("<a href='ownTopic1UI.do?id="+active[i].id+"'>"+active[i].username+"</a>");
		}		
		div2.append(b);
		div2.append("<p>发表了"+active[i].aTotal+"个主题</p>");
		div2.append("<p>发表了"+active[i].cTotal+"个评论</p>");
		li.append(div1);
		li.append(div2);
		ul.append(li);
	}
	$(".lively_user").append(ul);
}