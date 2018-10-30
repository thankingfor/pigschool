<!-- 此标签解决乱码问题 -->
<%@page pageEncoding="UTF-8"%>
<!-- c标签 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--导航-->
<nav class="navbar navbar-default">
    <div class="container">
        <!--小屏幕导航按钮和logo-->
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="index" class="navbar-brand">SCHOOL PIG</a>
        </div>
        <!--小屏幕导航按钮和logo-->
        <!--导航-->
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="index"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;后台首页</a></li>
                <li><a href="user_list"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;用户管理</a></li>
                <li><a href="content"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;内容管理</a></li>
                <li><a href="tag"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;标签管理</a></li>
            </ul>
            <span class="glyphicon glyphicon-user">当前用户：${sessionScope.user.nick }</span>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        	用户信息
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li><a href="index"><span class="glyphicon glyphicon-screenshot"></span>&nbsp;&nbsp;前台首页</a></li>
                        <li><a href="index"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;个人主页</a></li>
                        <li><a href="index"><span class="glyphicon glyphicon-cog"></span>&nbsp;&nbsp;个人设置</a></li>
                        <li><a href="index"><span class="glyphicon glyphicon-credit-card"></span>&nbsp;&nbsp;账户中心</a></li>
                        <li><a href="index"><span class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;我的收藏</a></li>
                        <li><a href="test"><span class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;测试页面</a></li>
                    </ul>
                </li>
                <li><a href="#bbs" data-toggle="modal" data-target="#loginoutModal"><span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        	数据维护
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li><a href="item_cat"><span class="glyphicon glyphicon-cog"></span>&nbsp;&nbsp;商品菜单</a></li>
                        <li><a href="item_list"><span class="glyphicon glyphicon-credit-card"></span>&nbsp;&nbsp;商品数据</a></li>
                        <li><a href="content_cat"><span class="glyphicon glyphicon-cog"></span>&nbsp;&nbsp;内容菜单</a></li>
                        <li><a href="content_list"><span class="glyphicon glyphicon-credit-card"></span>&nbsp;&nbsp;内容数据</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!--导航-->

    </div>
</nav>
<!--导航-->

<!--模态框-->
<!--登出确认框-->
<div class="modal fade" id="loginoutModal" tabindex="-1" role="dialog" aria-labelledby="loginoutModalModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">退出登录</h4>
            </div>
            <div class="modal-body">
            	是否退出登录？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="loginout()">确定</button>
            </div>
        </div>
    </div>
</div>
<!--登出确认框-->
<!--模态框-->
