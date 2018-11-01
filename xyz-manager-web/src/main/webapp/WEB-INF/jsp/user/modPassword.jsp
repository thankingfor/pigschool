<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>修改密码</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
<script src="${pageContext.request.contextPath}/js/user/modPassword.js"></script>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="../common/common_header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
	        <div class="page-header" style="text-align:center;">
                <h1>密码修改</h1>
            </div>
	        <div class="page-body">
	        	<span id="msg" style="color: red;"></span>
                 <div class="form-group">
                     <label for="password">密码</label>
                     <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
                 </div>
	        </div>
	        <div class="page-footer" style="text-align:center;margin-top: 50px;margin-bottom: 50px;">
				<button type="button" class="btn btn-success" onclick="modPsw()" style="height: 40px;width: 140px;">修改</button>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>

<%@ include file="../common/common_footer.jsp"%>
</body>
</html>