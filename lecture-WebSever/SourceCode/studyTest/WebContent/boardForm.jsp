<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.nextit.session.service.*"%>

<%
	request.setCharacterEncoding("UTF-8");

	String cPath = request.getContextPath();

	// ;앞에서 저장된 세션을 이곳으로 가져오기
	SessionVo se2 = (SessionVo) request.getSession().getAttribute("info");
%>

<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>studyTest boardForm.jsp</title>

<jsp:include page="/common.jsp">
	<jsp:param value="boarForm" name="head" />
</jsp:include>

</head>
<body>

	<h2>
		<em>board!</em>
	</h2>
	<%=cPath%>

	<div class="container">
		<a href="<%=cPath%>/index.jsp">MAIN</a>

		<form action="" method="get">
			<table border="3" style="border-color: olive;" class="table">
				<tr class="active">
					<td>TITLE</td>
					<td><input name="title" type="text" maxlength="250"></td>
				</tr>
				<tr class="active">
					<td>REG_USER</td>
					<td><input name="regUser" type="text" maxlength="150" readonly="readonly" value="<%=se2.getId()%>"></td>
				</tr>
				<tr class="active">
					<td>CONTENTS</td>
					<td><textarea name="content" rows="20" cols="50"></textarea></td>
				</tr>
				<tr class="active">
					<td colspan="2">
						<button type="submit">Submit</button>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>