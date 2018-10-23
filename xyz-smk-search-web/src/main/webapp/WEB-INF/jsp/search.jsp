<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Cache-Control" content="max-age=300" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="${pageContext.request.contextPath}/js/plug/jquery.min.js"></script>
<title>二手市场-商品搜索</title>
<script type="text/javascript">
$(function () {
})

function search_keys(formName){
   $('#'+formName).submit();
}
</script>
</head>
<body>
	用户名 ：    <a href="#">登出</a><br/>
	<form action="http://localhost:8087/search.html" id="searchForm" name="query" method="get">
        <input type="text" name="keyword" id="keyword" value="${keyword }" style="color: rgb(153, 153, 153);" onkeydown="javascript:if(event.keyCode==13) search_keys('searchForm');">
        <button type="button" onclick="search_keys('searchForm')">搜索</button>
    </form><br/>
	<br/>商品搜索页面<br/>
	关键词为：${keyword }<br/>
	总页数：${totalPages }<br/>
	页数：${page }<br/>
	总记录数：${recourdCount }<br/>
	<c:forEach  items="${itemList }" var="sItem">
		<div style="float: left;height: 300px;width: 300px;margin-left: 50px;">
			商品id：${sItem.id }
			商品名称：${sItem.title }
			类别：${sItem.cname }
			<br/>买点：${sItem.sellPoint }
			数量：${sItem.num }
			价格：${sItem.price }
			图片：<img src="${sItem.image }" style="height: 50px;width: 50px;" /><br/>
			联系电话：${sItem.contactInfo }
			地址:${sItem.location }
		</div>
	</c:forEach>
	
	
	
</body>
</html>