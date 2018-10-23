$(function () {
	initWangEditor();
	initFileInput("filePicture","/upload");
	addFormValidator();
})

/**
 * 表单验证
 */

function addFormValidator(){
	$('#addForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            title: {
                message: '不能为空',
                validators: {
                    notEmpty: {
                        message: '标题不能为空'
                    },
                    stringLength: {     //输入　长度限制　　校验
                        min: 2,
                        message: '最少两个字'
                    },
                }
            },
            price: {
                message: '价格不能为空',
                validators: {
                    notEmpty: {
                        message: '价格不能为空'
                    },
                }
            },
        }
    });
}

/**
 * 提交表单
 * @returns
 */
function addItem() {
	$('#addForm').data('bootstrapValidator').validate();//启用验证
	var flag = $('#addForm').data('bootstrapValidator').isValid()//验证是否通过true/false
	if(!flag){
		return ;
	}
	//获取 <div id="editor"></div> 
	//给<input type="hidden" id="addFormSellPoint" name="sellPoint">赋值
	$('#addFormSellPoint').val(editor.txt.html());
	//editor.txt.html()复空值，因为editor对象为全局对象
	editor.txt.html("")
	$.ajax({
        type:"post",
        dataType:"json",
        url:"/item/insert",
        async:false,//异步  true 同步
        data:$('#addForm').serialize(),
        success:function(result){  
        	toastr.success("添加成功"); 
        },error:function(){
        	
        }
    })
}

/**
 * 保存图片，并给表单赋值
 * @returns
 */
function selectPic(){
	$('#filePicture').fileinput('upload'); //触发插件开始上传。
	//异步上传返回结果处理 多个图片每次独立回调
	$("#filePicture").on("fileuploaded", function (event, data, previewId, index) {
		//alert(JSON.stringify(event));alert(JSON.stringify(data));alert(JSON.stringify(previewId));alert(JSON.stringify(index));
		var imgUrls = data.response.urls;
		$('#addFormPicName').append("<img src='"+imgUrls+"' style='height: 50px;width: 70px;'>");
		//给<input type="hidden" id="addFormImage" name="image" class="form-control">赋值
		if($('#addFormImage').val() == ""){
			$('#addFormImage').val(imgUrls);
		}else{
			//用,号区分
			$('#addFormImage').val($('#addFormImage').val()+","+imgUrls);
		}
	 });
	 $("#selectPicModal").modal("hide");
}

/**
 * 选择分类，并且给表单赋值cid
 * @returns
 */
function selectCat(){
	var node = $('#tree').treeview('getSelected')[0];
	//选择一个节点
	if(node==null || node == ""){
		toastr.info("请选择一个数据"); 
		return ;
	}
	//如果为父节点，不让删除
	if(node.tags[0] == "父节点"){
		toastr.info("请选择父节点"); 
		return ;
	}
	//给<div id="addFormCatName"></div>赋值
	$('#addFormCatName').append("<span>"+node.text+"</span>");
	//给<input type="hidden" id="addFormCid" name="cid" class="form-control" >id
	$('#addFormCid').val(node.id);
	//关闭模态框selectCatModal
	$('#selectCatModal').modal('hide');
}