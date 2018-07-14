<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%@ page import="com.room2.member.service.*"%>
<%@ page import="com.room2.member.service.impl.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberUpdateForm</title>
</head>
<body>

	<c:url value="/index.jsp" var="homeUrl" />
	<c:url value="/member/memberList.jsp" var="memberListUrl" />
	<c:url value="/member/memberUpdateProc.jsp" var="memberUpdateProcUrl" />

	<a href="${homeUrl}">HOME</a>
	<hr>

	<%
		MemberService member = new MemberServiceImpl();
		MemberVo item = member.selectMemberItem(request.getParameter("mem_id"));
		
		request.setAttribute("item", item);
	%>
	<div>"회원수정"</div>

	<form action="${memberUpdateProcUrl}" method="post">
		<table border="3px" style="border-color: red;">
			<tr>
				<td>아이디</td>
				<td><input name="mem_id" value="${item.mem_id}"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="mem_pwd" value="${item.mem_pwd}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="mem_name" value="${item.mem_name}"></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input name="mem_phone" value="${item.mem_phone}"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="mem_email" value="${item.mem_email}"></td>
			</tr>

			<tr>
				<td colspan="2"><button>수정</button></td>
			</tr>
		</table>
	</form>
	
	<a href="${memberListUrl}">취소</a>

</body>
</html>