<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberForm.jsp</title>
<style type="text/css">
#tableForm {
	position: absolute;
	border-color: tomato;
	top: 20%;
    left: 50%;
    -ms-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%)
}
</style>
</head>
<body>
	<h4>회원가입 화면</h4>
	<form action="<%=request.getContextPath()%>/member/memberProc.jsp" method="get">
		<table id="tableForm" border="3px">
			<tr>
				<td>ID</td>
				<td><input type="text" name="memId" value="testId"></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="memPwd" value="1234"></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input type="text" name="memName" value="testName"></td>
			</tr>
			<tr>
				<td>PHONE</td>
				<td><input type="text" name="memPhone" value="010-1111-1111"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="memEmail" value="test@email.com"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>

	<a href="<%=request.getContextPath()%>/session/loginForm.jsp">Cancel</a>

</body>
</html>