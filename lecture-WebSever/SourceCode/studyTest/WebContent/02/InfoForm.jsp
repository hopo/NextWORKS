<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.or.nextit.info.service.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>

<jsp:include page="/common.jsp">
	<jsp:param value="info.form" name="head" />
</jsp:include>


</head>
<body>

	<div class="container">

		<div class="panel panel-primary">
			<div class="panel-heading">안녕 하세용~~~~</div>
			<div class="panel-body ">

				<%=request.getContextPath()%>

				<a href="<%=request.getContextPath()%>/index.jsp">메인</a> <br> request : ${item.userName} <br> session : ${se.userName}

			</div>
		</div>

		<form action="<%=request.getContextPath()%>/02/InfoProc.jsp" method="post">

			<div class="table-responsive">
				<table class="table">
					<tr class="active">
						<td>사용자 이름</td>
						<td><input type="text" name="userName" class="form-control" required="required"></td>
					</tr>
					<tr>
						<td>사용자 이메일</td>
						<td><input type="email" name="userEmail" class="form-control" required="required"></td>
					</tr>
					<tr>
						<td>성인 여부</td>
						<td>
							<%
								List<ComVo> items = InfoUtils2.getAdult();
								for (ComVo item : items) {
							%> <input type="radio" name="isAdult" value="<%=item.getValue()%>" required="required"><%=item.getName()%> <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<td>성별</td>
						<td><select name="userSex" class="form-control" required="required">
								<%
									List<HashMap<String, Object>> sexs = InfoUtils2.getSex();
									for (HashMap<String, Object> item : sexs) {
								%>
								<option value="<%=item.get("value")%>"><%=item.get("display")%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td><input type="date" name="userDate" class="form-control" required="required"></td>
					</tr>
					<tr>
						<td>취미항목</td>
						<td>
							<%
								List<HashMap<String, Object>> hobbys = InfoUtils2.getHobbyDisplay();
								for (HashMap<String, Object> item : hobbys) {
							%> <input type="checkbox" name="userHobby" value="<%=item.get("value")%>"> <%=item.get("display")%> &nbsp; &nbsp; <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<td colspan="2"><button type="submit" class="form-control">전송</button></td>
					</tr>
				</table>
			</div>

		</form>

	</div>



</body>
</html>