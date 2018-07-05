<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String cPath = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>infoForm.jsp</title>
</head>
<body>
	<a href="<%=cPath%>/index.jsp">GoMain</a>

	<form action="<%=cPath%>/01/infoProc.jsp" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input name="userName" type="text" value="Obama"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name="email" type="email" value="oba@whouse.com"></td>
			</tr>
			<tr>
				<td>성인여부</td>
				<td>
					<input name="adult" type="radio" value="t" checked>성인
					<input name="adult" type="radio" value="f">미성년
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<select name="gender">
						<option value="male">남자</option>
						<option value="female" checked>여자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<input name="birthYear" type="number" min="1900" max="2010" value="1977">년
					<input name="birthMonth" type="number" min="1" max="12" value="4">월
					<input name="birthDay" type="number" min="1" max="31" value="7">일
				</td>
				<!-- 생년월일은 셀렏트박스가 더 나은 듯, date 타입도 있는 듯 -->
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<input name="hobs" type="checkbox" value="Book" checked>독서
					<input name="hobs" type="checkbox" value="Soccer">축구
					<input name="hobs" type="checkbox" value="Riding">자전거
					<input name="hobs" type="checkbox" value="TV" checked>텔레비젼
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">보내기</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>