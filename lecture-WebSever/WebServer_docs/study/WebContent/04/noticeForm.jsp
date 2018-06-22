<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="kr.or.nextit.study.notice.service.*" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>noticeForm.jsp</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/"><div>GoMain</div></a>

	<form action="<%=request.getContextPath()%>/04/noticeProc.jsp" method="post" name="frm" id="frm">
		<table border="4" style="border-color: olive;">
			<tbody>
				<tr>
					<td>제목</td>
					<td><input name="title" type="text" value="testtitle"></td>
				</tr>
				<tr>
					<td>공개여부</td>
					<td>
						<%
							NoticeUtils util = new NoticeUtils();
						
							List<HashMap<String, Object>> isOpen = util.getIsOpenItems();
							for(HashMap<String, Object> item : isOpen) {
						%>
						
						<input name="isOpen" type="radio" value="<%=item.get("value")%>"><%=item.get("display")%>
						&nbsp; &nbsp; &nbsp;
						<% } %>
					</td>
				</tr>
				<tr>
					<td>공지사항종류</td>
					<td>
						<input name="serviceType" type="checkbox" value="101" checked> 메인
						&nbsp; &nbsp; &nbsp;
						<input name="serviceType" type="checkbox" value="202"> 팝업
						&nbsp; &nbsp; &nbsp;
						<input name="serviceType" type="checkbox" value="303"> 게시판
						&nbsp; &nbsp; &nbsp;
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>
						<select name="regUser">
							<option value="admin">오바마</option>
							<option value="webMaster">오라클</option>
							<option value="root">오까네</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea name="text" rows="5" cols="35">All work and no play makes Jack a dull boy</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">저장</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>