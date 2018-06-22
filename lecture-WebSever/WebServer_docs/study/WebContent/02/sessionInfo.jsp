<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sessionInfo.jsp</title>
</head>
<body>

	User Id =
	<%=request.getSession().getAttribute("userId")%> <br>
	User Is =
	<%=request.getSession().getAttribute("userIs")%> <br>
	User Info =
	<%=request.getSession().getAttribute("userInfo")%> <br>
	User Name =
	<%=request.getSession().getAttribute("userName")%> <br>

	<a href="<%=request.getContextPath()%>/02/sessionForm.jsp"><div>sessionForm</div></a>
</body>
</html>