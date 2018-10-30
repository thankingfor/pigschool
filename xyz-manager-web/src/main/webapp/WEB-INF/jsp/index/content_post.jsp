<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>bootstrap项目实战</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="../common/common_header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-2">
            <div class="list-group">
                <a href="content" class="list-group-item">内容管理</a>
                <a href="content_post" class="list-group-item active">添加内容</a>
            </div>
        </div>
        <div class="col-md-10">
            <div class="page-header">
                <h1>内容管理</h1>
            </div>
            <ul class="nav nav-tabs">
                <li>
                    <a href="content">内容管理</a>
                </li>
                <li class="active">
                    <a href="content_post">添加内容</a>
                </li>
            </ul>
            <form action="#" class="mar_t15">
                <div class="form-group">
                    <label for="title">标题</label>
                    <input type="text" id="title" class="form-control" placeholder="请输入文章标题">
                </div>
                <div class="form-group">
                    <label for="content">文章内容</label>
                    <textarea id="content" class="form-control" rows="15" cols="10" placeholder="请输入文章正文部分"></textarea>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox">全局置顶
                    </label>
                    <button type="submit" class="btn btn-default pull-right">发布文章</button>
                </div>
            </form>

        </div>
    </div>
</div>

<%@ include file="../common/common_footer.jsp"%>
</body>
</html>