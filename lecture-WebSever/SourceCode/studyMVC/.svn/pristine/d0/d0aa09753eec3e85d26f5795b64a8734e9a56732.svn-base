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
<title>noticeView</title>
</head>

<body>


	<blockquote>
		<form:form commandName='noticeVo'>

			<table class='table'>
				<tr>
					<th>인덱스</th>
					<td>${noticeVo.idx}</td>
				</tr>
				<tr>
					<th>게시판타입</th>
					<td><form:select path="boardType" cssClass='form-control' disabled="true">
							<form:option value="B001">공지사항</form:option>
							<form:option value="B002">일반</form:option>
							<form:option value="B003">자료실</form:option>
							<form:option value="B004">질의응답</form:option>
						</form:select></td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${noticeVo.title}</td>
				</tr>
				<tr>
					<th>등록자</th>
					<td>${noticeVo.regUser}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><pre>${noticeVo.contents}</pre></td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>${noticeVo.regDate}</td>
				</tr>
				<tr>
					<th>수정일</th>
					<td>${noticeVo.upDate}</td>
				</tr>
				<tr>
					<td colspan='2'><a href='/notice/noticeList'>목록</a> <a href='#'>삭제<a> <a href='#'>수정</a></td>
				</tr>
			</table>
		</form:form>
	</blockquote>


</body>
</html>