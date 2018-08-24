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
<title>공지사항 작성</title>
</head>

<body>

	<blockquote>
		<form:form commandName="noticeVo" action="/notice/noticeProc">
			<table class='table'>
				<tbody>
					<tr>
						<td>게시판타입</td>
						<td><form:select path="boardType" cssClass="form-control">
								<form:option value="B001">공지사항</form:option>
								<form:option value="B002">일반</form:option>
								<form:option value="B003">자료실</form:option>
								<form:option value="B004">질의응답</form:option>
							</form:select></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><form:input path="title" cssClass="form-control" /></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><form:textarea path="contents" cssClass="form-control" /></td>
					</tr>
					<tr>
						<td>등록자</td>
						<td><form:input path="regUser" readonly='true' cssClass="form-control" /></td>
					</tr>
					<tr>
						<td colspan='2'><form:button type="submit" cssClass="form-control">저~장</form:button></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</blockquote>

</body>
</html>