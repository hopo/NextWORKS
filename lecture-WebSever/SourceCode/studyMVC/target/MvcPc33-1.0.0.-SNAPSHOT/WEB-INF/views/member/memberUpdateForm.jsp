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
<title>memberUpdateForm</title>
</head>

<body>

	<div class="row">
		<div class="col-sm-12 blog-main">
			<c:url value="/member/memberProc.do?curPage=${param.curPage}" var="memberProcUrl" />
			<form action="${memberProcUrl}" method="post">
				<input name="flag" type="hidden" value="update">
				<table class="table">
					<tr>
						<th>아이디</th>
						<td><input name='memId' class="form-control" value="${result.memId}" readonly="readonly"></td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input name='memPwd' type='password' value='${result.memPwd}' class="form-control"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input name='memName' value='${result.memName}' class="form-control"></td>
					</tr>
					<tr>
						<th>전화</th>
						<td><input name='memPhone' value='${result.memPhone}' class="form-control"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input name='memEmail' type='email' value='${result.memEmail}' class="form-control"></td>
					</tr>
					<tr>
						<th>탈퇴여부</th>
						<td>
							<select name="delAt" class="form-control">
								<option value="Y" ${result.delAt eq 'Y' ? 'selected' : ''}>가입</option>
								<option value="N" ${result.delAt eq 'N' ? 'selected' : ''}>탈퇴</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type='submit' class="form-control" value="수정"></td>
					</tr>
				</table>
				<c:url value="/member/memberList.do?curPage=${param.curPage}" var="memberListUrl" />
				<a href="${memberListUrl}">수정취소</a>
			</form>
		</div>
	</div>
</body>
</html>