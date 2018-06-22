<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/"><div>GoMain</div></a>

	<h3>current session information</h3>
	User Id =
	<%=request.getSession().getAttribute("userId")%>
	<br> User Is =
	<%=request.getSession().getAttribute("userIs")%>
	<br> User Info =
	<%=request.getSession().getAttribute("userInfo")%>
	<br> User Name =
	<%=request.getSession().getAttribute("userName")%>
	<h3>- - - - -</h3>

	<form action="<%=request.getContextPath()%>/02/sessionProc2.jsp"
		method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input name="id" type="text" maxlength="30" value="testId"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input name="pw" type="password" maxlength="150"
					value="1234Pw"></td>
			</tr>
			<tr>
				<td colspan="2" type="submit"><button>Log In</button></td>
				<td></td>
			</tr>
		</table>
	</form>

	request.getSession():
	<%=request.getSession()%>
	<br> request.getSession().getCreationTime():
	<%=request.getSession().getCreationTime()%>
	<br> request.getSession().getId():
	<%=request.getSession().getId()%>
	<br>
	<br> request.getSession().setAttribute(key, value)
	<%
		request.getSession().setAttribute("master", "KendrikLamar");
	%>
	<br>

	<%-- <a href="<%=request.getContextPath()%>/02/sessionProc.jsp"> <div>session Test</div> </a> --%>
	<br>
</body>
</html>