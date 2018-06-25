<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Start Study</title>
</head>

<body>
	<a href="<%=request.getContextPath()%>/">main gogo</a> <br>

	<h2>Start Study....</h2>

	<%
		String name = "Hillary Clinton";
	%>
	<br>
	<br>

	<%=name%>
	<br>
	<br>

	<%
		out.println(name);
	%>
	<br>
	<br>

	<%!private String getName(String target) {
		return String.format("Trumph = %s", target);
	}%>

	<%=getName("Stupid")%>
	<!-- Trumph = Stupid  -->
	<br>
	<br>

	<!-- 문자열 배열 포문으로 출력 -->
	<%
		String[] StringValue = { "문", "자", "열" };
		for (String s : StringValue) {
			out.print(s + "&nbsp;");
		}
		out.println("<br>");
	%>

	<!-- 구단 출력 -->
	<%!private String getGuGu(int i, int j) {
		return String.format("%d x %d = %d <br>", i, j, i * j);
	}%>

	<%
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				out.println(getGuGu(i, j));
			}
		}
	%>

</body>
</html>