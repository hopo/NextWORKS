<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>html 폼데이터전송</title>
</head>

<body>
	<a href="<%=request.getContextPath()%>/">main gogo</a>
	<br>
	<form action="<%=request.getContextPath()%>/01/htmlProc.jsp"
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
						value="D.Trumph"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><select name="gender">
							<option value="" disabled="disabled">select...</option>
							<option value="f" selected>Female</option>
							<option value="m">Male</option>
					</select></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input name="age" type="number" value="18"></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><select name="hp0">
							<option value="10" selected>010</option>
							<option value="11">011</option>
							<option value="16">016</option>
							<option value="17">017</option>
							<option value="18">018</option>
							<option value="19">019</option>
							<option value="42">042</option>
							<option value="51">051</option>
							<option value="53">053</option>
							<option value="54">054</option>
					</select> &nbsp;-&nbsp; <input name="hp1" value="" maxlength="4">
						&nbsp;-&nbsp; <input name="hp2" value="" maxlength="4"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input name="post" value="" maxlength="6"> <br>
						<input name="add1" value="" maxlength="100"> <br> <input
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
						<input name="flag2" type="radio" value="N">미혼<br></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit">SUBMIT</button></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>