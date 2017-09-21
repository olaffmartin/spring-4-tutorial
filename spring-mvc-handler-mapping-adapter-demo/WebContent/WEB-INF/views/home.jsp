<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Organization Home Page</title>
</head>
<body>
	<h1>Organization Home Page</h1>
	<c:set var="contextPath" value= "${pageContext.request.contextPath}"></c:set>
	<ul>
		<li><a href="${contextPath}/jstlsql">List Organization using JSTL sql tags</a></li>
		<li><a href="${contextPath}/service">List Organization using Service</a></li>
	</ul>
</body>
</html>