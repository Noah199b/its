var search;
$(document).ready(function(){
   $("#form_publish_id")
   .on("click","#btn_submit",doEdit)
   search=window.location.search;
   getEditPage();
});
function doCancel(){
	var flag=confirm("确定取消话题编辑吗？");
	if(flag){
		window.location.href='ownTopicUI.do';
	}
}
function getEditPage(){
	var url='getEditPage.do'+search;
	$.post(url,null,function(result){
		console.log(JSON.stringify(result));
		if(result.state==1){
			setEditPage(result.data);
		}else if(result.state==0){			
			alert(result.message);
			window.location.href='ownTopicUI.do';
		}
	})
}
function setEditPage(data){
	$("#title").val(data.title);
	$(".froala-element").html(data.content);
}
function doEdit(){	
	var flag=confirm("确定保存更改吗？")
	if(flag){
		var content=$(".froala-element").html();
		var contentText=$(".froala-element").text();	
		if(contentText.length>=100){
			contentText=contentText.substr(0,100);
		}
		var params={//根据id获得数据
				  "title":$("#title").val(),
				  "content":content,
				  "contentText":contentText,
				  "userId":$("#btn_submit").val()
			  }
		var url="doEdit.do"+search;	
		$.post(url,params,function(result){
			console.log(JSON.stringify(result));
			if(result.state==1){
				alert("话题保存成功，将跳转到话题！");
				$(window).attr('location','tDetail.do'+search);//跳转话题到话题
			}else if(result.state==0){
				alert(result.message);
			}
		});	
	}	
	return false;
}
