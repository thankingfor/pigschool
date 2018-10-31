<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>校园猪</title>
<%@ include file="common/common_css.jsp"%>
<%@ include file="common/common_js.jsp"%>
<!-- 不记得了 -->
<script src="${pageContext.request.contextPath}/js/plug/script.js"></script>
<script src="${pageContext.request.contextPath}/js/index/index.js"></script>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="common/common_header.jsp"%>

<!--警告框-->
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="alert alert-danger alert-dismissible fade in" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4>网站程序有漏洞，急需修复！</h4>
                <p>当前版本程序(V1.22)存在严重安全问题，容易造成攻击，请即可修复！</p>
                <p>
                    <button type="button" class="btn btn-danger">立即修复</button>
                    <button type="button" class="btn btn-default"  data-dismiss="alert"  >稍后处理</button>
                </p>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">网站数据统计</div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>统计项目</th>
                                <th>今日</th>
                                <th>昨日</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                 <th scope="row">注册会员</th>
                                 <td>200</td>
                                 <td>400</td>
                            </tr>
                            <tr>
                                <th scope="row">登录会员</th>
                                <td>4100</td>
                                <td>5112</td>
                            </tr>
                            <tr>
                                <th scope="row">今日发帖</th>
                                <td>1540</td>
                                <td>4511</td>
                            </tr>
                            <tr>
                                <th scope="row">转载次数</th>
                                <td>150</td>
                                <td>110</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">网站热帖</div>
                    <ul class="list-group">
                    <c:forEach items="${ContentInfo.list }" var="con">
                    	<li class="list-group-item">
                            <a href="${pageContext.request.contextPath}/showContent?id=${con.id }"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;${con.title }
                            <small class="pull-right"><fmt:formatDate value="${con.pulish }" pattern="yyyy/MM/dd"/></small></a>
                        </li>
                    </c:forEach>
                    </ul>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">今日访客统计</div>
                <div class="panel-body">
                    <canvas id="canvas" class="col-md-12"></canvas>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">服务器状态</div>
                <div class="panel-body">
                    <p>内存使用率：40%</p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%"></div>
                    </div>
                    <p>数据库使用率：20%</p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%"></div>
                    </div>
                    <p>磁盘使用率：60%</p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%"></div>
                    </div>
                    <p>CPU使用率：80%</p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">团队留言板</div>
                <div class="panel-body">
                    <div class="col-md-7">
                    <c:forEach items="${MessageInfo.list }" var="mes">
                    	<c:if test="${mes.uid ==sessionScope.user.id }">
                    		<div class="media well">
	                            <div class="media-body text-right">
	                                <h4 class="media-heading">${mes.nick }</h4>
	                                ${mes.message }
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
                    </div>
                    <div class="col-md-5">
                        <div class="form-group">
                            <label for="messageText">输入留言内容</label>
                            <textarea class="form-control" id="messageText" rows="5" cols="10" placeholder="请输入留言内容"></textarea>
                            <button onclick="addMessage()" class="btn btn-default mar_t15">留言</button>
                            <a  href="${pageContext.request.contextPath}/message" class="btn btn-default mar_t16">查看所有</a>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">团队联系手册</div>
                            <div class="panel-body">
                                <ul class="list-group">
                                    <li class="list-group-item">给站(李小龙)：<span class="glyphicon glyphicon-phone"></span>&nbsp;&nbsp;13134848615</li>
                                    <li class="list-group-item">技术(大牛哥)：<span class="glyphicon glyphicon-phone"></span>&nbsp;&nbsp;13456127694</li>
                                    <li class="list-group-item">推广(张二哥)：<span class="glyphicon glyphicon-phone"></span>&nbsp;&nbsp;13457815482</li>
                                    <li class="list-group-item">客服(王女士)：<span class="glyphicon glyphicon-phone"></span>&nbsp;&nbsp;13134567782<!-- &nbsp;&nbsp;<span class="glyphicon glyphicon-phone-alt"></span>&nbsp;&nbsp;028-888888 --></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<%@ include file="common/common_footer.jsp"%>
</body>
</html>