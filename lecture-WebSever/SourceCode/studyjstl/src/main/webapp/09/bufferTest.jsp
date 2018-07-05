<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page buffer="1kb" autoFlush="false"%>

<%-- <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bufferTest.jsp</title>
</head>

<body>
	<%--
		// 일반적으로 버퍼의 속성을 수정하지는 않고
		// 문서의 양이 많을 때 사용자가 기다리게 하면 문제가 되겠죠?(응답시간)
	 --%>
	BufferSIze :
	<%=out.getBufferSize()%><br> Remaining :
	<%=out.getRemaining()%><br> autoFlush :
	<%=out.isAutoFlush()%><br>

	<%
		out.flush(); // ;버퍼의 내용을 내보낸다. 시간이 걸리는 작업전에 flush를 해서 사용자한테 내용이 보여지게 할 때	
		for (int i = 0; i <= 30; i++) {
			if ((i % 10) == 0) {
				out.clearBuffer();
				out.println(" - - - - - - - - -  FLUSH GOGO  - - - - - - - - - <br>");
			}

			out.flush(); // ;반복문 내에서도 가끔 내보내기를 할 수 있음.
			out.println(i + ". 후루뚜루뚜 후루뚜루뚜 후루뚜루뚜 다다다 <br>");
		}
	%>

</body>
</html>