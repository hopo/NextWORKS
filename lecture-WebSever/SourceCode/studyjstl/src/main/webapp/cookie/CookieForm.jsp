<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.net.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CookieForm.jsp</title>
</head>

<body>

	<%
		// ! request로 부터 쿠키 가져오기
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cok : cookies) {
				out.println("getName() : " + cok.getName() + " <br> ");
				out.println("getValue() : " + cok.getValue() + " <br> ");
				out.println("URLDecoder.decode(cok.getValue(), \"utf-8\" ) : " + URLDecoder.decode(cok.getValue(), "utf-8") + " <br> "); //; 인코딩&디코딩!
				
				out.println("getComment() : " + cok.getComment() + " <br> ");
				out.println("getDomain() : " + cok.getDomain() + " <br> ");
				out.println("getMaxAge() : " + cok.getMaxAge() + " <br> ");
				out.println("getPath() : " + cok.getPath() + " <br> ");
				out.println("getVersion() : " + cok.getVersion() + " <br> ");
				out.println("getSecure() : " + cok.getSecure() + " <br> ");
				out.println("================================= <br> ");
			}
		}
	%>

	<br>	
	<a href="<%=request.getContextPath()%>/cookie/CookieCreate.jsp">CookieCreate</a>

</body>
</html>