<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.nextit.study.member.service.*"%>

<%
	// ! character encoding
	request.setCharacterEncoding("UTF-8");

	// ! SessionVo variable 
	SessionVo info = (SessionVo) request.getSession().getAttribute("info");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardForm.jsp</title>
</head>
<body>
	<% if (info != null) { %>

	<form action="<%=request.getContextPath()%>/05/boardProc.jsp" method="post">
		<table border="3" style="border-color: red;">
			<tr>
				<td>TITLE</td>
				<td><input name="title" type="text" maxlength="250"></td>
			</tr>
			<tr>
				<td>REG_USER</td>
				<td><input name="regUser" type="text" maxlength="150" readonly="readonly" value="<%=info.getId()%>"></td>
			</tr>
			<tr>
				<td>CONTENTS</td>
				<td><textarea name="content" rows="20" cols="50"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">Submit</button>
				</td>
			</tr>
		</table>
	</form>

	<% } else { %>

	<div>로그인하세요</div>
	<a href="<%=request.getContextPath()%>/05/sessionForm.jsp">Go-sessionForm</a>

	<% } %>
	
	<jsp:include page="/05/common.jsp"></jsp:include>

</body>
</html>