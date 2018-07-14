<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>signupForm</title>
</head>
<body>
	<c:url value="/index.jsp" var="homeUrl" />
	<c:url value="/session/signupProc.jsp" var="signupProcUrl" />

	<a href="${homeUrl}">HOME</a>
	<hr>

	<div>"회원가입"</div>
	<form action="${signupProcUrl}" method="post">
		<table border="3px" style="border-color: gray;">
			<tr>
				<td>아이디</td>
				<td><input name="mem_id"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="mem_pwd" value="1111"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="mem_name" value="TestName"></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input name="mem_phone" value="000-000-0000"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="mem_email" value="test@email.com"></td>
			</tr>

			<tr>
				<td colspan="2"><button>Login</button></td>
			</tr>

		</table>
	</form>

</body>
</html>