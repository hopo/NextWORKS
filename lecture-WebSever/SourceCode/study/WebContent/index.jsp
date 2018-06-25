<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WHO ARE YOU?</title>
</head>
<body>
	<h4>(( main page ))</h4>
	<h2>Hello World!</h2>

	<h3>/01</h3>
	<a href="<%=request.getContextPath()%>/01/testIndex.jsp">testIndex</a>
	<br>
	<a href="<%=request.getContextPath()%>/01/viewForm.jsp">viewForm</a>
	<br>
	<a href="<%=request.getContextPath()%>/01/requestInfo.jsp">requestInfo</a>
	<br>
	<a href="<%=request.getContextPath()%>/01/htmlForm.jsp">htmlForm</a>

	<h3>/02</h3>
	<a href="<%=request.getContextPath()%>/02/sessionForm.jsp">sessionForm</a>

	<h3>/03</h3>
	<a href="<%=request.getContextPath()%>/03/importForm.jsp">importForm</a>

	<h3>/04</h3>
	<a href="<%=request.getContextPath()%>/04/noticeForm.jsp">noticeForm</a>
</body>
</html>