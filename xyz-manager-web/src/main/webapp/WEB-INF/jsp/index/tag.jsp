<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>标签</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
<script src="${pageContext.request.contextPath}/js/index/tag.js"></script>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="../common/common_header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1>TAG标签管理</h1>
            </div>
            <div class="col-md-12 pad0">
                <form>
                    <div class="col-md-10">
                        <input id="tagValue" class="form-control" placeholder="请输入要添加的标签">
                    </div>
                    <div class="col-md-2">
                        <button onclick="tagAdd()" class="btn btn-default">添加</button>
                    </div>
                </form>
            </div>
            <div class="col-md-12 taglist">
            	<c:forEach items="${pageInfo.list }" var="tag">
	            	<div class="alert alert-info alert-dismissible pull-left" role="alert">
	                    <button type="button"  onclick="showdelModel(${tag.id })" class="close" aria-label="Close" ><span aria-hidden="true">&times;</span></button>
	                    <strong>${tag.content }</strong>
	                </div>
            	</c:forEach>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="delModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="delModalLabel">删除标签</h4>
            </div>
            <div class="modal-body">
            	你确认要删除么？
            	<input id="delId" type="hidden" value=""/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="delTag()">确认</button>
            </div>
        </div>
    </div>
</div>

<%@ include file="../common/common_footer.jsp"%>
</body>
</html>