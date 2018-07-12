<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<%@ page import="kr.or.nextit.board.service.*"%>

<%
	BoardService board = new BoardServiceImpl();

	String idx = request.getParameter("idx");
	BoardVo item = board.deleteBoardItem(idx);

	request.setAttribute("item", item);

	String cPath = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardDeleteProc.jsp</title>
</head>
<body>
	<%response.sendRedirect(String.format("%s/board/boardList.jsp", cPath));%>

</body>
</html>