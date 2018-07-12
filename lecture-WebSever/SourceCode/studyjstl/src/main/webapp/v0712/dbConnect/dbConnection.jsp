<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dbConnect/dbConnection.jsp</title>
</head>
<body>

	<%
		// 1.드라이버 로딩
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		long startTime = System.currentTimeMillis();

		try {
			
			String memId = request.getParameter("memId"); // ;;파라미터로 넘어온 값으로 db를 조회

			Class.forName("oracle.jdbc.driver.OracleDriver"); // ;import 오라클 드라이버

			// 2.연결설정
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");

			// ;query 작성
			String sql = " select * from TAB_member where mem_id = ? ";
			
			// 3.구문객체 생성
			pstmt = conn.prepareStatement(sql); // ;쿼리 객체 생성
			pstmt.setString(1, memId);	// ;첫번째 물음표에 값을 입력

			// 4.구문객체 실행
			rs = pstmt.executeQuery(); // ;결과가 ResultSet에 담긴다

			// ;rs 출력
			while (rs.next()) {
				out.println(rs.getString("mem_id") + " / ");
				out.println(rs.getString("mem_pwd") + " / ");
				out.println(rs.getString("mem_name") + " / ");
				out.println(rs.getString("mem_phone") + " <br> ");
			}

		} catch (SQLException ex) {
			out.println(ex.getMessage());
			ex.printStackTrace();

		} finally {
			// 6. 자원해제
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			}

			// 7. db 연결 종료
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			}

		}
	%>
	_껄린시간 :
	<%=System.currentTimeMillis() - startTime%>ms

</body>
</html>