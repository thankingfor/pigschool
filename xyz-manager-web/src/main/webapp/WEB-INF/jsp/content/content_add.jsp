<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>数据维护-内容详情-内容添加</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
<script src="${pageContext.request.contextPath}/js/content/content_cat.js"></script>
<script src="${pageContext.request.contextPath}/js/content/content_add.js"></script>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="../common/common_header.jsp"%>

<!-- 内容 -->
<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="page-header" style="text-align:center;">
                <h1>商品添加</h1>
            </div>
            <div class="page-body">
                <form id="addForm">
                	<div class="form-group">
	                	<div id="addFormCatName">
	                		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#selectCatModal">选择分类</button>
	                	</div>
                        <input type="hidden" id="addFormCategoryId" name="categoryId" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="addname">大标题</label>
                        <input type="text" id="addFormTitle" name="title" class="form-control" placeholder="请输入大标题" required data-bv-notempty-message="不能为空">
                    </div>
                    <div class="form-group">
                        <label for="addFormSubTitle">子标题</label>
                        <input type="text" id="addFormSubTitle" name="subTitle" class="form-control" placeholder="请输入子标题" required data-bv-notempty-message="不能为空">
                    </div>
                    <div class="form-group">
                        <label for="addFormTitleDesc">标题描述</label>
                        <input type="text" id="addFormTitleDesc" name="titleDesc" class="form-control" placeholder="请输入标题描述" required data-bv-notempty-message="不能为空">
                    </div>
                    <div class="form-group">
                        <label for="addFormUrl">跳转连接</label>
                        <input type="text" id="addFormUrl" name="Url" class="form-control" placeholder="请输入需要跳转的连接" required data-bv-notempty-message="不能为空">
                    </div>
                    <div class="form-group">
                    	<div id="addFormPicName">
                    		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#selectPicModal">添加图片</button>
                    	</div>
                        <input type="hidden" id="addFormPic" name="pic" class="form-control">
                    </div>
                    <div class="form-group">
                    	<div id="addFormPicName2">
                    		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#selectPicModal2">添加图片2</button>
                    	</div>
                        <input type="hidden" id="addFormPic2" name="pic2" class="form-control">
                    </div>
                    <div id="editor"></div>
                    <input type="hidden" id="addFormContent" name="content">
					<div class="page-footer" style="text-align:center;margin-top: 50px;margin-bottom: 50px;">
						<button type="button" class="btn btn-success" onclick="addContent()" style="height: 40px;width: 140px;">保存</button>
		            </div>
                </form>
            </div>
     	</div>
     	<div class="col-md-1"></div>
     </div>
</div>
<!-- 内容 -->

<!-- 模态框 -->
<!-- 添加图片 -->
<div class="modal fade" id="selectPicModal" tabindex="-1" role="dialog" aria-labelledby="selectPicModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">选择图片</h4>
            </div>
            <div class="modal-body">
                <form id="selectPicForm">
                	<input type="file" id="filePicture" name="uploadFile" multiple="multiple" >
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="selectPic()">保存</button>
            </div>
        </div>
    </div>
</div>
<!-- 添加图片 -->
<!-- 添加图片2 -->
<div class="modal fade" id="selectPicModal2" tabindex="-1" role="dialog" aria-labelledby="selectPicModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">图片备份或者手机端显示的图片</h4>
            </div>
            <div class="modal-body">
                <form id="selectPicForm2">
                	<input type="file" id="filePicture2" name="uploadFile" multiple="multiple" >
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="selectPic2()">保存</button>
            </div>
        </div>
    </div>
</div>
<!-- 添加图片2 -->
<!-- 选择分类 -->
<div class="modal fade" id="selectCatModal" tabindex="-1" role="dialog" aria-labelledby="selectCatModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">分类选择</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="selectCat()">保存</button>
            </div>
            <div class="modal-body">
                <form id="selectCatForm">
                	<div id="tree"></div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- 选择分类 -->
<!-- 模态框 -->
</body>
</html>