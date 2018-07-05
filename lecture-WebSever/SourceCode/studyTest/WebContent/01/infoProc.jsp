<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.nextit.info.service.*"%>

<%
	request.setCharacterEncoding("UTF-8");

	String cPath = request.getContextPath();
%>

<%
	// ; request 데이터를 InfoVo obj에 담기
	InfoService isrv = new InfoServiceImpl();
	InfoVo iv = isrv.setInformation(request);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>infoProc.jsp</title>
</head>
<body>

	<h4>정보 출력 부분</h4>
	<table>
		<tr>
			<td>이름</td>
			<td><%=iv.getUsername()%></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=iv.getEmail()%></td>
		</tr>
		<tr>
			<td>성인여부</td>
			<td><%=InfoUtils.dispAdult(iv.getAdult())%></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%=InfoUtils.dispGender(iv.getGender())%></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><%=InfoUtils.dispBirth(iv.getByear(), iv.getBmonth(), iv.getBday())%></td>
		</tr>
		<tr>
			<td>취미</td>
			<td><%=InfoUtils.dispHobs(iv.getHobs())%></td>
		</tr>
	</table>

	<br>
	<a href="<%=cPath%>/01/infoForm.jsp">Back</a>
</body>
</html>