$(function () {
	
})

function addMessage(){
	var text = $('#messageText').val();
	if(text == "" ||text ==null ){
		alert("留言不能为空");
		return ;
	}
	if(text.length > 200){
		alert("标题不高于200字!!!");
		return ;
	}
	$.ajax({
        type:"post",
        dataType:"json",
        url:"/manager/message/insert",
        async:false,//异步  true 同步
        data:{message:text},
        success:function(result){  
        	window.location.href = "index";
        },error:function(){
        	alert("留言失败");
        	window.location.href = "index";
        }
    })
}
