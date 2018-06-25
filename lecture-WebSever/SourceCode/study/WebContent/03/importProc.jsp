<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>

<%@ page import="kr.or.nextit.study.ex03.StringUtiles"%>
<%@ page import="kr.or.nextit.study.member.service.*"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	// ! Form으로 부터 파라미터로 넘어오는 값들
	String gender = request.getParameter("gender");

	int hp0 = Integer.parseInt(request.getParameter("hp0"));
	int hp1 = Integer.parseInt(request.getParameter("hp1"));
	int hp2 = Integer.parseInt(request.getParameter("hp2"));

	String post = request.getParameter("post");
	String add1 = request.getParameter("add1");
	String add2 = request.getParameter("add2");
	String address = String.format("%s<br>%s<br>%s", post, add1, add2);

	String age = request.getParameter("age");

	String[] flag = request.getParameterValues("flag");

	String flag2 = request.getParameter("flag2");
%>

<%
	// Instance make
	MemberVo memberVo = new MemberVo();

	memberVo.setId(request.getParameter("id"));
	memberVo.setName(request.getParameter("name"));
	memberVo.setAge(Integer.parseInt(request.getParameter("age")));
	memberVo.setGender(request.getParameter("gender"));
	String hp = String.format("%s-%s-%s", request.getParameter("hp0"), request.getParameter("hp1"), request.getParameter("hp2"));
	memberVo.setHp(hp);
	memberVo.setPost(request.getParameter("post"));
	String addr = String.format("%s %s", request.getParameter("add1"), request.getParameter("add2"));
	memberVo.setAddr(addr);
	memberVo.setFlag(request.getParameterValues("flag"));
	memberVo.setFlag2(request.getParameter("flag2"));
	
	// ! 
	MemberService member = new MemberServiceImpl();
	
	MemberVo result = member.setMemberInfo(memberVo);
	
	out.print(result.getMessage());
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>htmlProc.html</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/">
		<div>GoMain</div>
	</a>
	<br>
	<table>
		<tbody>
			<tr>
				<td>ID</td>
				<td><%=result.getId()%></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><%=result.getName()%></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><%=result.getGender()%></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><%=result.getAge()%></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><%=result.getHp()%></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><%=result.getPost()%> <%=result.getAddr()%></td>
			</tr>
			<tr>
				<td>Interest</td>
				<td><%=result.getFlagDisplay()%></td>
			</tr>
			<tr>
				<td>Married</td>
				<td><%=result.getFlag2()%></td>
			</tr>
		</tbody>
	</table>
	<a href="<%=request.getContextPath()%>/03/importForm.jsp">
		<div>Go importForm</div>
	</a>
</body>
</html>
