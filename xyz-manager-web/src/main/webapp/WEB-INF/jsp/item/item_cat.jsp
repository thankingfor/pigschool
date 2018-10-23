<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>数据维护-商品菜单</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
<script src="${pageContext.request.contextPath}/js/item/item_cat.js"></script>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="../common/common_header.jsp"%>
<!-- 内容 -->
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <div class="list-group">
                <a href="item_cat" class="btn list-group-item active">商品菜单</a>
                <a class="btn list-group-item" onclick="insertNode()">添加分类</a>
                <a class="btn list-group-item" onclick="editNode()">修改名称</a>
                <a class="btn list-group-item" onclick="delNode()">删除节点</a>
            </div>
        </div>
        <div class="col-md-10">
            <div class="page-header">
                <h1>商品菜单管理</h1>
            </div>
            <div class="page-body">
            	<div id="tree"></div>
            </div>
     	</div>
     </div>
</div>
<!-- 内容 -->

<!-- 模态框 -->
<!-- 添加分类 -->
<div class="modal fade" id="insertNodeModel" tabindex="-1" role="dialog" aria-labelledby="insertNodeModelLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加分类</h4>
            </div>
            <div class="modal-body">
                <form id="addForm">
                    <div class="form-group">
                        <label for="addname">分类名称</label>
                        <input type="text" id="insertName" name="name" class="form-control" placeholder="类别名称">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="insertNodeAjax()">确定</button>
            </div>
        </div>
    </div>
</div>
<!-- 添加分类-->
<!-- 修改分类名称 -->
<div class="modal fade" id="updateNodeModel" tabindex="-1" role="dialog" aria-labelledby="updateNodeModelLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加分类</h4>
            </div>
            <div class="modal-body">
                <form id="editForm">
                    <div class="form-group">
                        <label for="editname">分类名称</label>
                        <input type="text" id="updateName" name="name" class="form-control" placeholder="类别名称">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updateNodeAjax()">确定</button>
            </div>
        </div>
    </div>
</div>
<!-- 修改分类名称 -->
<!-- 模态框 -->
</body>
</html>