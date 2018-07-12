<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.nextit.board.service.*"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<%
	BoardService board = new BoardServiceImpl();
	BoardVo item = board.selectBoardItem(request.getParameter("idx"));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=item.getTitle()%></title>
</head>
<body>
	<table border="5" style="border-color: blue">
		<tr>
			<td>작성자</td>
			<td><%=item.getReg_user()%></td>
		</tr>
		<tr>
			<td>보드종류</td>
			<td><%=item.getBoard_type()%></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><%=item.getTitle()%></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><%=item.getContents()%></td>
		</tr>
		<tr>
			<td>등록일</td>
			<td><%=item.getReg_date()%></td>
		</tr>
		<tr>
			<td>수정일</td>
			<td><%=item.getUp_date()%></td>
		</tr>
		<tr>
			<td colspan='2' style="text-align: center;">
			<a href="<%=request.getContextPath()%>/board/boardList.jsp?">리스트</a>&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/board/boardUpdateForm.jsp?idx=<%=item.getIdx()%>">수정</a>&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/board/boardDeleteProc.jsp?idx=<%=item.getIdx()%>">삭제</a>&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</body>
</html>