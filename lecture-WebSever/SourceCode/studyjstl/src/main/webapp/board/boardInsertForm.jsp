<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardInsertForm.jsp</title>
</head>
<body>
<h4>글쓰기 화면</h4>
	<form action="<%=request.getContextPath()%>/board/boardInsertProc.jsp" method="post">
		<table border="3px">
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
	</form>


	<br>
	<a href="<%=request.getContextPath()%>/index.jsp">GoIndex</a>
</body>
</html>