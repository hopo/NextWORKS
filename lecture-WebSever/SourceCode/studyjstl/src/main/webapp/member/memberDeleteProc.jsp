<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page import="java.net.*"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>

<%@ page import="kr.or.nextit.nextit.member.service.*"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberUpdateProc.jsp</title>
</head>
<body>

	<%
		// ========================================================
		// 1.드라이버 로딩 준비
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver"); // ;import 오라클 드라이버

			// ========================================================
			// 2.연결설정
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");

			// ;query 작성 (INSERT)
			StringBuilder sql = new StringBuilder();

			sql.append(" DELETE tab_member ");
			sql.append(" WHERE mem_id = ? ");

			// ========================================================
			// 3.구문객체 생성
			pstmt = conn.prepareStatement(sql.toString());

			// paramas
			pstmt.setString(1, request.getParameter("memId"));

			// ========================================================
			// 4.구문객체 실행
			boolean result = pstmt.execute();

			if (result) {
				out.print(" Success!! ");
			} else {
				out.print(" Fail!! ");
			}

			out.println(sql.toString());

			response.sendRedirect(request.getContextPath() + "/member/memberList.jsp");

		} catch (SQLException ex) {
			out.println(ex.getMessage());
			ex.printStackTrace();

		} finally {
			// ========================================================
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

			// ========================================================
			// 7. db 연결 종료
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			}

		}
	%>

</body>
</html>
