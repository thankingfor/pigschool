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
                <h1>出错页面</h1>
            </div>
	        <div class="page-body">
	        	页面出错
	        </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>

<%@ include file="../common/common_footer.jsp"%>
</body>
</html>