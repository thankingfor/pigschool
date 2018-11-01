<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>用户列表</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
<script src="${pageContext.request.contextPath}/js/index/user_list.js"></script>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="../common/common_header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-2">
            <div class="list-group">
                <a href="user_list" class="list-group-item active">用户管理</a>
                <a href="user_search" class="list-group-item">用户搜索</a>
                <a href="" role="button"  class="list-group-item" data-toggle="modal" data-target="#myModal">添加用户</a>
            </div>
        </div>
        <div class="col-md-10">
            <div class="page-header">
                <h1>用户管理</h1>
            </div>
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="user_list">用户列表</a>
                </li>
                <li>
                    <a href="user_search">用户搜索</a>
                </li>
                <li>
                    <a href="" role="button" data-toggle="modal" data-target="#myModal">添加用户</a>
                </li>
            </ul>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>昵称</th>
                        <th>电话</th>
                        <th>邮箱</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${UserInfo.list }" var="user">
                <tr>
                        <th scope="row">${user.id }</th>
                        <td>${user.name }</td>
                        <td>${user.nick }</td>
                        <td>${user.phone }</td>
                        <td>${user.email }</td>
                        <td>
                            <div role="presentation" class="dropdown">
                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    操作<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                   <li><a onclick="showDetail(${user.id })">查看详情</a></li>
                                   <li><a onclick="truckHim(${user.id })">向他吐口水</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                    </tr>
                </tbody>
            </table>
            <nav class="pull-right">
			    <ul class="pagination">
			    	<%-- <li>每页的数量:${pageInfo.pageSize }</li> --%>
			    	<%-- <li>总记录数:${pageInfo.total }</li> --%>
			        <li><a onclick="turnToUp(${UserInfo.pageNum })" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			        <li><a onclick="turnTo(1)">1</a></li>
			        <li><a onclick="turnTo(${UserInfo.pageNum })" class="disabled">当前：${UserInfo.pageNum }</a></li>
			        <li><a onclick="turnTo(${UserInfo.pages })" class="disabled">总共：${UserInfo.pages }</a></li>
			        <li><a onclick="turnTo(${UserInfo.pages })" class="disabled">${UserInfo.pages }</a></li>
			        <li><a onclick="turnToDown(${UserInfo.pageNum },${UserInfo.pages })"><span aria-hidden="true">&raquo;</span></a></li>
			        
			    </ul>
			</nav>
        </div>
    </div>
</div>
<!-- 用户添加 -->
<%@ include file="common_user_add.jsp"%>
<%@ include file="../common/common_footer.jsp"%>
</body>
</html>