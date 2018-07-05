<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
	// ! character encoding
	request.setCharacterEncoding("UTF-8");

	// ! sesstion value invalidate
	request.getSession().invalidate();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LogOut</title>
</head>
<body>
	<div>LogOut Success</div>

	<jsp:include page="/05/common.jsp"></jsp:include>
</body>
</html>