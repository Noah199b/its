$(document).ready(function(){
	getNewsObjects();
});
function getNewsObjects(){
	$.post("getIndexNewsObjects.do",null,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			setNewsObjects(result.data.eduNews);
			setNewsObjects(result.data.timeNews);
		}
	})
}
function setNewsObjects(news){
	var ul=news[0].newsType==1?$("#eduNewsId"):$("#timeNewsId");
	for(var i in news){		
		if(i==0){
			var div=news[i].newsType==1?$("#eduNews"):$("#timeNews");
			div.html("");
			var url=news[i].type==1 ? news[i].link:"newsDetail.do?id="+news[i].id;
			div.append("<b>"+news[i].title.substr(0,22)+"...</b>");
			var p=$("<p>"+news[i].subTitle.substr(0,35)+"...</p>");
			p.append("<a href="+url+" class='detail'>详细</a>");
			div.append(p);
		}else{
			var li=$("<li></li>")
			var url=news[i].type==1 ? news[i].link:"newsDetail.do?id="+news[i].id;
			li.append("<a href='"+url+"'>"+news[i].title+"</a>");
		}
		ul.append(li);
	}
}