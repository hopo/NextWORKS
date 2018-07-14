<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>home</title>
		<style type="text/css">
			#welcome {
				font-size: 2em;
			}
		</style>
	</head> 
	<body>
		<c:url value="/member/memberForm.jsp" var="memberFormUrl" />

		<div id="welcome">/pc33study/index.jsp</div>
		<hr>
		<a href="${memberFormUrl}">memberForm</a>
	</body>
</html>
