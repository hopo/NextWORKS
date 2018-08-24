<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	request.setCharacterEncoding("utf-8");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>testAttachForm.jsp</title>

</head>

<body>
	<div>
		<blockquote>
			<table class="table">
				<colgroup>
					<col style="width: 20%;" />
					<col />
				</colgroup>

				<tbody>
					<tr>
						<th>파일이름</th>
						<th>사이즈</th>
						<th>그룹아이디</th>
						<th>파일아이디</th>
					</tr>
					<c:forEach var="item" items="${result}">
						<tr>
							<th>
								<a href="<c:url value="/attach/download/${item.fileId}" />" target="_blank">${item.fileOriginalFileName}</a>
							</th>
							<td>${item.fileSize}</td>
							<td>${item.fileGroup}</td>
							<td>${item.fileId}</td>
							<td>
								<img src="<c:url value="/attach/download/${item.fileId}" />" width="100px" />
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</blockquote>
	</div>
</body>
</html>