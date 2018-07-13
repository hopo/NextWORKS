<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.net.*"%>

<%@ page import="kr.or.nextit.comm.utils.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<%
	CookieBox co = new CookieBox(request);
	String idSave = "";
	String idCheck = "";

	if (co.exist("idSave")) {
		idSave = co.getValue("idSave");
		idCheck = "checked=\"checked\"";
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>loginForm.jsp</title>
<c:import url="/inc/headLib.jsp" />

</head>
<body>

	<!-- ;jsp:include 사용할 경우 -->
	<jsp:include page="/inc/menuBar.jsp" />
	<!-- Center Table -->
	<table class="table" border="3" style="border-color: black; width: 100%">
		<tr>
			<td height="250px" width="300px"><c:import url="/inc/menuLeft.jsp" /></td>
			<td>
				<!-- ---------- center 테이블 우측(내용) 영역 시작 ------------------------- -->
				<h3>로그인 화면</h3> <c:if test="${meberInfo == null}">
					<form action="<%=request.getContextPath()%>/session/loginProc.jsp" method="post">
						<table border="3px">
							<tr>
								<td>ID</td>
								<td><input type="text" name="id" value="<%=idSave%>"></td>
							</tr>
							<tr>
								<td>PW</td>
								<td><input type="password" name="pw" value=""></td>
							</tr>
							<tr>
								<td>저장여부</td>
								<td><input type="checkbox" name="idSave" value="Y" <%=idCheck%>></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="LogIn"></td>
							</tr>
						</table>
					</form>

					<!-- !가입은 접속자가 없을 때.  -->
					<br>
					<a href="<%=request.getContextPath()%>/member/memberForm.jsp">가입하기</a>
				</c:if> <!-- ---------- center 테이블 우측(내용) 영역 끝 ------------------------- -->
			</td>
		</tr>
	</table>

	<!-- ;c:import 사용할 경우 -->
	<c:import url="/inc/menuDown.jsp" charEncoding="utf-8" />
</body>
</html>