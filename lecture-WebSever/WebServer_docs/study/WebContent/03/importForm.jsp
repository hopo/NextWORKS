<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>

<%@ page import="kr.or.nextit.study.ex03.StringUtiles"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자바 클래스 Import (importForm.jsp)</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/">
		<div>GoMain</div>
	</a>

	<%=StringUtiles.getHi()%>

	<form action="<%=request.getContextPath()%>/03/importProc.jsp"
		method="post" name="member">
		<table>
			<tbody>
				<tr>
					<td>ID</td>
					<td><input name="id" type="text" maxlength="30" value="master"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input name="name" type="text" maxlength="50"
						value="Sooki"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><%=StringUtiles.getGender("gender")%></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input name="age" type="number" value="18"></td>
				</tr>
				<tr>
					<td>Hp</td>
					<td>
						<%
							List<HashMap> hpItem = StringUtiles.getHp();
						%> <select name="hp0">

							<%
								for (HashMap item : hpItem) {
							%>
							<option value="<%=item.get("value")%>"><%=item.get("display")%></option>
							<%
								}
							%>
					</select> <input name="hp1" value="" maxlength="4"> <input
						name="hp2" value="" maxlength="4">
					</td>
				</tr>
				<tr>
					<td>Addr</td>
					<td><input name="post" value="" maxlength="5">
					<br>
						<input name="add1" value="" maxlength="100">
						<br> <input
						name="add2" value="" maxlength="50"></td>
				</tr>
				<tr>
					<td>Interest</td>
					<td><input name="flag" type="checkbox" value="01" checked>책<br>
						<input name="flag" type="checkbox" value="02">영화<br>
						<input name="flag" type="checkbox" value="03">운동<br>
					</td>
				</tr>
				<tr>
					<td>Married</td>
					<td><input name="flag2" type="radio" value="Y" checked>기혼
						<input name="flag2" type="radio" value="N">미혼 <br></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">SUBMIT</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>