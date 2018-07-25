<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberList</title>
</head>

<body>

	<div class="row">
		<div class="col-sm-12 blog-main">
			<table class="table">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>이메일</th>
						<th>가입일</th>
						<th>접속아이피</th>
						<th>탈퇴여부</th>
					</tr>
				</thead>

				<c:forEach var="item" items="${result}">
					<tbody>
						<tr>
							<!-- ;a tag url에 parameter value 붙이기 -->
							<c:url value="/member/memberView.do" var="memberViewUrl">
								<c:param name="memId" value="${item.memId}" />
							</c:url>
							<td><a href="${memberViewUrl}">${item.memId}</a></td>
							<td>${item.memName}</td>
							<td>${item.memPhone}</td>
							<td>${item.memEmail}</td>
							<td>${item.regDate}</td>
							<td>${item.memIp}</td>
							<td>${item.delAt}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>