<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.net.*"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>

<%@ page import="kr.or.nextit.nextit.member.service.*"%>
<%@ page import="kr.or.nextit.comm.utils.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<%
	/*
	// !! sol01
	String p_id = request.getParameter("id");
	String p_check = request.getParameter("idSave");
	
	int maxAge = 0;
	if (p_check != null) {
		maxAge = 10;
	}
	
	// ;;값이 있을때 값이 바뀌는 방법으로도 생각해보자
	
	// ! Form으로 부터 받아 온 "idSave" 쿠키를 생성
	Cookie ck = CookieBox.createCookie("idSave", p_id, maxAge);
	response.addCookie(ck);
	*/

	// !! sen sol
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String idSave = request.getParameter("idSave");

	if (id != null && !"".equals(id)) {
		if (idSave != null && "Y".equals(idSave)) {
			response.addCookie(CookieBox.createCookie("idSave", id, 10000));
		} else {
			response.addCookie(CookieBox.createCookie("idSave", "", 0));
		}
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginProc.jsp</title>
<c:import url="/inc/headLib.jsp" />
</head>
<body>

	<jsp:include page="/inc/menuBar.jsp" />

	<table class="table" border="3" style="border-color: black; width: 100%">
		<tr>
			<td height="250px" width="300px"><c:import url="/inc/menuLeft.jsp" /></td>
			<td>
				<div>======= LogIn Info ========</div> <%
 	// --------------------------------------------------------
 	// 1.드라이버 로딩
 	// --------------------------------------------------------
 	Connection conn = null;
 	PreparedStatement pstmt = null;
 	ResultSet rs = null;
 	long startTime = System.currentTimeMillis();

 	try {

 		//String memId = request.getParameter("memId"); // ;;파라미터로 넘어온 값으로 db를 조회

 		Class.forName("oracle.jdbc.driver.OracleDriver"); // ;import 오라클 드라이버

 		// --------------------------------------------------------
 		// 2.연결설정
 		// --------------------------------------------------------
 		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");

 		// ;query 작성
 		String sql = " select * from TAB_member where mem_id = ? and mem_pwd = ? ";

 		// --------------------------------------------------------
 		// 3.구문객체 생성
 		// --------------------------------------------------------
 		pstmt = conn.prepareStatement(sql); // ;쿼리 객체 생성
 		pstmt.setString(1, id); // ;첫번째 물음표에 값을 입력
 		pstmt.setString(2, pw); // ;첫번째 물음표에 값을 입력

 		// --------------------------------------------------------
 		// 4.구문객체 실행
 		// --------------------------------------------------------
 		rs = pstmt.executeQuery(); // ;결과가 ResultSet에 담긴다

 		MemberVo memberInfo = null;

 		// ;rs 출력 (memberVo obj에 담기)
 		if (rs.next()) {
 			// Login성공
 			memberInfo = new MemberVo(rs.getString("mem_id"), rs.getString("mem_name"));
 			memberInfo.setMemPhone(rs.getString("mem_phone"));
 			memberInfo.setMemIp(request.getRemoteAddr());

 			session.setAttribute("memberInfo", memberInfo);
 			/*
 				out.println(rs.getString("mem_id") + " / ");
 				out.println(rs.getString("mem_pwd") + " / ");
 				out.println(rs.getString("mem_name") + " / ");
 				out.println(rs.getString("mem_phone") + " <br> ");
 			*/
 %> 로그인에 성공하였습니다. <%
 	} else {
 			// Login실패
 %> 로그인에 실패하였습니다. <%
 	}
 	} catch (SQLException ex) {
 		out.println(ex.getMessage());
 		ex.printStackTrace();

 	} finally {
 		// --------------------------------------------------------
 		// 6. 자원해제
 		// --------------------------------------------------------
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

 		// --------------------------------------------------------
 		// 7. db 연결 종료
 		// --------------------------------------------------------
 		if (conn != null) {
 			try {
 				conn.close();
 			} catch (SQLException ex) {
 			}
 		}

 	}
 %>
 <br> <br>
 <%
 	// ! request가 갖고 있는 쿠키들 가져와서 보기
 	Cookie[] cks = request.getCookies();

 	if (cks != null) {
 		for (Cookie c : cks) {
 			out.println("getName() : " + c.getName() + " <br> ");
 			out.println("getValue() : " + c.getValue() + " <br> ");
 			out.println("getMaxAge() : " + c.getMaxAge() + " <br> ");
 			out.println("getDomain() : " + c.getDomain() + " <br> ");
 			out.println("getPath() : " + c.getPath() + " <br> ");
 			out.println("getComment() : " + c.getComment() + " <br> ");
 			out.println("getVersion() : " + c.getVersion() + " <br> ");
 			out.println("getSecure() : " + c.getSecure() + " <br> ");
 			out.println("--------------------------------- <br> ");
 		}
 	}
 %>

			</td>
		</tr>
	</table>

	<!-- ;c:import 사용할 경우 -->
	<c:import url="/inc/menuDown.jsp" charEncoding="utf-8" />

</body>
</html>