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
<!-- 0822 added -->
<!--
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title><sitemesh:write property='title' /></title>


<!-- nextit CSS -->
<link rel="stylesheet" href="<c:url value="/css/nextit.css"/>">

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="<c:url value="/css/bootstrap-theme.min.css"/>">


<!-- jquery 3.3.1 -->
<script src="<c:url value="/js/jquery-3.3.1.min.js"/>"></script>

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>

<!-- 0810fri 추가 : jquery form. json하면서 -->
<script src="<c:url value="/js/jquery.form.js"/>"></script>
<sitemesh:write property='head' />
</head>


<!-- http://wiki.sitemesh.org/wiki/display/sitemesh3/Getting+Started+with+SiteMesh+3 -->
<body>
	<c:import url="/decorator/inc/index.navigation.jsp" />

	<div class="container">
		<div class="blog-header">
			<h2 class="blog-title">
				<sitemesh:write property='title' />
			</h2>
			<p class="lead blog-description">)=ja바mang해ra=(</p>
		</div>
		<hr>
		<sitemesh:write property='body' />
		<hr>
	</div>
<!--
		<div class="col-sm-12 blog-main">
			<blockquote>
				<c:forEach var="item" items="${postItems}">
					${item.title}<br>
				</c:forEach>
			</blockquote>
		</div>
	</div>

	  -->
	<div class="row">
	<c:import url="/decorator/inc/index.footer.jsp" />
</body>
</html>
