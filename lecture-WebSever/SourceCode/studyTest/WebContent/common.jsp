<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<% String cPath = request.getContextPath(); %>



<div>=== "COMMON" (studyTest/common.jsp]) ===</div>
<!-- !js / css 가져오기 -->
<!-- ;순서, 위치
	<title></title>
	bootstrap css
	bootstrap-theme css
	jQuery js
	bootstrap js
	</head>
 -->
<link rel="stylesheet" href="<%=cPath%>/css/bootstrap.min.css">
<script type="text/javascript" src="<%=cPath%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=cPath%>/js/bootstrap.min.js"></script>