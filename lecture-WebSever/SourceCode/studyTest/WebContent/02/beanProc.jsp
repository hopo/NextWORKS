<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.bean.service.*"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>02/beanProc.jsp</title>
</head>
<body>
	<%
		BeanVo bVo = new BeanVo();
		bVo.setTitle(request.getParameter("title"));
		bVo.setRegUser(request.getParameter("regUser"));
		bVo.setContent(request.getParameter("content"));
	%>

	<pre>
====== parameter =====
<%=request.getParameter("title")%>
<%=request.getParameter("regUser")%>
<%=request.getParameter("content")%>

====== Vo =====
<%=bVo.getTitle()%>
<%=bVo.getRegUser()%>
<%=bVo.getContent()%>

====== property =====
<!-- import -->
<jsp:useBean id="beanTest" class="kr.or.bean.service.BeanVo"></jsp:useBean>
<jsp:setProperty property="*" name="beanTest" />
<!--  -->

<jsp:getProperty property="title" name="beanTest" />
<jsp:getProperty property="regUser" name="beanTest" />
<jsp:getProperty property="content" name="beanTest" />

====== Express Language =====
${beanTest.title }
${beanTest.regUser }
${beanTest.content }


</pre>

</body>
</html>