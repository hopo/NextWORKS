<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.nextit.study.*" %>

<%
	// ! context path
	String cPath = request.getContextPath(); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>gameForm.jsp</title>
</head>
<body>
	<a href="<%=cPath%>/">GoMain</a>

	<form action="<%=cPath%>/06/gameProc.jsp">
		<table>
			<tr>
				<td><input name="in1" type="number" maxlength="1" value="<%=RandomNum.gen()%>"></td>
				<td>*</td>
				<td><input name="in2" type="number" maxlength="1" value="<%=RandomNum.gen()%>"></td>
				<td>= ??</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="exec">
				</td>
			</tr>
		</table>
	</form>
	<a href="<%=request.getRequestURL()%>">reset</a>

</body>
</html>