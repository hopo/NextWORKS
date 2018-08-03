<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
<title>loginForm.jsp</title>
</head>

<body>
	<h1>로그인페이지</h1>
	
	${loginInfo}

	<form:form commandName="memberVo" action="/session/loginProc">
		<table class="table">
			<tbody>
				<tr>
					<th>아이디</th>
					<td><form:input path="memId" cssClass="form-control" /></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><form:input path="memPwd" type="password" cssClass="form-control" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">로그인</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form:form>

</body>
</html>
