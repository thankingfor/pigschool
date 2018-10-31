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
<title>内容主页</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
<script src="${pageContext.request.contextPath}/js/index/content.js" ></script>
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
    <h1>内容管理</h1>
</div>
<ul class="nav nav-tabs">
    <li class="active">
        <a href="content">内容管理</a>
    </li>
    <li>
        <a href="content_post">添加内容</a>
    </li>
</ul>
<%-- 当前页:${pageInfo.pageNum }
每页的数量:${pageInfo.pageSize }
当前页的数量:${pageInfo.size }
总记录数:${pageInfo.total }
总页数:${pageInfo.pages } --%>
<table class="table">
    <thead>
    <tr>
        <th>文章标题</th>
        <th>作者</th>
        <th>发布时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageInfo.list }" var="con">
    <tr>
        <th scope="row">${con.title }</th>
        <td>${con.author }</td>
        <td><fmt:formatDate value="${con.pulish}" pattern="yyyy-MM-dd HH:mm"/> </td>
        <td>
            <div role="presentation" class="dropdown">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    操作<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a onclick="upTop(${con.id })">全局置顶</a></li>
                    <li><a onclick="outTop(${con.id })">取消置顶</a></li>
                    <li><a href="${pageContext.request.contextPath}/showContent?id=${con.id }">查看详情</a></li>
                </ul>
            </div>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<nav class="pull-right">
    <ul class="pagination">
    	<%-- <li>每页的数量:${pageInfo.pageSize }</li> --%>
    	<%-- <li>总记录数:${pageInfo.total }</li> --%>
        <li><a onclick="turnToUp(${pageInfo.pageNum })" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
        <li><a onclick="turnTo(1)">1</a></li>
        <li><a onclick="turnTo(${pageInfo.pageNum })" class="disabled">当前：${pageInfo.pageNum }</a></li>
        <li><a onclick="turnTo(${pageInfo.pages })" class="disabled">总共：${pageInfo.pages }</a></li>
        <li><a onclick="turnTo(${pageInfo.pages })" class="disabled">${pageInfo.pages }</a></li>
        <li><a onclick="turnToDown(${pageInfo.pageNum },${pageInfo.pages })"><span aria-hidden="true">&raquo;</span></a></li>
        
    </ul>
</nav>
</div>
</div>
</div>
<!-- 模态框 -->
<!-- 内容详情 -->
<!-- 内容详情 -->
<!-- 模态框 -->
<%@ include file="../common/common_footer.jsp"%>
</body>
</html>