$(function () {
})

function haiweishixian(){
	$('#haiweiwanchengModal').modal('show');
}

/**
 * 初始化富文本编辑器
 * @returns
 */
function initWangEditor(){
	editor.customConfig.customUploadImg = function (files, insert) {
	    // files 是 input 中选中的文件列表
		//创建为表单去提交
		var form = new FormData();
		for (var i = 0; i < files.length; i++) {
			form.append("uploadFile",files[i]);	
		}
		var imgUrls = ajaxUpload(form);
	    // 上传代码返回结果之后，将图片插入到编辑器中
		for (var i = 0; i < imgUrls.length; i++) {
			insert(imgUrls[i]);
		}
	}
    editor.create();
}
/**
*ajax上传
*/
function ajaxUpload(form){
	var imgUrls;
	$.ajax({
        type:"post",
        dataType:"json",
        url:"/upload",
        async:false,//异步  true 同步
        cache: false,//缓存 false的话会在url后面加一个时间缀，让它跑到服务器获取结果。
        contentType: false,//上传的时候必须要
        processData: false,
        data:form,
        success:function(result){  
        	imgUrls = result.urls;
        },error:function(){
        	
        }
    })
    return imgUrls;
}

/**
*初始化fileinput控件（第一次初始化）
 * @param ctrlName id
 * @param uploadUrl 路径
 * @returns
 */
function initFileInput(ctrlName, uploadUrl) {    
    var control = $('#' + ctrlName); 
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: uploadUrl, //上传的地址
        allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
        showUpload: false, //是否显示上传按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式             
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 
    });
}

function loginout(){
	$.ajax({
        type:"post",
        dataType:"json",
        url:"/loginout",
        success:function(result){  
        	window.location.href = "login";
        },error:function(){
        	toastr.success("登出失败");
        }
    })
}