<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	request.setCharacterEncoding("UTF-8");
	String cPath = request.getContextPath();
%>

<c:if test="${memberInfo == null}">
	<%
		response.sendRedirect(String.format("%s/", cPath));
	%>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member/memberList.jsp</title>
<c:import url="/inc/headLib.jsp" />
</head>
<body>

	<!-- ;jsp:include 사용할 경우 -->
	<jsp:include page="/inc/menuBar.jsp" />

	<table class="table" border="3" style="border-color: black; width: 100%">
		<tr>
			<td height="250px" width="300px"><c:import url="/inc/menuLeft.jsp" /></td>
			<td>
	<!-- ========== 여기까지 HEADER + center 시작부분 조금========================= -->
	
	<h3>Member리스트 출력</h3>

	<%
	
		// 1.드라이버 로딩
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		long startTime = System.currentTimeMillis();

		try {

			String memId = request.getParameter("memId"); // ;;파라미터로 넘어온 값으로 db를 조회
			String findId = request.getParameter("findId");	

			Class.forName("oracle.jdbc.driver.OracleDriver"); // ;import 오라클 드라이버

			// 2.연결설정
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");

			// ;query 작성
			// String sql = " SELECT mem_id, mem_name, mem_phone, mem_email, reg_date, mem_ip  FROM tab_member ORDER BY reg_date ASC ";
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT ");
			sql.append(" 	mem_id, mem_name, mem_phone, mem_email, reg_date, mem_ip ");
			sql.append(" FROM ");
			sql.append(" 	tab_member ");
			sql.append(" WHERE ");
			sql.append(" 	del_at = 'Y' ");
			sql.append(" AND ");
			sql.append(" 	mem_id LIKE '%' || ? || '%' "); // ;;sql에서 문자열 더하기가 포인트
			sql.append(" ORDER BY ");
			sql.append(" 	reg_date ");
			sql.append(" ASC  ");

			// 3.구문객체 생성
			pstmt = conn.prepareStatement(sql.toString()); // ;쿼리 객체 생성
			pstmt.setString(1, findId);

			// 4.구문객체 실행
			rs = pstmt.executeQuery(); // ;결과가 ResultSet에 담긴다
	%>

	<form action="<%=request.getContextPath()%>/member/memberList.jsp">
	<table class="table" border="3" style="border-color: red;">
		<thead>
			<tr>
				<th colspan="7">
					<input name="findId" value="<%=(findId != null ? findId : "")%>" >
					<button type="submit">search</button>
				</th>
				<th><a href="<%=request.getContextPath()%>/member/memberForm.jsp">회원등록</a></th>
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
				<td><a href='/member/memberUpdateForm.jsp?memId=<%=rs.getString("mem_id")%>'><%=rs.getString("mem_id")%></a></td>
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
	</form>

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
	
	<br>
	_껄린시간 :
	<%=System.currentTimeMillis() - startTime%>ms

	<!-- ========== 여기부터 center부분 조금 + FOOTER ========================== -->
			</td>
		</tr>
	</table>

	<!-- ;c:import 사용할 경우 -->
	<c:import url="/inc/menuDown.jsp" charEncoding="utf-8" />

</body>
</html>
