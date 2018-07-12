<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UpdateForm</title>
</head>

<body>

<h4>회원정보 수정화면</h4>

<%
	String memId = request.getParameter("memId");
	String memName = "";
	String memPhone = "";
	String memEmail = "";

	// 1.드라이버 로딩
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {

		Class.forName("oracle.jdbc.driver.OracleDriver"); // ;import 오라클 드라이버

		// 2.연결설정
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");

		// ;query 작성
		String sql = " select * from TAB_member where mem_id = ? ";

		// 3.구문객체 생성
		pstmt = conn.prepareStatement(sql); // ;쿼리 객체 생성
		pstmt.setString(1, memId); // ;첫번째 물음표에 값을 입력

		// 4.구문객체 실행
		rs = pstmt.executeQuery(); // ;결과가 ResultSet에 담긴다

		// ;rs 출력
		while (rs.next()) {
			// ;; DB에서 가져온 데이터를 표시
			memName = rs.getString("mem_name");
			memPhone = rs.getString("mem_phone");
			memEmail = rs.getString("mem_email");
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

	<form action="<%=request.getContextPath()%>/member/memberUpdateProc.jsp" method="post">
		<table border="3px" style="border-color: green;">
			<tr>
				<td>ID</td>
				<td><input type="text" name="memId" value="<%=memId%>" readonly="readonly"></td>
			</tr>
<!-- 
			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="memPwd" value="1111"></td>
			</tr>
 -->
			<tr>
				<td>NAME</td>
				<td><input type="text" name="memName" value="<%=memName%>"></td>
			</tr>
			<tr>
				<td>PHONE</td>
				<td><input type="text" name="memPhone" value="<%=memPhone%>"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="memEmail" value="<%=memEmail%>"></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">수정</button></td>
			</tr>
		</table>
	</form>
	
	<br>
	<a href="<%=request.getContextPath()%>/session/loginForm.jsp">첫화면</a>

</body>
</html>