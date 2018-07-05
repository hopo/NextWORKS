<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.nextit.session.service.*"%>

<%
	request.setCharacterEncoding("UTF-8");

	String cPath = request.getContextPath();

	// ! service obj
	SessionService sinfo = new SessionServiceImpl();

	// ! VO
	SessionVo se = sinfo.setSessionInfo(request);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>indexProc.jsp</title>

<jsp:include page="/common.jsp">
	<jsp:param value="lib.proc" name="head"/>
</jsp:include>

</head>
<body>
	<%=se.getId()%><br>
	<%=se.getPw()%><br>
	<%=se.getMessage()%><br>
	<%=se.isResult()%><br>
	<%=se.getSessionId()%><br>
	<%=se.getIp()%><br>

	<a href="<%=cPath%>/index.jsp">Back</a>
	<br>
	<a href="<%=cPath%>/boardForm.jsp">boardForm</a>
</body>
</html>