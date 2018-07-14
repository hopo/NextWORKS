<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>signupProc</title>
</head>
<body>
	<c:url value="/session/signupForm.jsp" var="signupFormUrl" />

	<%
		request.setAttribute("mem_id", request.getParameter("mem_id"));
		request.setAttribute("mem_pwd", request.getParameter("mem_pwd"));
		request.setAttribute("mem_name", request.getParameter("mem_name"));
		request.setAttribute("mem_phone", request.getParameter("mem_phone"));
		request.setAttribute("mem_email", request.getParameter("mem_email"));
	%>

	"signupForm으로 부터 넘어 온 parameter"
	<br>
	<br> mem_id: ${mem_id}
	<br> mem_pwd: ${mem_pwd}
	<br> mem_name: ${mem_name}
	<br> mem_phone: ${mem_phone}
	<br> mem_email: ${mem_email}
	<br>

	<a href="${signupFormUrl}">back</a>
</body>
</html>