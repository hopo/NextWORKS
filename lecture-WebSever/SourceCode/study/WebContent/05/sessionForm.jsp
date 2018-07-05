<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.nextit.study.member.service.*" %>

<%
	// ! character encoding
	request.setCharacterEncoding("UTF-8");

	// ! session variables
	SessionVo sessionInfo = (SessionVo) request.getSession().getAttribute("info");
	
	out.print("sessionInfo: ");
	out.print(sessionInfo);
	out.print("<br><br>");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="<%=request.getContextPath()%>/">GoMain</a>
	<br>
	
	<form action="<%=request.getContextPath()%>/05/sessionProc.jsp" method="post">
		<table>
			<tr>
				<td>ID(text)</td>
				<td><input name="id" type="text" maxlength="50" value=""></td>
			</tr>
			<tr>
				<td>PW(password)</td>
				<td><input name="pw" type="password" maxlength="150" value=""></td>
			</tr>
			<tr>
				<td>ADMIN(radio)</td>
				<td>
					<input name="isAdmin" type="radio" value="master">Master
					<input name="isAdmin" type="radio" value="user" checked>User
				</td>
			</tr>
			
			<% if (sessionInfo == null) { %>
			<tr>
				<td colspan="2">
					<button type="submit">LogIn</button>
				</td>
			</tr>
			<% } else { %>
			<tr>
				<td colspan="2">
					<a href="<%=request.getContextPath()%>/05/sessionLogout.jsp">LogOut</a>
				</td>
			</tr>
			<% } %>
		</table>
	</form>

	<jsp:include page="/05/common.jsp"></jsp:include>
</body>
</html>