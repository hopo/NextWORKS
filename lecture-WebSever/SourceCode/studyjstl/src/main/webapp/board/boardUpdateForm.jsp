<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
	request.setCharacterEncoding("utf-8");
%>

<%@ page import="kr.or.nextit.board.service.*" %>

<%
	BoardService board = new BoardServiceImpl();
	BoardVo item = board.selectBoardItem(request.getParameter("idx"));
	
	request.setAttribute("item", item); // el태그 사용을 위해
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardUpdateForm.jsp</title>
</head>
<body>
<h4>글수정 화면</h4>
	<form action="<%=request.getContextPath()%>/board/boardUpdateProc.jsp" method="post">
		<input type="hidden" name="idx" value="${item.idx}">
		<table border="3px">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="reg_user" value="${item.reg_user}"></td>
			</tr>
			<tr>
				<td>보드타입</td>
				<td><input type="text" name="board_type" value="${item.board_type}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${item.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="contents" rows="10" cols="50">[수정]${item.contents}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">글 수정</button></td>
			</tr>
		</table>
	</form>


	<br>
	<a href="<%=request.getContextPath()%>/index.jsp">GoIndex</a>
</body>
</html>
