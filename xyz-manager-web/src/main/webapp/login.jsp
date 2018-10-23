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
<style>
	body,p,div,ul,li,h1,h2,h3,h4,h5,h6{
		margin:0;
		padding: 0;
	}
	body{
		background: #CAE1FF; 
	}
	#login{
		width: 400px;
		height: 250px;
		background: #F0F8FF;
		margin:150px auto;
		position: relative;
	}
	#login h1{
		text-align:center;
		position:absolute;
		left:120px;
		top:-40px;
		font-size:21px;
	}
	#login form p{
		text-align: center;
	}
	.username{
		background: rgba(0,0,0,.1) no-repeat;
		width: 200px;
		height: 30px;
		border:solid #ccc 1px;
		border-radius: 3px;
		padding-left: 32px;
		margin-top: 50px;
		margin-bottom: 30px;
	}
	.password{
		background: rgba(0,0,0,.1) no-repeat;
		width: 200px;
		height: 30px;
		border:solid #ccc 1px;
		border-radius: 3px;
		padding-left: 32px;
		margin-bottom: 30px;
	}
	.sbm_btn{
		text-align: center;
		background-color: #1abc9c;
		color:#fff;
		line-height: 35px;
		display:block;
		width:55%;
		margin:0 auto;
		height:35px;
		font-size:16px;
		border-color:blueviolet;
		border-radius: 5px;
		border:0;
		padding-left:8px;
	}
	.sbm_btn:hover{
		cursor: pointer;
		background:#D8D8D8;
	}
</style>

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