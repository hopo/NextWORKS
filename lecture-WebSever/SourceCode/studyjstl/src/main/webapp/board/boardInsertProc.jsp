<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.nextit.board.service.*"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<%
	BoardService board = new BoardServiceImpl();
	BoardVo result = board.insertBoardItem(request);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardInsertProc.jsp</title>
</head>
<body>
	<%=result.getMessage()%>

	<%
		String location = request.getContextPath();
		response.sendRedirect(String.format("%s/board/boardList.jsp", location));
	%>
</body>
</html>