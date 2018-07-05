<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.net.*"%>

<%@ page import="kr.or.nextit.comm.utils.*"%>

<%
	CookieBox co = new CookieBox(request);
	Cookie oName = co.createCookie("oName", "오까네 오궹끼데스까?"); // ;; 쿠키를 생성
	response.addCookie(oName); // ;; 쿠키를  response객체에 추가

	Cookie sName = CookieBox.createCookie("sName", "오까네 오궹끼데스까?");
	response.addCookie(sName);
	
	
	Cookie tName = CookieBox.createCookie("tName", "오라크르 이즈 응가!", 1000); // ;;시간을 주지 않으면 브라우저 종료시 삭제
	response.addCookie(tName);

	/*
	// ! Cookie 객체 생성
	//Cookie cokie = new Cookie("memName", "Kiku");
	Cookie cokie = new Cookie("memName", URLEncoder.encode("오라클", "utf-8")); // ;기본적으로 인코딩 해서 쿠키를 생성
	
	// ! 생성된 cookie에다가 데이터를 set
	//cokie.setDomain("nextit.or.kr"); // ;setDomain() 해당하는 도메인에서만 쿠키값을 가지고온다
	cokie.setPath("/");
	cokie.setMaxAge(10); // ;10초 후면 삭제, 0이면 삭제
	
	// ! response 객체에다 추가
	response.addCookie(cokie);
	*/
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CookieCreate.jsp</title>
</head>
<body>

<%-- 	<%=cokie.getName()%>
	<%=cokie.getValue()%>
 --%>
	<br>
	<a href="<%=request.getContextPath()%>/cookie/CookieForm.jsp">CookieForm</a>
</body>
</html>