<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>内容展示</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
<script src="${pageContext.request.contextPath}/js/index/contentShow.js" ></script>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="../common/common_header.jsp"%>

<div class="container">
<div class="row">
<div class="col-md-2">
    <div class="list-group">
        <a href="content" class="list-group-item active">内容管理</a>
        <a href="content_post" class="list-group-item">添加内容</a>
    </div>
</div>
<div class="col-md-10">
<div class="page-header">
    <h1>内容详情</h1>
</div>
<ul class="nav nav-tabs">
    <li class="active">
        <a href="content">内容管理</a>
    </li>
</ul>
	<p>标题：${content.title } 作者：${content.author } 发布时间：<fmt:formatDate value="${content.pulish}" pattern="yyyy-MM-dd HH:mm"/></p>
	<p>${content.content }</p>
</div>
</div>
</div>
<%@ include file="../common/common_footer.jsp"%>
</body>
</html>