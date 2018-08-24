<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>하나 커넥션에 30의 작업 테스트</h1>

	<%
		// 1. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		long stTime = System.currentTimeMillis();

		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "java", "oracle");

		for (int i = 0; i < 30; i++) {
			// 2. 커넥션 생성
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from tb_member where rownum = 1");
			if (rs.next()) {
				out.println(rs.getString("mem_name"));
			}

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		if (conn != null) {
			conn.close();
		}
		out.println("소요시간 = " + (System.currentTimeMillis() - stTime));
	%>


</body>
</html>