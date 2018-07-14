$(document).ready(function(){
	getActiveObjects();
});
function getActiveObjects(){
	$.post("getActiveObjects.do",null,function(result){
		if(result.state==1){
			setActiveObjects(result.data);
		}
	})
}
function setActiveObjects(active){
	var ul=$("#activeId");
	ul.html("");
	for(var i=0;i<active.length;i++){
		var li=$("<li></li>");
		var a=$("<a href='activeDetail.do?id="+ active[i].id  +"'>"+ active[i].name  +"</a>");
		var span=$("<span class='plan'>"+ new Date(active[i].beginDate).Format("yyyy-MM-dd") 
				+"&nbsp;-&nbsp;"+ new Date(active[i].endDate).Format("yyyy-MM-dd") +"</span>");
		li.append(a);
		li.append(span);
		ul.append(li);
	}
}