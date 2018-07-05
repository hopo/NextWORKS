<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="kr.or.nextit.notice.service.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>07/elProc.jsp</title>
</head>
<body>

	<%
		String title = request.getParameter("title");

		request.setAttribute("title", title);
		request.setAttribute("sexs", InfoUtils.getSex());
		request.setAttribute("adult", InfoUtils.getAdult());
	%>

	<!-- tag를 이용하여 모델 가져와서 셑하기 -->
	<jsp:useBean id="frm" class="kr.or.nextit.notice.service.ElTagVo" />
	<jsp:setProperty property="*" name="frm" />

	<!-- el태그  -->
	el_1 : ${frm.title}
	<br> el_2 : ${title}
	<br>
	<br> property :
	<jsp:getProperty property="title" name="frm" />
	<br>
	<br>
	<!-- el태그 삼항 연산자  -->
	연산자 : ${frm.title != null ? frm.title :'제목이 누락이다!'}
	<br>
	<br>

	<!-- c태그 조건문if -->
	<c:if test="${frm.title == null}">
		${frm.title }
	</c:if>

	<%
		if (title != null) {
			out.print(title);
		}
	%>
	<br>

	<%=request.getParameter("adult")%>
	<br>

	<!-- c태그 반복문forEach -->
	<c:forEach var="item" items="${adult}">
		<c:if test="${frm.adult == item.value}">
			${item.value} : ${item.name }
		</c:if>
	</c:forEach>

	<br>
	<br>

	<!-- request 객체를 이용하여 정보보기 -->
	<%
		out.print("<br>!Header 정보<br>");
		// !Header 정보
		Enumeration en = request.getHeaderNames();
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			out.print(name + " : " + request.getHeader(name) + "<br>");
		}

		out.print("<br>!Attribute 정보<br>");
		// !Attribute 정보
		Enumeration en2 = request.getAttributeNames();
		while (en2.hasMoreElements()) {
			String name = (String) en2.nextElement();
			out.print(name + " : " + request.getAttribute(name) + "<br>");
		}

		out.print("<br>!Parameter 정보<br>");
		// !Parameter 정보
		Enumeration en3 = request.getParameterNames();
		while (en3.hasMoreElements()) {
			String name = (String) en3.nextElement();
			out.print(name + " : " + request.getParameter(name) + "<br>");
		}
	%>

	<!-- ! 리다이렉트 방법의 예 -->

	<%--
	<!-- !! redirect01  -->
	 <%
		String uri = request.getContextPath();
		String redirect = request.getParameter("sex");

		if (redirect.equals("M") || redirect.equals("W")) {
			response.sendRedirect(String.format("%s/07/%sForm.jsp", uri, redirect));
		} else {
			response.sendRedirect(String.format("%s/index.jsp", uri));
		}
	%>
--%>

	<%-- 
	<!-- !! redirect02  -->
	 <%
		String uri = request.getContextPath();
		String redirect = request.getParameter("sex");
		if (redirect.equals("M") || redirect.equals("W")) {
	%>
	<jsp:forward page="/07/${frm.sex}Form.jsp">
		<jsp:param value="key" name="test" />
	</jsp:forward>
	<%
		} else {
	%>
	<jsp:forward page="/index.jsp">
		<jsp:param value="key" name="test" />
	</jsp:forward>
	<%
		}
	%>
--%>

	<%--
	<!-- !! redirect03  -->
	 <%
		// !! redirect03
		String uri = request.getContextPath();
		String redirect = request.getParameter("sex");

		if (redirect.equals("M") || redirect.equals("W")) {
			request.setAttribute("re", String.format("/07/%sForm.jsp", redirect));
		} else {
			request.setAttribute("re", "/index.jsp");
		}
	%>
	

 	<jsp:forward page="${re}">
		<jsp:param value="key" name="test" />
	</jsp:forward>
 --%>

	<!-- !! redirect04  -->
	<%
		String uri = request.getContextPath();
		String redirect = request.getParameter("sex");

		// ;;try catch
		try {

			String name = "sssss";
			if (redirect.equals("M") || redirect.equals("W")) {
				// ;;; user error occu
			} else {
				int ddd = Integer.parseInt(name);
			}

			response.sendRedirect(String.format("%s/07/%sForm.jsp?key=메시지", uri, redirect));

		} catch (Exception ex) {

			response.sendRedirect(String.format("%s/index.jsp?message=%s", uri, ex.getMessage()));

		}
	%>

</body>
</html>
