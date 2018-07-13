<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.nextit.nextit.member.service.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	request.setCharacterEncoding("utf-8");
	String cPath = request.getContextPath();
%>


<h3>
	[[[ <a href="<%=request.getContextPath()%>/index.jsp"> /studyjstl/index.jsp </a> ]]]
</h3>

<pre>
	${title}
	${name}
	${test}
</pre>

<div class="container">
	<table class="table" border="3" style="border-color: black; width: 100%">
		<tr>
			<td><c:url var="logOut" value="/session/logOutProc.jsp" /> <c:if test="${memberInfo != null}">
						접속자 : ${memberInfo.memId} ( <a href="${logOut}">로그아웃</a> )
				</c:if> <c:if test="${memberInfo == null}">
					<a href="<%=cPath%>/session/loginForm.jsp">로그인</a>
				</c:if></td>
			<td><a href="<%=cPath%>/member/memberList.jsp">회원관리</a></td>
			<td><a href="<%=cPath%>/board/boardList.jsp">게시판</a></td>
		</tr>
	</table>
</div>

<!-- Center 테이블을 위한 div 시작 태그입니다 -->
<div class="container">