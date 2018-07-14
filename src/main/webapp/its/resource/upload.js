$(document).ready(function(){
   $("#uploadFormId")
   .on("click",".btn-upload",doUpload);
   $(".button").attr("disabled", true);
   $(".box").hide();
});
/*点击文件上传按钮执行此函数*/
function doUpload(){
	var path=$(".file").val();
	if(path==""){
		alert("上传资源不能为空！");
		return false;
	}
	var pos = path.lastIndexOf("."); 
    var lastname = path.substring(pos,path.length);
    if ((lastname.toLowerCase() != ".rar" )
    		&&(lastname.toLowerCase() != ".pdf")
    		&&(lastname.toLowerCase() != ".mp4")
    		&&(lastname.toLowerCase() != ".zip")){
    	alert("资源文件个格式必须为[*.rar|*.zip|*.pdf|*.mp4]，请重新选择！");
		return false;
    }
	//异步提交表单($.ajaxSubmit为异步提交表单)
	//使用此函数时需要在页面引入(jquery.form.js )
	$("#uploadFormId").ajaxSubmit({
		type:"post",
		url:"doUpload.do",
		dataType:"json",
		success:function(result){			
			if(result.state==1){
				$(".box").hide();
				alert("资源上传完成，将跳转到资源详情页面！积分+10");
				window.location.href='resDetail'+result.data.type+'.do?id='+result.data.id;
			}else{
				alert(result.message);
			}			
		}
	});
	$(".box").show();
	window.setInterval(getProccess,100); 
	//$("#uploadFormId").resetForm();
	return false;//防止表单重复提交的一种方式
}
/**
 * 获取进度条百分比
 * @returns
 */
function getProccess(){
	$.get("getProccess.do",null,function(result){
		if(result.state==1){
			console.log(JSON.stringify(result));
			add(result.data);
		}		
	})
	return false;
}
/*add——创建tbx下的div加文字和变宽度的方法*/
function add(i){
	    var tbox =$(".tbox");
        var tiao =$(".tiao");		
		tiao.css("width",i).html(i);	
}
/**
 * 检查资源标题
 * @param e
 * @returns
 */
function checkTitle(e){
	if(e.value.length < 5){
		e.value="";  
		e.focus();  
		return false;
	}
}
/**
 * 检查资源简述
 * @param e
 * @returns
 */
function checkDesc(e){
	if(e.value.length < 10){
		e.value="";  
		e.focus();  
		return false;
	}
}
/**
 * 检查积分是否为空
 * @param e
 * @returns
 */
function checkIntegral(e){
	if(e.value.length <= 0){
		e.value="0";		
	}
	$(".button").attr("disabled", false);
	return false;
}