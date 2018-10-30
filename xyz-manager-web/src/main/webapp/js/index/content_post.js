$(function () {
	initWangEditor();
})

/**
 * 提交表单
 * @returns
 */
function addContent() {
	var title = $('#title').val();
	if(title == "" ||title ==null ){
		alert("标题不能为空");
		return ;
	}
	//获取 <div id="editor"></div> 
	//给<input type="hidden" id="content" name="content">赋值
	$('#content').val(editor.txt.html());
	//editor.txt.html()复空值，因为editor对象为全局对象
	editor.txt.html("")
	var content = $('#content').val();
	var isTop = 0;
	if($("#is_top").is(":checked")){
		isTop = 1;
	}
	$.ajax({
        type:"post",
        dataType:"json",
        url:"/manager/content/insert",
        async:false,//异步  true 同步
        data:{title:title,content:content,isTop:isTop},
        success:function(result){  
        	toastr.success("添加成功"); 
        },error:function(){
        	toastr.warning("添加失败");
        }
    })
}