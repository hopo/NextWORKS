<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	//request.setCharacterEncoding("utf-8"); // c tag import 로 넘오는 것라서 앞에서 설정 가능
	String cPath = request.getContextPath();
%>


<!-- Center 테이블을 위한 div 닫기 태그입니다 -->
</div>

<div class="container">
	<table class="table" border="3" style="border-color: black; width: 100%">
		<tr>
			<td><a href="<%=cPath%>/session/logOutProc.jsp">로그아웃</a></td>
		</tr>
	</table>
</div>