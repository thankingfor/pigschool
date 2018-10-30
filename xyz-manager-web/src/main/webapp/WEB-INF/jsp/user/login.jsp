<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>后台登录</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
<script src="${pageContext.request.contextPath}/js/user/login.js"></script>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="../common/common_header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
	        <div class="page-header" style="text-align:center;">
                <h1>后台登录</h1>
            </div>
	        <div class="page-body">
	        	<span id="msg" style="color: red;"></span>
	        	<form id="loginForm">
                    <div class="form-group">
                        <label for="username">账号</label>
                        <input type="text" id="username" name="username" class="form-control" placeholder="请输入账号">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="text" id="password" name="password" class="form-control" placeholder="请输入密码">
                    </div>
                </form>
	        </div>
	        <div class="page-footer" style="text-align:center;margin-top: 50px;margin-bottom: 50px;">
				<button type="button" class="btn btn-success" onclick="login()" style="height: 40px;width: 140px;">登录</button>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>

<%@ include file="../common/common_footer.jsp"%>
</body>
</html>