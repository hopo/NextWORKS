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
<title>memberList</title>
</head>
<body>
	<c:url value="/index.jsp" var="homeUrl" />
	<c:url value="/member/memberList.jsp" var="memberListUrl" />
	<c:url value="/member/memberUpdateForm.jsp" var="memberUpdateFormUrl" />
	<c:url value="/member/memberDeleteProc.jsp" var="memberDeleteProcUrl" />
	<c:url value="/session/signupForm.jsp" var="signupFormUrl" />

	<a href="${homeUrl}">HOME</a>
	<hr>

	<%
		MemberService member = new MemberServiceImpl();
		List<MemberVo> memberItems = member.selectMemberList(request);
	%>

	<div>"회원목록"</div>
	
	<form action="${memberListUrl}">
		<table border="3" style="border-color: blue;">
			<thead>
				<tr>
					<th colspan="8">
						<input name="findMem_id" value="${findMem_id}">
						<button type="submit">검색</button>
					</th>
					<th>
						<a href="${signupFormUrl}">회원가입</a>
					</th>
				</tr>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>등록일</th>
					<th>아이피</th>
					<th>삭제여부</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>

				<%
					for (MemberVo item : memberItems) {
						request.setAttribute("item", item);
				%>
				<tr>
					<td> 
						<a>${item.mem_id}</a>
					</td>
					<td> 
						<a>${item.mem_name}</a>
					</td>
					<td> 
						<a>${item.mem_phone}</a>
					</td>
					<td> 
						<a>${item.mem_email}</a>
					</td>
					<td> 
						<a>${item.reg_date}</a>
					</td>
					<td> 
						<a>${item.mem_ip}</a>
					</td>
					<td> 
						<a>${item.del_at}</a>
					</td>
					<td> 
						<a href="${memberUpdateFormUrl}?mem_id=${item.mem_id}">수정</a>
					</td>
					<td> 
						<a href="${memberDeleteProcUrl}?mem_id=${item.mem_id}">삭제</a>
					</td>
				</tr>
				<% } %>

			</tbody>
		</table>
			
	</form>
	
</body>
</html>