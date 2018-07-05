<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>

<%-- <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fileReader.jsp</title>
</head>
<body>
	<div id="contentArea">
		<%=application.getRealPath("/10/readme.txt")%>
		<br>
		<pre>
		<%
			String path = application.getRealPath("/10/readme.txt");

			char[] buff = new char[128];
			int len = -1;

			//InputStreamReader br = null;

			try (InputStreamReader br = new InputStreamReader(application.getResourceAsStream("/10/readme.txt"),
					"utf-8")) {

				//br = new InputStreamReader(application.getResourceAsStream(path), "euc-kr");
				while ((len = br.read(buff)) != -1) {
					out.print(new String(buff, 0, len));
				}

			} catch (IOException ex) {
				out.println("예외발생 : " + ex.getMessage());
			}
		%>
		</pre>
	</div>
</body>
</html>