<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h3>[[[ /studyjstl/index.jsp ]]]</h3>
		<c:url value="/session/loginForm.jsp" var="loginForm" />
		<a href="${loginForm}">/session/loginForm.jsp</a>
		<br>
		<c:url value="/board/boardList.jsp" var="boardList" />
		<a href="${boardList}">/board/boardList.jsp</a>
	</body>
</html>
