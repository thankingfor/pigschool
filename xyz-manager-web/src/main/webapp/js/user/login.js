$(function () {
	
})

/**
 * 提交表单
 * @returns
 */
function login() {
	if($("#username").val() == ""){
		toastr.warning("用户名不能为空"); 
		return ;
	}
	if($("#password").val() == ""){
		toastr.warning("密码不能为空"); 
		return ;
	}
	$.ajax({
        type:"post",
        dataType:"json",
        url:"/login/up",
        async:false,//异步  true 同步
        data:$('#loginForm').serialize(),
        success:function(result){  
        	if(result.status == 200){
        		window.location.href = "index";
        	}else {
        		alert(result.msg);
        		window.location.href = "login";
        		//$('#msg').empty();
        		//$('#msg').append(result.msg);
        	}
        },error:function(XMLHttpRequest,textStatus,errorThrown){
        	/*alert(XMLHttpRequest.status);
        	alert(XMLHttpRequest.readyState);
        	alert(textStatus);*/
        	toastr.success("返回失败"); 
        }
    })
}
