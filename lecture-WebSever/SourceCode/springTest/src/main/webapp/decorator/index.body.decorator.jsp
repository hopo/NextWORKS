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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>
	<sitemesh:write property='title' />
</title>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="<c:url value="/css/bootstrap-theme.min.css"/>">
<!-- jquery 3.3.1 -->
<script src="<c:url value="/js/jquery-3.3.1.min.js"/>"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>

<sitemesh:write property='head' />
</head>

<body>
	<%-- <c:import url="/decorator/inc/index.navigation.jsp" /> --%>
	<sitemesh:write property='body' />
	<%-- <c:import url="/decorator/inc/index.footer.jsp" /> --%>
</body>
</html>
