<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/"><div>GoMain</div></a>
	<br>

	<%
		String masterValue = (String) request.getSession().getAttribute("master");

		String p_id = request.getParameter("id");
		String p_pw = request.getParameter("pw");

		request.getSession().setAttribute("userId", p_id);
		request.getSession().setAttribute("userIs", true);
		request.getSession().setAttribute("userInfo", "관리자");
		request.getSession().setAttribute("userName", String.format("이름(%s)",p_id));
	%>


	session param(global):
	<%=masterValue%>
	<br> request param:
	<%=request.getParameter("master")%>
	<br>


	request param id: <%=p_id%>
	request param pw: <%=p_pw%>
	<br>
	<br>

	<a href="<%=request.getContextPath()%>/02/sessionInfo.jsp"><div>sessionInfo</div></a>
	<a href="<%=request.getContextPath()%>/02/sessionForm.jsp"><div>sessionForm</div></a>
	<a href="<%=request.getContextPath()%>/02/sessionRemove.jsp"><div>sessionRemove</div></a>

</body>
</html>