<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>viewForm.jsp</title>
</head>

<body>
	<a href="<%=request.getContextPath()%>/">GoMain</a>
	<form action="<%=request.getContextPath()%>/01/viewProc.jsp" method="get">
		<table>
			<tr>
				<td>정수를 입력 하세요</td>
				<td><input type="text" name="gu" id="gogogo" value="4"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>