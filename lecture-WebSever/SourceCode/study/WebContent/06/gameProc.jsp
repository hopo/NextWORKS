<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// ! character encoding
	request.setCharacterEncoding("UTF-8");

	// ! context path
	String cPath = request.getContextPath();

	// ! get parameter
	Integer in1 = new Integer(request.getParameter("in1"));
	Integer in2 = new Integer(request.getParameter("in2"));
	
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>gameProc.jsp</title>
</head>
<body>
	<%=String.format("[gameProc] %d * %d = %d", in1, in2, in1*in2)%>
	<br>
	<a href="<%=cPath%>/06/gameForm.jsp">Back</a>
</body>
</html>