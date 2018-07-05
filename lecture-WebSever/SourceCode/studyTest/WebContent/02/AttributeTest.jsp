<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>

<%@ page import="kr.or.nextit.info.service.ComVo"%>

<%
	// =====
	ComVo comVo = new ComVo();
	comVo.setName("영하~");
	comVo.setValue("용해랑사~");
	comVo.setJsp("박지성");
	
	request.setAttribute("com", comVo);

	// =====
	HashMap test = new HashMap();
	test.put("id", "말자-!");
	test.put("key01", "value01");

	request.setAttribute("name", "Obama");
	request.setAttribute("dddd", test);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Attribute Test</title>
</head>

<body>
	<pre>
		<%=request.getParameter("key")%>

		[[[ el tag ]]]
		name Value = ${name}
		ddd Value = ${ddd }
		dddd.key01 Map Value = ${dddd.key01 }
		dddd.id Map Value = ${dddd.id }

		[[[ el tag  *Vo]]]
		com.name Value = ${com.name }
		com.value Value = ${com.value }
		com.jsp Value = ${com.jsp }
	</pre>

	<%
		request.setAttribute("name", "O-kane");
	%>
</body>
</html>