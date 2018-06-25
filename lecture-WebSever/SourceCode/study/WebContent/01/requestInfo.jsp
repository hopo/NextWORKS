<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REQUEST INFO</title>
</head>

<body>
	<a href="<%=request.getContextPath()%>/">main gogo</a> <br>

	"Client Info" <br>
	request.getRemoteAddr: <%=request.getRemoteAddr()%> <br>
	request.getRemoteHost: <%=request.getRemoteHost()%> <br>
	request.getRemotePort: <%=request.getRemotePort()%> <br>
	request.getRemoteUser: <%=request.getRemoteUser()%> <br>
	request.getLocale: <%=request.getLocale() %> <br>
	<br><br>

	"Server Info" <br>
	request.getServerName: <%=request.getServerName()%> <br>
	request.getServerPort: <%=request.getServerPort()%> <br>
	request.getContextPath: <%=request.getContextPath()%> <br>
	request.getContentType: <%=request.getContentType()%> <br>
	request.getMethod: <%=request.getMethod() %> <br>
	request.getScheme: <%=request.getScheme()%> <br>
	request.getContentLength: <%=request.getContentLength()%> <br>
	<br><br>
	
	request.getProtocol: <%=request.getProtocol() %> <br>
	request.getSession: <%=request.getSession() %> <br>
	<br>
	
	request.getRequestURI: <%=request.getRequestURI() %> <br>
	request.getRequestURL: <%=request.getRequestURL() %> <br>
	<br><br>
	
	"Local Info" <br>
	request.getLocalAddr: <%=request.getLocalAddr() %> <br>
	request.getLocalName: <%=request.getLocalName() %> <br>
	request.getLocalPort: <%=request.getLocalPort() %> <br>
</body>
</html>