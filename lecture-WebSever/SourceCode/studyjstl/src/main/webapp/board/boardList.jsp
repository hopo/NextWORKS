<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%@ page import="kr.or.nextit.board.service.*"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	// 리퀘스트로부터 BoardVo 리스트를 만들어온다
	BoardService board = new BoardServiceImpl();

	//List<BoardVo> boardItems = board.boardList(request); // ;;DAO 안사용
	List<BoardVo> boardItems = board.selectBoardList(request);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board/boardrList.jsp</title>
</head>
<body>
	<h3>게시팔 리스트</h3>

	<form action="<%=request.getContextPath()%>/board/boardList.jsp">
		<table class="table" border="3" style="border-color: pink;">
			<thead>
				<tr>
					<th colspan="7"><input name="findTitle" value="${findTitle}">
						<button type="submit">Search</button></th>
					<th><a href="<%=request.getContextPath()%>/board/boardInsertForm.jsp">글쓰기</a></th>
				</tr>
				<tr>
					<th>순번</th>
					<th>게시판타입</th>
					<th>제목</th>
					<th>등록자</th>
					<th>등록일</th>
					<th>수정일</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>

				<%
					// ;boardItems 출력
					for (BoardVo item : boardItems) {
				%>

				<tr>
					<td><a href='/#?idx=<%=item.getIdx()%>'><%=String.format("%s", item.getIdx())%></a></td>
					<td><%=item.getBoard_type()%></td>
					<td><a href='<%=request.getContextPath()%>/board/boardView.jsp?idx=<%=item.getIdx()%>'><%=item.getTitle()%></a></td>
					<td><%=item.getReg_user()%></td>
					<td><%=item.getReg_date()%></td>
					<td><%=item.getUp_date()%></td>
					<td><a href='<%=request.getContextPath()%>/board/boardUpdateForm.jsp?idx=<%=item.getIdx()%>'>수정하기</a></td>
					<td><a href='<%=request.getContextPath()%>/board/boardDeleteProc.jsp?idx=<%=item.getIdx()%>'>삭제하기</a></td>
				</tr>

				<%
					}
				%>

			</tbody>
		</table>
	</form>


	<br>
	<br>
	<a href="<%=request.getContextPath()%>/session/loginForm.jsp">session.loginForm.jsp</a>
	<br>
	<a href="<%=request.getContextPath()%>/index.jsp">GoIndex</a>
</body>
</html>
