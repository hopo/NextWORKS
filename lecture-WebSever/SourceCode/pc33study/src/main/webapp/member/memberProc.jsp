<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberProc</title>
</head>
<body>
	<c:url value="/member/memberForm.jsp" var="memberFormUrl" />

	<%
		request.setAttribute("mem_id", request.getParameter("mem_id"));
		request.setAttribute("mem_pwd", request.getParameter("mem_pwd"));
	%>

	"memberForm으로 부터 넘어 온 parameter"
	<br>
	<br> mem_id: ${mem_id}
	<br> mem_pwd: ${mem_pwd}
	<br>
	<a href="${memberFormUrl}">back</a>


</body>
</html>