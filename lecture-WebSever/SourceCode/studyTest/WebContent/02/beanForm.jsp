<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>02/beanForm.jsp</title>
</head>

<body>
	<form action="<%=request.getContextPath()%>/02/beanProc.jsp" method="post">
		<table border="7" style="border-color: orange;">
			<tr>
				<td>제목</td>
				<td><input name="title" type="text" maxlength="250" value="This is JSP!"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input name="regUser" type="text" maxlength="150" readonly="readonly" value="박지성"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="20" cols="50">지송빠르끄~지송빠르끄으으~~</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">등록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>