<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>登录</title>
<link href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-reboot.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function(){
		$(document).keyup(function(event){
			  if(event.keyCode ==13){
			    login();
			  }
		});
	});
	
	function login(){
		
		if($("#username").val()==''){
			$.messager.alert('警告','用户名不能为空','info');
			console.log(11)
		}else if($("#password").val()==''){
			$.messager.alert('警告','不能密码为空','info');
		}else{
			$("#fm").submit();
		}
		}	 
</script>
</head>
<body>
<div style="background-color: #663399;">
<div style="width: 800px; margin: 0 auto; position: relative;"> <img style="height: 50px;" src="${pageContext.request.contextPath}/static/image/image1.jpg" /></div>
</div>
<div id="login">
<h1>用户登录</h1>	
	<form id="fm" name="fm" action="${pageContext.request.contextPath}/login"
		method="post">
		<p><input type="text" name="username" class="username" id="username" placeholder="请输入用户名""><br></p>
		<p><input type="password" name="password" class="password"  id="password" placeholder="请输入密码"></p>
		<p><a href="javascript:void(0)" onclick="login()" name="sbm" class="sbm_btn" >登录</a></p>
	</form>
</div>
</body>
</html>