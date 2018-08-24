<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberList</title>
</head>

<body>
	<table class="table table-bordered">
		<tbody>
			<tr>
				<th>회원ID</th>
				<th>회원NAME</th>
				<th>회원PHONE</th>
				<th>회원LOGIN-DATE</th>
				<th>권한코드</th>
				<th>탈퇴여부</th>
			</tr>
			<c:forEach var="item" items="${items}">
				<tr>
				<c:url var="memberViewUrl" value="/member/memberView">
					<c:param name="memId" value="${item.memId}" />
				</c:url>
					<td><a href="${memberViewUrl}">${item.memId}</a></td>
					<td>${item.memName}</td>
					<td>${item.memPhone}</td>
					<td>${item.loginDate}</td>
					<td>${item.privilCode}</td>
					<td>${item.delAt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/decorator/inc/home.footer.jsp" />
</body>
</html>