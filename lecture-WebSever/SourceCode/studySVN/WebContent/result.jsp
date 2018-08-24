<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="kr.nextit.*"%>
<%@page import="org.apache.commons.beanutils.BeanUtils"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dspan">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		MemberVo member = new MemberVo();
		member.setMemId(request.getParameter("memId"));
		member.setMemPwd(request.getParameter("memPwd"));
		member.setMemName(request.getParameter("memName"));
		member.setMemPhone(request.getParameter("memPhone"));

		request.setAttribute("member", member);
	%>

	<h3>test 01</h3>
			<span>Id :</span>
			<span>${member.memId}</span>
			<span>Pwd :</span>
			<span>${member.memPwd}</span>
			<span>Name :</span>
			<span>${member.memName}</span>
			<span>Phone :</span>
			<span>${member.memPhone}</span>

	<hr>

	<h3>test 02</h3>
	<%
		MemberVo member2 = new MemberVo();
		// ;리퀘스트 객체의 정보를 Vo에 넣는다
		BeanUtils.populate(member2, request.getParameterMap());
		
		out.print(String.format("Id : %s", member2.getMemId()));
		out.print(String.format("Pwd : %s", member2.getMemPwd()));
		out.print(String.format("Name : %s", member2.getMemName()));
		out.print(String.format("Phone : %s", member2.getMemPhone()));
	%>

</body>
</html>