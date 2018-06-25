<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="kr.or.nextit.study.notice.service.*" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<%

	// =============================================
	// get parameter from noticeForm.jsp
	// =============================================
	String title = request.getParameter("title");
	String isOpen = request.getParameter("isOpen");
	String[] serviceType = request.getParameterValues("serviceType");
	String regUser = request.getParameter("regUser");
	String text = request.getParameter("text");
			

	// =============================================
	// set items NoriceService
	// =============================================
	NoticeService noticeService = new NoticeServiceImpl();
	NoticeVo result = noticeService.setNoticeItem(title, isOpen, serviceType, regUser, text);
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		NoticeUtils util = new NoticeUtils();

		if (result.isResult()) {
			// ;Success
			out.print(title);
			out.print("<br>");
			out.print(util.isOpenDisplay(isOpen));
			out.print("<br>");
			out.print(util.serviceTypeDisplay(serviceType));
			out.print("<br>");
			out.print(util.regUserDisplay(regUser));
			out.print("<br>");
			out.print(text);

			/*
			// ;;test exception
			int test =  Integer.parseInt(result.getTitle());
			*/
		} else {
			// ;Error
			out.print("[[ EXCEPTION ]]<br>");
			out.print(result.getMessage());
		}
	%>

	<a href="<%=request.getContextPath()%>/04/noticeForm.jsp"><div>Go noticeForm</div>
</body>
</html>