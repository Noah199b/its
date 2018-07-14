$(document).ready(function(){
	getTopicObjects();
});
function getTopicObjects(){
	$.post("getTopicObjects.do",null,function(result){
		if(result.state==1){
			setTopicObjects(result.data.topic,result.data.avatar);
		}else{
			alert("系统繁忙！");
		}
	})
}
function setTopicObjects(topic,avatar){
	var ul=$("#topicId");
	ul.html("");
	for(var i=0;i<topic.length;i++){
		var li=$("<li></li>");
		var div1=$("<div class='h_img'></div>");
		div1.append("<img src="+ avatar[i] +" style='height:80px;width:80px;'/>");
		var div2=$("<div class='h_text'></div>");
		var b=$("<b></b>");
		b.append("<a href='tDetail.do?id="+topic[i].id+"' style='font-size:10px;'>"+topic[i].title.substr(0,14)+"...</a>");
		var p=$("<p>"+topic[i].contentText.substr(0,27) +"...</p>");
		p.append("<a href='tDetail.do?id="+topic[i].id+"' class='detail'>详细</a>");
		div2.append(b);
		div2.append(p);
		li.append(div1);
		li.append(div2);
		ul.append(li);
	}
}