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
<style type="text/css">
	body { background-image: url("/css/wall.jpg"); }
</style>

</head>

<body>

	<form class="form-signin" action="<c:url value="/session/loginProc"/>">
		<!-- <h2 class="form-signin-heading">Please Log In</h2> -->
		<label for="inputMemId" class="sr-only">Email address</label>
		<input name="memId" id="inputMemId" class="form-control" placeholder="Member Id" required autofocus>
		<label for="inputPassword" class="sr-only">Password</label>
		<input type="password" name="memPwd"  id="inputPassword" class="form-control" placeholder="Password" required>
		<div class="checkbox">
			<label>
				<input type="checkbox" value="remember-me"> Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
		회원 계정이 없다면, <a href="/member/memberCreate">가입하기</a>
	</form>
</body>
</html>