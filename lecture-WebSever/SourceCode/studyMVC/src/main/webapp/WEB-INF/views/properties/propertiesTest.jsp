<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>properties Test (다국어 처리)</title>
</head>

<body>
	<pre>
		<!-- // ;from properties file on jsp -->
		<spring:message code="TITLE" />
		<br>
		<spring:message code="ID" />
		<br>
		<spring:message code="NAME" />
		<br>
		<%-- <spring:message code="NAMES" text="누락된 키값" /> --%>
		인자값이 있을 경우: <spring:message code="VISITOR" arguments="G-Dragon,Gunbary" />
	</pre>
</body>
</html>