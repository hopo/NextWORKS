<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>

<%@ page import="kr.or.nextit.info.service.*"%>

<%
	request.setCharacterEncoding("UTF-8");

	InfoService2 result = new InfoService2Impl();
	result.setInfoItem(request);
	InfoVo2 infovo = (InfoVo2) request.getAttribute("item");

	/* 	out.print(infovo.getUserName());
	 */ InfoVo2 se = (InfoVo2) request.getSession().getAttribute("se");
%>


<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>

<jsp:include page="/common.jsp">
	<jsp:param value="info.proc" name="head" />
</jsp:include>

</head>

<body>

	<div class="container">

		<div class="panel panel-primary">
			<div class="panel-heading">설문조사 입니다 ~~~</div>
			<div class="panel-body ">
				<a href="<%=request.getContextPath()%>/02/InfoForm.jsp">설문조사 다시하기</a>

				<br>
				request : ${item.userName}
				session : ${se.userName}
			</div>
		</div>

		<div class="table-responsive">
			<table class="table">
				<tr class="active">
					<td>사용자 이름</td>
					<td><%=se.getUserName()%></td>
				</tr>
				<tr>
					<td>사용자 이메일</td>
					<td><%=se.getUserEmail()%></td>
				</tr>
				<tr>
					<td>성인 여부</td>
					<td>
						<%
							out.print(se.getIsAdult());
							out.print(" = ");
							out.print(se.getIsAdultDisplay());
						%>
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<%
							out.print(se.getUserSex());
							out.print(" = ");
							out.print(se.getUserSexDisplay());
						%>
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><%=se.getUserDate()%></td>
				</tr>
				<tr>
					<td>취미항목</td>
					<td>
						<%
							List<HashMap<String, Object>> hobby = se.getUserHobbyDisplay();
							for (HashMap<String, Object> item : hobby) {
								out.print(String.format("%s : %s &nbsp; &nbsp;", item.get("value"), item.get("display")));
							}
						%>
					</td>
				</tr>
			</table>
		</div>

	</div>

</body>
</html>