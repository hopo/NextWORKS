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
<title>Log In</title>
</head>

<body>

		<form class="form-signin" action="<c:url value="/session/loginProc"/>">
			<!-- <h2 class="form-signin-heading">Please Log In</h2> -->
			<label for="inputMemId" class="sr-only">Email address</label>
			<input name="memId" id="inputMemId" class="form-control" placeholder="Member Id" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input name="memPwd" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
			<div class="checkbox">
				<label>
					<input type="checkbox" value="remember-me"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
			If you don't have account. <a href="/member/memberCreate">SignUp</a>
		</form>

	<%--
	<c:url var="loginProcUrl" value="/session/loginProc" />
	<form:form action="${loginProcUrl}" method="post">
		<table border="1px">
			<tbody>
				<tr>
					<th>MEM_ID</th>
					<td><input name="memId"></td>
				</tr>
				<tr>
					<th>MEM_PWD</th>
					<td><input name="memPwd" type="password"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">LOGIN</button>
					</td>
				</tr>

			</tbody>
		</table>
	</form:form>
	--%>
</body>
</html>