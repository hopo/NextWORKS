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
<title>memberView</title>
</head>

<body>
<blockquote>
	<form action="/member/memberUpdateProc" method="POST">
		<input type="hidden" name="memId" value="${item.memId}">
		Current mem_id : <div>${item.memId}</div>
		<table border="1px">
			<tbody>
				<tr>
					<th>MEM_PWD</th>
					<td>
						<input type="password" name="memPwd" value="${item.memPwd}">
					</td>
				</tr>
				<tr>
					<th>MEM_NAME</th>
					<td>
						<input name="memName" value="${item.memName}">
					</td>
				</tr>
				<tr>
					<th>MEM_PHONE</th>
					<td>
						<input name="memPhone" value="${item.memPhone}">
					</td>
				</tr>
				<tr>
					 <td colspan="2">
					 	<button type="submit">Update</button>
					 </td>
				</tr>
			</tbody>
		</table>
	</form>
	<c:url var="memberDeleteProcUrl" value="/member/memberDeleteProc">
		<c:param name="memId" value="${item.memId}"/>
	</c:url>
	<a href="${memberDeleteProcUrl}">DELETE</a>
</blockquote>
</body>
</html>