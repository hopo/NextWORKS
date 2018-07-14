<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberForm</title>
</head>
<body>
	<c:url value="/index.jsp" var="homeUrl" />
	<c:url value="/member/memberProc.jsp" var="memberProcUrl" />
	<c:url value="/member/memberList.jsp" var="memberListUrl" />
	<c:url value="/session/signupForm.jsp" var="signupFormUrl" />

	<a href="${homeUrl}">HOME</a>
	<hr>
	
	<div>"회원로그인"</div>
	<form action="${memberProcUrl}" method="post">
		<table border="3px" style="border-color: black;">
			<tr>
				<td>아이디</td>
				<td><input name="mem_id"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="mem_pwd" value="1111"></td>
			</tr>

			<tr>
				<td colspan="2"><button>Login</button></td>
			</tr>

		</table>
	</form>
	
	<a href="${signupFormUrl}">가입하기</a>
	<br>
	<a href="${memberListUrl}">멤버보기(운영자용)</a>
</body>
</html>