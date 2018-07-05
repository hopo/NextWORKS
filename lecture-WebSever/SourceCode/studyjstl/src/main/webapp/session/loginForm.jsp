<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.net.*"%>

<%@ page import="kr.or.nextit.comm.utils.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<%
	CookieBox co = new CookieBox(request);
	String idSave = "";
	String idCheck = "";

	if (co.exist("idSave")) {
		idSave = co.getValue("idSave");
		idCheck = "checked=\"checked\"";
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginForm.jsp</title>
</head>
<body>

	<c:if test="${meberInfo == null}">
		<form action="<%=request.getContextPath()%>/session/loginProc.jsp" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" value="<%=idSave%>"></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="pw" value=""></td>
				</tr>
				<tr>
					<td>저장여부</td>
					<td><input type="checkbox" name="idSave" value="Y" <%=idCheck%>></td>
				</tr>
				<tr colspan="2">
					<td><input type="submit" value="LogIn"></td>
				</tr>
			</table>
		</form>
		
		<a href="<%=request.getContextPath()%>/member/memberForm.jsp">SignUp</a>

	</c:if>


	<h4> ))접속자(( </h4>
	<%-- <c:if test="${meberInfo != null}"> --%>
	<c:out value="${memberInfo.memId }" />
	<br>
	<a href="<%=request.getContextPath()%>/session/logOutProc.jsp">LogOut</a>
	<%-- </c:if> --%>
	
	
</body>
</html>