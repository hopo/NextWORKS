<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.nextit.session.service.*"%>

<%
	// ! context path
	String cPath = request.getContextPath();
%>

<!--
	!참고: 부트스트랩
	 http://bootstrapk.com/getting-started/#template
-->

<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<title>studyTest index.jsp</title>

<jsp:include page="/common.jsp">
	<jsp:param value="lib.form" name="head"/>
</jsp:include>

</head>
<body>

	<h2>
		<em>HELLO JSP!</em>
	</h2>
	<%=cPath%>

	<div class="container">
		<a href="<%=cPath%>/index.jsp">MAIN</a>

		<form action="<%=cPath%>/indexProc.jsp" method="post">
			<table class="table">
				<tr class="active">
					<td>ID</td>
					<td><input name="id" type="text" class="form-control" value="testId"></td>
				</tr>
				<tr class="active">
					<td>PW</td>
					<td><input name="pw" type="password" class="form-control" value=""></td>
				</tr>
				<tr class="active">
					<td colspan="2">
						<button type="submit" class="form-control">SUBMIT</button>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<a href="<%=request.getContextPath()%>/01/infoForm.jsp">/01/infoFirm.jsp</a>
	<br>
	<a href="<%=request.getContextPath()%>/02/InfoForm.jsp">/02/InfoForm.jsp</a>

</body>
</html>