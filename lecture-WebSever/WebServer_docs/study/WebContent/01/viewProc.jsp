<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터 수신</title>
</head>

<body>
	<a href="<%=request.getContextPath()%>/">main gogo</a>
	<br>

	<%
		int su = Integer.parseInt(request.getParameter("gu"));
	%>

	<!-- 구구단 출력 -->
	<%!
		private String getGuGu(int i, int j) {
			return String.format("%d x %d = %d <br>", i, j, i * j);
		}
	%>

	<%
		for (int j = 1; j <= 9; j++) {
			out.println(getGuGu(su, j));
		}
	%>

	<script type="text/javascript">
		alert("su: " + <%=su%>);
	</script>
</body>
</html>