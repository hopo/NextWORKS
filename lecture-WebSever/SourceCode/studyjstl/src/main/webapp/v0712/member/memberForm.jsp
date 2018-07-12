<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberForm.jsp</title>
<c:import url="/inc/headLib.jsp" />
</head>

<body>

	<!-- ;jsp:include 사용할 경우 -->
	<jsp:include page="/inc/menuBar.jsp" />

	<table class="table" border="3" style="border-color: black; width: 100%">
		<tr>
			<td height="250px" width="300px"><c:import url="/inc/menuLeft.jsp" /></td>
			<td>
				<!-- ========== 여기까지 HEADER + center 시작부분 조금========================= -->
				
				<h3>회원가입 화면</h3>
				
				<form action="<%=request.getContextPath()%>/member/memberProc.jsp" method="post">
					<table class="tableForm" border="3" style="border-color: pink;">
						<tr>
							<td>ID</td>
							<td><input type="text" name="memId" value="testId"></td>
						</tr>
						<tr>
							<td>PASSWORD</td>
							<td><input type="password" name="memPwd" value="1111"></td>
						</tr>
						<tr>
							<td>NAME</td>
							<td><input type="text" name="memName" value="testName"></td>
						</tr>
						<tr>
							<td>PHONE</td>
							<td><input type="text" name="memPhone" value="010-1111-1111"></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="email" name="memEmail" value="test@email.com"></td>
						</tr>
						<tr>
							<td colspan="2"><button type="submit">회원가입</button></td>
						</tr>
					</table>
				</form> <a href="<%=request.getContextPath()%>/session/loginForm.jsp">Cancel</a>
				<!-- ========== 여기부터 center부분 조금 + FOOTER ========================== -->
			</td>
		</tr>
	</table>

	<!-- ;c:import 사용할 경우 -->
	<c:import url="/inc/menuDown.jsp" charEncoding="utf-8" />
</body>
</html>