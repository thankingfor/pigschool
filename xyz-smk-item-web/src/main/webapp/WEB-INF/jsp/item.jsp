<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>商品详情页面</title>
</head>
<body>
	商品详情页面
	商品ID：${itemDec.id } 价格：${itemDec.price } <br/>
	商品名称：${itemDec.title }<br/>
	商品名称：${itemDec.cid }<br/>
	商品名称：${itemDec.cname }<br/>
	图片：<img alt=""  src="${itemDec.images[0] }"  style="height: 200px;width: 200px;"/><br/>
	所有图片
	<c:forEach items="${itemDec.images }" var="image">
    <li style="float: left;height: 50px;width: 50px;">
    <img title="${itemDec.title } " alt="${itemDec.title }" src="${image }" style="height: 50px;width: 50px;"/>
    </li>
    </c:forEach>
</body>
</html>