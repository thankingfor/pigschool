$(function () {
	tableshow();
})

/**
 * 商品做搜索
 * 需要加载数据
 */
function InitItem(){
	$.ajax({
        type:"post",
        dataType:"json",
        url:"/smk/search/init",
        success:function(XYZResult){  
        	toastr.success("初始化成功");
        	$('#initModal').modal('hide');
        },error:function(){
            toastr.warning('初始化异常！'); 
        }
    })
}

/**
 * 商品删除
 * @returns
 */
function selectDel(){
	var rows = $("#table").bootstrapTable("getSelections");
	if(JSON.stringify(rows) == "[]"){
		toastr.info("请选择至少一条数据！！！");
		return ;
	}
	//传入id数组
	var ids = new Array();
	for (var i = 0; i < rows.length; i++) {
		ids[i] = rows[i].id;
	}
	$.ajax({
        type:"post",
        dataType:"json",
        url:"/item/del",
        async:false,
        traditional: true,
        data:{ids:ids},
        success:function(XYZResult){  
        	toastr.success("删除成功");
        	$("#table").bootstrapTable("refresh");
        },error:function(){
            toastr.warning('删除异常！'); 
        }
    })
}

/**
 * 搜索
 * @returns
 */
function selectList(){
	$("#table").bootstrapTable("refresh");
}

/**
 * 数据的表格
 * @returns
 */
function tableshow(){
	 $('#table').bootstrapTable({  
		 url: '/item/list',  
		 method: 'post',
		 dataType: 'json',
		 contentType: "application/x-www-form-urlencoded",
		 cache: false, 
		 pagination: true, 
		 singleSelect: false,
		 clickToSelect:true,
         sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
         pageNumber: 1,                       //初始化加载第一页，默认第一页
         pageSize: 10,                       //每页的记录行数（*）
         pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
         queryParams: function (params) {
        	 return {
        		 param:$("#sel").val(),
        		 rows: this.pageSize,
 	             page: this.pageNumber,
        	 };
         },          //参数
	     columns: [ {  
                checkbox: true  
            },{
            title: 'ID',
            field: 'id',
            align: 'center',
            valign: 'middle'
          },{
            title: '商品名',
            field: 'title',
            align: 'center',
            valign: 'middle'
          },{
	          title: '价格(元)',
	          field: 'price',
	          align: 'center',
	          valign: 'middle',
	          formatter: function (value, row, index) {
	        	  return value/100;
	          }
          },{
            title: '数量',
            field: 'num',
            align: 'center',
            valign: 'middle',
          },{
              title: '类别',
              field: 'cid',
              align: 'center',
              valign: 'middle'
          },/*{
              title: '地址',
              field: 'location',
              align: 'center',
              valign: 'middle'
          },*/{
              title: '联系方式',
              field: 'contactInfo',
              align: 'center',
              valign: 'middle'
          }/*,{
              title: '图片',
              field: 'image',
              align: 'center',
              valign: 'middle'
          },{
              title: '买点',
              field: 'sellPoint',
              align: 'center',
              valign: 'middle'
          }*/]   
          });
	$("#table").bootstrapTable('hideColumn', 'id');
}