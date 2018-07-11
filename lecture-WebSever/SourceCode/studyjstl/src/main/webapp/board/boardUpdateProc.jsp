<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<%@ page import="kr.or.nextit.board.service.*"%>

<%
	BoardService board = new BoardServiceImpl();

	board.updateBoardItem(request); // serviceImpl에서 setAttribute 하였음
	
	String cPath = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardUpdateForm.jsp</title>
</head>
<body>

	${item.message}
	
	<table>
		<tr>
			<td><a href="<%=cPath%>/board/boardList.jsp">목록</a></td>
			<td><a href="<%=cPath%>/board/boardList.jsp?idx=${item.idx}">보기</a></td>
			<td><a href="<%=cPath%>/board/boardUpdateForm.jsp?idx=${item.idx}">수정</a></td>
		</tr>
	</table>

</body>
</html>