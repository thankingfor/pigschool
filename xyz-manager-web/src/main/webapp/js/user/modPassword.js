$(function () {
	
})

/**
 * 提交表单
 * @returns
 */
function modPsw() {
	var pwd = $("#password").val();
	if(pwd == ""){
		toastr.warning("密码不能为空"); 
		return ;
	}
	$.ajax({
        type:"post",
        dataType:"json",
        url:"/user/molPwd",
        async:false,//异步  true 同步
        data:{password:pwd},
        success:function(result){  
        	alert("修改成功");
        },error:function(XMLHttpRequest,textStatus,errorThrown){
        	alert("修改失败");
        }
    })
}
