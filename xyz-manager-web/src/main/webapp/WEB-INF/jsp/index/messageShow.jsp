<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>消息列表</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
<script src="${pageContext.request.contextPath}/js/index/messageShow.js"></script>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="../common/common_header.jsp"%>

<div class="container">
<div class="row">
<div class="col-md-1"></div>
<div class="col-md-10">

<div class="page-header">
    <h1>消息列表</h1>
</div>

<ul class="nav nav-tabs">
    <li class="active">
        <a href="content">所有消息</a>
    </li>
</ul>
	<c:forEach items="${pageInfo.list }" var="mes">
		<c:if test="${mes.uid ==sessionScope.user.id }">
      		<div class="media well">
               <div class="media-body text-right">
                   <h4 class="media-heading">${mes.nick }(${mes.name }) </h4>
                   ${mes.message }
                   <h6>发布时间：<fmt:formatDate value="${mes.created}" pattern="yyyy-MM-dd HH:mm"/></h6>
               </div>
               <div class="media-right">
                   <a href="#">
                       <img class="media-object wh64" src="images/b.png" alt="技术大哥">
                   </a>
               </div>
          	</div>
      	</c:if>
      	<c:if test="${mes.uid !=sessionScope.user.id }">
       	<div class="media well">
               <div class="media-left">
                   <a href="#">
                       <img class="media-object wh64" src="images/a.png" alt="卓大哥">
                   </a>
               </div>
               <div class="media-body">
                   <h4 class="media-heading">${mes.nick }</h4>
                   ${mes.message }
               </div>
           </div>
          </c:if>
	</c:forEach>
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
<div class="col-md-1"></div>
</div>
</div>
<%@ include file="../common/common_footer.jsp"%>
</body>
</html>