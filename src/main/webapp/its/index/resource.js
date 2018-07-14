$(document).ready(function(){
	getResourceObjects();
});
function getResourceObjects(){
	$.post("getResourceObjects.do",null,function(result){
		if(result.state==1){
			setRarObjects(result.data.rar);
			setPdfObjects(result.data.pdf);
			setVideoObjects(result.data.video);
		}
	})
}
function setRarObjects(rar){
	var ul=$("#rarId");
	ul.html("");
	for(var i=0;i<rar.length;i++){
		var li=$("<li></li>");
		li.append("<a href='resDetail0.do?id="+rar[i].id+"'>"+rar[i].title+"</a>");
		ul.append(li);
	}
}
function setPdfObjects(pdf){
	var ul=$("#pdfId");
	ul.html("");
	for(var i=0;i<pdf.length;i++){
		var li=$("<li></li>");
		li.append("<a href='resDetail1.do?id="+pdf[i].id+"'>"+pdf[i].title+"</a>");
		ul.append(li);
	}
}
function setVideoObjects(video){
	var ul=$("#videoId");
	ul.html("");
	for(var i=0;i<video.length;i++){
		var li=$("<li></li>");
		var a=$("<a href='resDetail2.do?id="+video[i].id+"'></a>");
		a.append("<img class='video-img'  src='/uploads/images/video-bg-index.jpg'/>");
		a.append("<div class='video-text'>"+video[i].title+"</div>");
		li.append(a);
		ul.append(li);
	}
}