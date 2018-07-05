<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.nextit.study.board.service.*"%>

<%
	// ! set character encoding
	request.setCharacterEncoding("UTF-8");

	BoardService board = new BoardServiceImpl();
	
	BoardVo	boardVo = board.setBoardItem(request);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardProc.jsp</title>
</head>
<body>
	<%=boardVo.getTitle()%><br>
	<%=boardVo.getContent()%><br>	
	<%=boardVo.getRegUser()%><br>	
	
	<br>
	
	<%=boardVo.isResult()%><br>	
	<%=boardVo.getMessage()%><br> 

	<jsp:include page="/05/common.jsp"></jsp:include>
</body>
</html>