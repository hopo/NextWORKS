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

<!--  
	// 1.memberForm으로부터 받아온 parameter 값 id가 DB에 중복된 id가 있는지 확인.
	// 2.데이터베이스에 중복 memId가 없으면 
	// 3.MemberVo에 파라미터 값들을 담고
	// 4.TAB_MEMEBER 테이블에 추가 할것이다. DAO객체를 insert into 부분 이용하여 데이터베이스에 튜플 추가
	// 5. 서버 세션에 저장
	// 아이디 체크 및 테이블에 추가하니깐 db와 접속을 끊고 재접 하게되니, pool을 이용하면 좋지 않을까 생각.
	// 또는, 한번의 접속으로 되도록 할 수 있는 일을 처리한다.
-->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberProc.jsp</title>
</head>
<body>
	<%
		// ========================================================
		// 1.드라이버 로딩 준비
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String p_id = request.getParameter("memId"); // ;;파라미터로 넘어온 값으로 db를 조회

			Class.forName("oracle.jdbc.driver.OracleDriver"); // ;import 오라클 드라이버

			// ========================================================
			// 2.연결설정
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");

			// ;query 작성
			String sql = " select * from TAB_member where mem_id = ?";

			// ========================================================
			// 3.구문객체 생성
			pstmt = conn.prepareStatement(sql); // ;쿼리 객체 생성
			pstmt.setString(1, p_id); // ;첫번째 물음표에 값을 입력

			// ========================================================
			// 4.구문객체 실행
			rs = pstmt.executeQuery(); // ;결과가 ResultSet에 담긴다

			if (rs.next()) {
			%>

				등록하려던 아이디가 중복입니다.<br>
				<a href="<%=request.getContextPath()%>/member/memberForm.jsp">가입화면으로 돌아가기</a>
				
			<% } else {%>
				<!-- ===================================데이터베이스 인서트================================================== -->
				노중복 진행~~

				<!-- ======================================================================================================= -->
			<%  }

			/*
			MemberVo memberInfo = null;
			// ;rs 출력 (memberVo obj에 담기)
			if (rs.next()) {
				// Login성공
				memberInfo = new MemberVo(rs.getString("mem_id"), rs.getString("mem_name"));
				memberInfo.setMemPhone(rs.getString("mem_phone"));
				memberInfo.setMemIp(request.getRemoteAddr());

				session.setAttribute("memberInfo", memberInfo);
				out.println(rs.getString("mem_id") + " / ");
				out.println(rs.getString("mem_pwd") + " / ");
				out.println(rs.getString("mem_name") + " / ");
				out.println(rs.getString("mem_phone") + " <br> ");
			}
			*/

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