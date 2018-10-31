<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>数据维护-商品详情</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
<script src="${pageContext.request.contextPath}/js/item/item_list.js"></script>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="../common/common_header.jsp"%>
<!-- 内容 -->
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <div class="list-group">
                <a href="item_list" class="list-group-item active">商品信息</a>
                <a href="item_add" role="button"  class="list-group-item">添加商品</a>
                <input id="sel" type="text" class="form-control" value="" placeholder="搜索内容">
                <a class="list-group-item" onclick="selectList()">商品搜索</a>
                <a class="list-group-item" onclick="selectDel()">商品删除</a>
                <a class="list-group-item" data-toggle="modal" data-target="#initModal">初始化索引库</a>
                
            </div>
        </div>
        <div class="col-md-10">
            <div class="page-header">
                <h1>商品管理</h1>
            </div>
            <div class="page-body">
            	<table id="table"></table>
            </div>
     	</div>
     </div>
</div>
<!-- 内容 -->

<!-- 模态框 -->
<!-- 确认初始化 -->
<!-- 选择分类 -->
<div class="modal fade" id="initModal" tabindex="-1" role="dialog" aria-labelledby="initModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">初始化二手市场搜索库</h4>
            </div>
            <div class="modal-body">
            	你确定执行此操作么？很可能有大量数据流失！
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="InitItem()">确认</button>
            </div>
        </div>
    </div>
</div>
<!-- 确认初始化 -->
<!-- 模态框 -->

<%@ include file="../common/common_footer.jsp"%>
</body>
</html>