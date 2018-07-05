<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ page import="kr.or.nextit.study.member.service.*" %>

<%
	// ! set character encoding
	request.setCharacterEncoding("UTF-8");

	// ! get parameter
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String isAdmin = request.getParameter("isAdmin");

	// ! set attribute at session. using "SessionVo"
	SessionVo params = new SessionVo();

	params.setId(id);
	params.setPw(pw);
	params.setIsAdmin(isAdmin);
	params.setLogin(true);
	
	request.getSession().setAttribute("info", params);

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sessionProc.jsp</title>
</head>
<body>

	<%
		out.print(params.getId());
		out.print("<br>");
		out.print(params.getPw());
		out.print("<br>");
		out.print(params.getIsAdmin());
		out.print("<br>");
	%>

	<jsp:include page="/05/common.jsp"></jsp:include>

</body>
</html>