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
	%>


	session param(global):
	<%-- <%=request.getSession().getAttribute("master")%> --%>
	<%=masterValue%>
	<br> request param:
	<%=request.getParameter("master")%>
	<br>


	<br> request param id:
	<%=p_id%>
	<br> request param pw:
	<%=p_pw%>
	<br>
	<br>


	<%
		if ("testId".equals(p_id)) {
			out.print("1.1 등록된 아이디.");
			if ("1234Pw".equals(p_pw)) {
				out.print("2.1 정상 로그인 되었다.");
				// ;세션 등록
				request.getSession().setAttribute("userId", p_id);
				request.getSession().setAttribute("userIs", true);
				request.getSession().setAttribute("userInfo", "관리자");
				request.getSession().setAttribute("userName", String.format("관리자(%s)", p_id));
			} else {
				out.print("2.2 정상 로그인 NOT되었다.");
			}
		} else {
			out.print("1.2 등록된 아이디 NOT다.");
		}
	%>
	<br>
	<br>

	<a href="<%=request.getContextPath()%>/02/sessionInfo.jsp"><div>sessionInfo</div></a>
	<a href="<%=request.getContextPath()%>/02/sessionForm.jsp"><div>다시-로그인</div></a>

</body>
</html>