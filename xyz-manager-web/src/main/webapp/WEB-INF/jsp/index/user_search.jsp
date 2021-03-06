<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>用户搜索</title>
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
                <a href="user_list" class="list-group-item">用户管理</a>
                <a href="uesr_search" class="list-group-item active">用户搜索</a>
                <a href="" role="button"  class="list-group-item" data-toggle="modal" data-target="#myModal">添加用户</a>
            </div>
        </div>
        <div class="col-md-10">
            <div class="page-header">
                <h1>用户管理</h1>
            </div>
            <ul class="nav nav-tabs">
                <li>
                    <a href="user_list">用户列表</a>
                </li>
                <li  class="active">
                    <a href="uesr_search">用户搜索</a>
                </li>
                <li>
                    <a href="" role="button" data-toggle="modal" data-target="#myModal">添加用户</a>
                </li>
            </ul>
            <form action="#" class="uesr_search">
                <div class="alert alert-info" role="alert">
                    <strong>技巧提示：</strong>
                    支持模糊搜索和匹配搜索，匹配搜索使用*代替！
                </div>
                <div class="form-group">
                    <label for="name">用户名</label>
                    <input type="texte" id="name" class="form-control" placeholder="请输入用户名">
                </div>
                <div class="form-group">
                    <label for="uid">UID</label>
                    <input type="text" id="uid" class="form-control" placeholder="输入用户UID">
                </div>
                <div class="form-group">
                    <label for="yonghuzu">选择用户组</label>
                    <select id="yonghuzu" class="form-control">
                        <option>限制会员</option>
                        <option>新手上路</option>
                        <option>组册会员</option>
                        <option>中级会员</option>
                        <option>高级会员</option>
                    </select>
                </div>
                <button class="btn btn-default" onclick="searchUser()">提交</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="common_user_add.jsp"%>
<%@ include file="../common/common_footer.jsp"%>
</body>
</html>