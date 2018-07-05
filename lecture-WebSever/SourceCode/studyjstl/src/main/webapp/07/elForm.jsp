<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page import="kr.or.nextit.notice.service.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>07/elForm.jsp</title>
</head>
<body>
	<%
		request.setAttribute("sex", false);
	%>

	<!-- ;context path를 포함한다 -->
	<c:url var="frmUrl" value="/07/elProc.jsp" />

	<pre>
	request.getContextPath() : <%=request.getContextPath()%>/07/elProc.jsp
	<br>
	c:url : ${frmUrl}
	</pre>

	<c:if test="${sex}"> ${sex} : 남성입니다. </c:if>
	<c:if test="${!sex}"> ${sex} : 여성입니다. </c:if>

	<!-- ;; ternary operator -->
	${sex? '남성' : '여성'}

	<form action="${frmUrl}">
		<table border="7" style="border-color: orange;">
			<tr>
				<td>제목</td>
				<td><input name="title" type="text" maxlength="250" value="This is JSP!"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input name="regUser" type="text" maxlength="150" readonly="readonly" value="박지성"></td>
			</tr>

			<%
				request.setAttribute("sexs", InfoUtils.getSex());
				request.setAttribute("adult", InfoUtils.getAdult());
			%>

			<tr>
				<td>성별</td>
				<td><select name="sex">
						<!-- ;;items는 request.attribute에 set된 정보 -->
						<c:forEach var="item" items="${sexs}">
							<option value="${item.value}">${item.display}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>성인여부</td>
				<td><select name="adult">
						<c:forEach var="item" items="${adult}">
							<option value="${item.value}">${item.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="20" cols="50">지송빠르끄~ 지송빠르끄으으~~</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">등록</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
