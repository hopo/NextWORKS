<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	String cPath = request.getContextPath();
%>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
<c:import url="/inc/headLib.jsp" />
</head>

<body>

<pre>
	${title}
	${name}
	"codeSex" : ${codeSex}
</pre>

	<!-- HEADER -->
	<!-- ;jsp:include 사용할 경우 -->
	<jsp:include page="/inc/menuBar.jsp" />
	<!-- Center Table -->
	<table class="table" border="3" style="border-color: black; width: 100%">
		<tr>
			<td height="250px" width="300px"><c:import url="/inc/menuLeft.jsp" /></td>
			<td>
				<!-- *** 센터 테이블 우측(내용) 들어갈 부분 *** -->
			</td>
		</tr>
	</table>

	<!-- FOOTER -->
	<!-- ;c:import 사용할 경우 -->
	<c:import url="/inc/menuDown.jsp" charEncoding="utf-8" />

	<!-- 
		<c:url value="/session/loginForm.jsp" var="loginForm" />
		<a href="${loginForm}">/session/loginForm.jsp</a>
		<br>
		<c:url value="/board/boardList.jsp" var="boardList" />
		<a href="${boardList}">/board/boardList.jsp</a>
 	-->
</body>
</html>
