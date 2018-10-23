<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>二手市场主页</title>
<script src="${pageContext.request.contextPath}/js/plug/jquery.min.js"></script>
<script type="text/javascript">
function search_keys(formName){
	$('#'+formName).submit();
}
</script>
</head>
<body>
	用户名 ：    <a href="#">登出</a>
	<form action="http://localhost:8087/search.html" id="searchForm" name="query" method="GET">
        <input type="text" name="keyword" id="keyword" value="" style="color: rgb(153, 153, 153);" onkeydown="javascript:if(event.keyCode==13) search_keys('searchForm');">
        <button type="button" onclick="search_keys('searchForm')">搜索</button>
    </form>
	<br/>我是二手市场主页 
	<c:forEach items="${list16 }" var="content">
		<div>
			id ：${content.id }<br/>
			title ：${content.title }<br/>
			sub_title ：${content.subTitle }<br/>
			title_desc ：${content.titleDesc }<br/>
			url ：${content.url }<br/>
			pic ：<img alt="" src="${content.pic }"><br/>
			content ：${content.content }<br/>
		</div>
	</c:forEach>
</body>
</html>