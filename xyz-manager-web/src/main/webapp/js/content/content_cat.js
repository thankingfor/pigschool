$(function() {
	initTree(checkTree(0));
})

/**
 * 修改名称
 * @returns
 */
function editNode(){
	var node = $('#tree').treeview('getSelected')[0];
	if(node!=null && node != ""){
		$('#updateName').val(node.text);
		$('#updateNodeModel').modal();
	}else{
		toastr.warning('请选择一列数据!'); 
    }
}
/**
 * 删除
 * @returns
 */
function delNode(){
	var node = $('#tree').treeview('getSelected')[0];
	var parNode = $('#tree').treeview('getParent', node.nodeId);
	//如果为父节点，不让删除
	if(node.tags[0] == "父节点"){
		return ;
	}
	if(node!=null && node != ""){
		$.ajax({
	        type:"post",
	        dataType:"json",
	        url:"/content/cat/del",
	        async:false,
	        data:{parentId:parNode.id,id:node.id},
	        success:function(XYZResult){  
	        	toastr.success("删除成功");
	        	//$('#tree').treeview("deleteNode", node.nodeId);
	        	$('#tree').treeview('collapseAll', { silent: true });
	        },error:function(){
	            toastr.warning('修改异常！'); 
	        }
	    })
	}else{
		toastr.warning('请选择一列数据!'); 
    }
}

/**
 * 添加子节点
 * @returns
 */
function insertNode(){
	var node = $('#tree').treeview('getSelected')[0];
	if(node!=null && node != ""){
		$('#insertNodeModel').modal();
	}else{
		BootstrapDialog.show({
	        message: '请选择一列数据!'
	    });
    }
}
/**
 * 初始化树
 * node.nodeId为默认自增id
 * node.id 自己定义的id
 * node.text 名字
 * tags为标签 tags: ['子节点',"haha"] 实体类为数组才行
 * @returns
 */
function initTree(data) {
	$('#tree').treeview({
        data: data,
        showTags: true,
		onNodeSelected: function(event, node) {
            //alert(node.nodeId+"为node.nodeId"+node.id+"前面是node.id，后面是名字"+node.text);//这里拿到id和name，就可以通过函数跳转触发点击事件
            var datas = checkTree(node.id);
            if(node!=null && node != ""){
            	$("#tree").treeview("deleteChildrenNode", node.nodeId);//删除节点的子节点
                $("#tree").treeview("addNode", [node.nodeId, {node: datas}]);//添加节点
                $('#tree').treeview('expandNode', node.nodeId) //展开节点，但不包括节点的节点
            }
        },
      });
}
/**
 * 修改节点的ajax
 * @returns
 */
function updateNodeAjax(){
	var name = $('#updateName').val();
	var node = $('#tree').treeview('getSelected')[0];
	if(node!=null && node != ""){
		$.ajax({
	        type:"post",
	        dataType:"json",
	        url:"/content/cat/update",
	        async:false,
	        data:{id:node.id,name:name},
	        success:function(XYZResult){  
	        	$("#updateNodeModel").modal('hide'); 
	        	$('#tree').treeview('collapseAll', { silent: true });
	        	//做页面的刷新操作 得到父节点
	        	//var parNode = $('#tree').treeview('getParent', node);
	        	//$('#tree').treeview('expandNode', parNode.nodeId) //展开节点，但不包括节点的节点
	        	toastr.success("修改成功");
	        },error:function(){
	            toastr.warning('修改异常！'); 
	        }
	    })
	}
}
/**
 * 添加节点的ajax
 * @returns
 */
function insertNodeAjax(){
	var name = $('#insertName').val();
	var node = $('#tree').treeview('getSelected')[0];
	if(node!=null && node != ""){
		$.ajax({
	        type:"post",
	        dataType:"json",
	        url:"/content/cat/insert",
	        async:false,
	        data:{parentId:node.id,name:name},
	        success:function(XYZResult){  
	        	toastr.success("添加成功");
	        	$("#insertNodeModel").modal('hide'); 
	        },error:function(){
	            toastr.warning('添加异常！'); 
	        }
	    })
	}
}
//根据id查找子树
function checkTree(parentId){
	var data ;
	$.ajax({
        type:"post",
        dataType:"json",
        async:false,
        url:"/content/cat/list",
        data:{parentId:parentId},
        success:function(XYZResult){  
        	data = XYZResult.data;
        	//JSON.stringify(data) 转json 的方法
        },error:function(){
        	toastr.warning('数据异常!'); 
        }
    })
    return data;
}