<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>viewItems</title>

<script defer="defer">
	// ;===== for ajax jQuery =========================
	$(document).ready(function() {

		$("#cleanBtn").on("click", function(evt) {
			evt.preventDefault();
			$("#listView").empty();
		});

		$("#jsonBtn").on("click", function(evt) {
			$("#listView").empty();
			$.ajax({
				url					: '<c:url value="/jsonResult" />',
				method	 			: "POST",
				dataType	 		: 'json',
				data 				: $('#frm').serialize(),
				success 			: function(result, status, xhr) {
					$.each(result.list, function(key, value) {
						var rs = "";
						rs += "<tr>";
						rs += "<td>" + key + "</td>";
						rs += "<td>" + JSON.stringify(value) + "</td>";
						rs += "</tr>";
						$("#listView").append(rs);
					});
				},
				error 				: function(jqXhr, textStatus, errorMessage) {
					alert("@@@ ajax error");
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});
		});
	});
	// ;===============================================
</script>

</head>

<body>
	<button id="cleanBtn">cleanBtn</button>
	<button id="jsonBtn">jsonBtn</button>

	<table class="table">
		<thead>
			<th>순번</th>
			<th>데이터</th>
		</thead>
		<tbody id="listView">
			<c:forEach var="rs" items="${list}">
				<tr>
					<td>${rs.IDX}</td>
					<td>${rs}</td>
				</tr>
			</c:forEach>
 		</tbody>
	</table>
</body>
</html>