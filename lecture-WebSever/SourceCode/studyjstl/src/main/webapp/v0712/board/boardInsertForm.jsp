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
<title>boardInsertForm.jsp</title>
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

				<h3>글쓰기 화면</h3>

				<form action="<%=request.getContextPath()%>/board/boardInsertProc.jsp" method="post">
					<table border="3px" style="border-color: cyan;">
						<tr>
							<td>작성자</td>
							<td><input type="text" name="reg_user" value=""></td>
						</tr>
						<tr>
							<td>보드타입</td>
							<td><input type="text" name="board_type" value="공지사항"></td>
						</tr>
						<tr>
							<td>제목</td>
							<td><input type="text" name="title" value=""></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea name="contents" rows="10" cols="50"></textarea></td>
						</tr>
						<tr>
							<td colspan="2"><button type="submit">글 등록</button></td>
						</tr>
					</table>
				</form> <!-- ========== 여기부터 center부분 조금 + FOOTER ========================== -->
			</td>
		</tr>
	</table>

	<!-- ;c:import 사용할 경우 -->
	<c:import url="/inc/menuDown.jsp" charEncoding="utf-8" />
</body>
</html>