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
    <tr>
        <th scope="row">泛Mooc职业教育， 效果和就业为王</th>
        <td>朱朝兵</td>
        <td>2015/08/08</td>
        <td>
            <div role="presentation" class="dropdown">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    操作<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">编辑</a></li>
                    <li><a href="#">删除</a></li>
                    <li><a href="#">全局置顶</a></li>
                </ul>
            </div>
        </td>
    </tr>
    <tr>
        <th scope="row">产品经理常犯的7大错误，你造吗？</th>
        <td>朱朝兵</td>
        <td>2015/08/08</td>
        <td>
            <div role="presentation" class="dropdown">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    操作<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">编辑</a></li>
                    <li><a href="#">删除</a></li>
                    <li><a href="#">全局置顶</a></li>
                </ul>
            </div>
        </td>
    </tr>
    <tr>
        <th scope="row">如何正确使用python日志系统</th>
        <td>朱朝兵</td>
        <td>2015/08/08</td>
        <td>
            <div role="presentation" class="dropdown">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    操作<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">编辑</a></li>
                    <li><a href="#">删除</a></li>
                    <li><a href="#">全局置顶</a></li>
                </ul>
            </div>
        </td>
    </tr>
    <tr>
        <th scope="row">C语言const修饰符的怎么使用？</th>
        <td>朱朝兵</td>
        <td>2015/08/08</td>
        <td>
            <div role="presentation" class="dropdown">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    操作<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">编辑</a></li>
                    <li><a href="#">删除</a></li>
                    <li><a href="#">全局置顶</a></li>
                </ul>
            </div>
        </td>
    </tr>
    <tr>
        <th scope="row">Android开发用onCreateOptionsMenu()如何创</th>
        <td>朱朝兵</td>
        <td>2015/08/08</td>
        <td>
            <div role="presentation" class="dropdown">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    操作<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">编辑</a></li>
                    <li><a href="#">删除</a></li>
                    <li><a href="#">全局置顶</a></li>
                </ul>
            </div>
        </td>
    </tr>
    <tr>
        <th scope="row">怎样才能成为优秀的iOS开发工程师</th>
        <td>朱朝兵</td>
        <td>2015/08/08</td>
        <td>
            <div role="presentation" class="dropdown">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    操作<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">编辑</a></li>
                    <li><a href="#">删除</a></li>
                    <li><a href="#">全局置顶</a></li>
                </ul>
            </div>
        </td>
    </tr>
    <tr>
        <th scope="row">Android今年推出了些什么新技术？</th>
        <td>朱朝兵</td>
        <td>2015/08/08</td>
        <td>
            <div role="presentation" class="dropdown">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    操作<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">编辑</a></li>
                    <li><a href="#">删除</a></li>
                    <li><a href="#">全局置顶</a></li>
                </ul>
            </div>
        </td>
    </tr>
    </tbody>
</table>
<nav class="pull-right">
    <ul class="pagination">
        <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
        <li class="active"><a href="#">1</a></li>
        <li><a href="#">2 </a></li>
        <li><a href="#">3 </a></li>
        <li><a href="#">4 </a></li>
        <li><a href="#">5 </a></li>
        <li><a href="#">6 </a></li>
        <li><a href="#"><span aria-hidden="true">&raquo;</span></a></li>
    </ul>
</nav>
</div>
</div>
</div>
<!--footer-->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p>
                    Copyright&nbsp;©&nbsp;2012-2015&nbsp;&nbsp;www.maiziedu.com&nbsp;&nbsp;蜀ICP备13014270号-4
                </p>
            </div>
        </div>
    </div>
</footer>
<!--footer-->
</body>
</html>