<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>数据维护-商品详情-商品添加</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
<script src="${pageContext.request.contextPath}/js/item/item_cat.js"></script>
<script src="${pageContext.request.contextPath}/js/item/item_add.js"></script>
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
                        <input type="hidden" id="addFormCid" name="cid" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="addname">商品名称</label>
                        <input type="text" id="addFormTitle" name="title" class="form-control" placeholder="请输入商品名称">
                    </div>
                    <div class="form-group">
                        <label for="addpassword">商品价格</label>
                        <input type="text" id="addFormprice" name="price" class="form-control" placeholder="请输入商品价格">
                    </div>
                    <div class="form-group">
                        <label for="addpassword1">商品数量</label>
                        <input type="text" id="addFormNum" name="num" class="form-control" placeholder="请输入商品数量" required data-bv-notempty-message="不能为空">
                    </div>
                    <div class="form-group">
                    	<div id="addFormPicName">
                    		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#selectPicModal">添加图片</button>
                    	</div>
                        <input type="hidden" id="addFormImage" name="image" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="addyonghuzu">是否可以砍价</label>
                        <select id="addyonghuzu" class="form-control" name="isBargain">
                            <option selected="selected" value="0">一份不让</option>
                            <option value="1">略微讨价</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="addyonghuzu">商品成色</label>
                        <select id="addyonghuzu" class="form-control" name="assay">
                            <option selected="selected" value="0">非全新</option>
                            <option value="10">全新</option>
                            <option value="9">九成新</option>
                            <option value="8">八成新</option>
                            <option value="5">五成新</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="addemail">所在地</label>
                        <input type="text" id="addFormLocation" name="location" class="form-control" placeholder="例如：安阳工学院十里铺公寓"  required data-bv-notempty-message="不能为空">
                    </div>
                    <div class="form-group">
                        <label for="addemail">联系方式</label>
                        <input type="text" id="addFormContactInfo" name="contactInfo" class="form-control" placeholder="例如：QQ号，微信，手机等。。。" required data-bv-notempty-message="不能为空">
                    </div>
                    <input type="hidden" id="addFormDealway" name="dealway" value="0">
                    <div id="editor"></div>
                    <input type="hidden" id="addFormSellPoint" name="sellPoint">
					<div class="page-footer" style="text-align:center;margin-top: 50px;margin-bottom: 50px;">
						<button type="button" class="btn btn-success" onclick="addItem()" style="height: 40px;width: 140px;">保存</button>
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
                <h4 class="modal-title" id="myModalLabel">分类选择</h4>
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
<!-- 选择分类 -->
<div class="modal fade" id="selectCatModal" tabindex="-1" role="dialog" aria-labelledby="selectCatModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">分类选择</h4>
            </div>
            <div class="modal-body">
                <form id="selectCatForm">
                	<div id="tree"></div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="selectCat()">保存</button>
            </div>
        </div>
    </div>
</div>
<!-- 选择分类 -->
<!-- 模态框 -->
</body>
</html>