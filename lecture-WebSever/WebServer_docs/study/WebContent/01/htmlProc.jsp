<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<%
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

<%!private String getPhone(int hp0, int hp1, int hp2) {
		if(hp1 == 0 || hp2 == 0) {
			return "0000";	
		}
		String hp = String.format("%03d - %03d - %04d", hp0, hp1, hp2);

		StringBuilder sb = new StringBuilder(hp);
		switch (hp0) {
		case 42:
			sb.insert(0, "(대전) ");
			break;
		case 51:
			sb.insert(0, "(부산) ");
			break;
		case 53:
			sb.insert(0, "(대구) ");
			break;
		case 54:
			sb.insert(0, "(경북) ");
			break;
		default:
			sb.insert(0, "(휴대전화) ");
		}

		return sb.toString();

	}

	private String getGender(String gender) {
		String genderVal = "";
		if ("f".equalsIgnoreCase(gender)) {
			genderVal = "여성";
		} else if ("m".equalsIgnoreCase(gender)) {
			genderVal = "남성";
		} else {
			genderVal = "성별 누락";
		}

		return genderVal;
	}

	private String getAge(String age) {
		StringBuilder ageVal = new StringBuilder(age);
		if (Integer.parseInt(age) < 19) {
			ageVal.insert(0, "(미성년자) ");
		} else {
			ageVal.insert(0, "(성인) ");
		}
		ageVal.append("세");

		return ageVal.toString();
	}

	private String getFlag(String[] flag) {
		StringBuilder flagVal = new StringBuilder();
		for (String value : flag) {
			if ("01".equalsIgnoreCase(value)) {
				flagVal.append(String.format("%s:책 ", value));
			} else if ("02".equalsIgnoreCase(value)) {
				flagVal.append(String.format("%s:영화 ", value));
			} else if ("03".equalsIgnoreCase(value)) {
				flagVal.append(String.format("%s:운동 ", value));
			}
		}

		return flagVal.toString();
	}

	private String getFlag2(String flag2) {
		return "Y".equals(flag2) ? "기혼" : "미혼";
	}%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>htmlProc.html</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/">main gogo</a>
	<br>
	<table>
		<tbody>
			<tr>
				<td>ID</td>
				<td><%=request.getParameter("id")%></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><%=request.getParameter("name")%></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><%=getGender(gender)%></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><%=getAge(age)%></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><%=getPhone(hp0, hp1, hp2)%></td>
			</tr>
			<tr>
				<td>Addr</td>
				<td><%=address%></td>
			</tr>
			<tr>
				<td>Interest</td>
				<td><%=getFlag(flag)%></td>
			</tr>
			<tr>
				<td>Married</td>
				<td><%=getFlag2(flag2)%></td>
			</tr>
		</tbody>
	</table>
	<a href="<%=request.getContextPath()%>/01/htmlForm.jsp">prev page</a>
</body>
</html>
