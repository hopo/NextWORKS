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
<title>member/memberList.jsp</title>
</head>
<body>
	<h3>Member리스트 출력</h3>

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
			// String sql = " SELECT mem_id, mem_name, mem_phone, mem_email, reg_date, mem_ip  FROM tab_member ORDER BY reg_date ASC ";
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT ");
			sql.append(" mem_id, mem_name, mem_phone, mem_email, reg_date, mem_ip ");
			sql.append(" FROM tab_member ");
			sql.append(" ORDER BY reg_date ");
			sql.append(" ASC  ");

			// 3.구문객체 생성
			pstmt = conn.prepareStatement(sql.toString()); // ;쿼리 객체 생성

			// 4.구문객체 실행
			rs = pstmt.executeQuery(); // ;결과가 ResultSet에 담긴다
	%>

	<table class="table" border="3" style="border-color: red;">
		<thead>
			<tr>
				<th colspan="7"></th>
				<th><a href="<%=request.getContextPath()%>/member/memberForm.jsp">뢰원등록</a></th>
			</tr>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>폰번호</th>
				<th>이메일</th>
				<th>등록일</th>
				<th>접속아이피</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>

			<%
				// ;rs 출력
					out.println(sql.toString());
					while (rs.next()) {
			%>

			<tr>
				<td><%=rs.getString("mem_id")%></td>
				<td><%=rs.getString("mem_name")%></td>
				<td><%=rs.getString("mem_phone")%></td>
				<td><%=rs.getString("mem_email")%></td>
				<td><%=rs.getString("reg_date")%></td>
				<td><%=rs.getString("mem_ip")%></td>
				<td><a href='/member/memberUpdateForm.jsp?memId=<%=rs.getString("mem_id")%>'>수정하기</a></td>
 				<td><a href='/member/memberDeleteProc.jsp?memId=<%=rs.getString("mem_id")%>'>삭제하기</a></td>
			</tr>

			<%
				}
			%>

		</tbody>
	</table>

	<%
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

	<br>
	<a href="<%=request.getContextPath()%>/session/loginForm.jsp">첫화면</a>

</body>
</html>
