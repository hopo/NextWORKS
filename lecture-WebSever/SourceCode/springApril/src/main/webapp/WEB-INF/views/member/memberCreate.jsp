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
<title>memberCreate</title>
</head>

<body>
	<form class="form-signin" action="<c:url value="/member/memberCreateProc"/>">
		<table>
			<tbody>
				<tr>
					<th>MEM_ID</th>
					<td>
						<label for="inputMemId" class="sr-only">Member Id</label>
						<input name="memId" id="inputMemId" class="form-control" placeholder="Member Id" required autofocus>
					</td>
				</tr>
				<tr>
					<th>MEM_PWD</th>
					<td>
						<label for="inputPassword" class="sr-only">Password</label>
						<input type="password" name="memPwd" id="inputPassword" class="form-control" placeholder="Password" required>
					</td>
				</tr>
				<tr>
					<th>MEM_NAME</th>
					<td>
						<label for="inputMemName" class="sr-only">Member Name</label>
						<input name="memName" id="inputMemName" class="form-control" placeholder="Member Name" required>
					</td>
				</tr>
				<tr>
					<th>MEM_PHONE</th>
					<td>
						<label for="inputMemPhone" class="sr-only">Phone Number</label>
						<input name="memPhone" id="inputMemPhone" class="form-control" placeholder="Phone Number" required>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
					</td>
				</tr>
			</tbody>
		</table>
		취소. <a href="/">메인</a>으로 돌아가기
	</form>

</body>
</html>