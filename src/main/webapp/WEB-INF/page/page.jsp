<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="w" uri="http://javacrazyer.zxd.com/tags/pager" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://secret.llh.me/tags/secret" prefix="s" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<h3>新闻列表</h3><hr/>  
<table>  
	<tr><td>userid</td><td>pwd</td></tr>   
	<c:forEach items="${users}" var="user">  
		<tr><td>${user.name}</td><td>${user.password}</td></tr>  
	</c:forEach>  
</table>  
<w:pager pageSize="${page.pageSize}" pageNo="${page.pageNo}" url="${page.url}" recordCount="${page.recordCount}"/>
<s:sec value="" type="mail" />
</body>
</html>