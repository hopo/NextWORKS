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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>customerList</title>

<script type="text/javascript">

	$(document).ready(function() {
		$frm = $('#customerSearchVo');

		// ;;on click submit btn
		$('#searchsubmit', $frm).click(function(e) {
			e.preventDefault();
			$('input[name=curPage]', $frm).val(1);
			$frm.submit();
		});

		// ;;on click  page nav btn
		$('.goPage').click(function() {
			var curPage = $(this).data('curpage');
			$('#curPage').val(curPage);
			$frm.submit();
		});
		
	});

</script>
</head>

<body>

	<form:form commandName="customerSearchVo" method="get"> <!-- ;;;test 'get' -->
		<form:hidden path="curPage"/>
		<form:hidden path="screenSize"/>
		
		<table border="1px">
			<tr>
				<th>SearchType</th>
				<td>
					<form:select path="searchType">
						<form:option value="cust_name">CUST_NAME</form:option>
						<form:option value="cust_email">CUST_EMAIL</form:option>
						<form:option value="cust_main_phone_int">CUST_MAIN_PHONE_INT</form:option>
						<form:option value="cust_id">CUST_ID</form:option>
					</form:select>
				</td>
				<td>
					<form:input path="searchText"/>
				</td>
				<td>
					<form:button id="searchsubmit" type="submit">SEARCH</form:button>
				</td>
			</tr>
		</table>
	</form:form>

	<!-- ;;;will edit -->
	<table border="1px">
		<thead>
			<tr>
				<th>CUST_ID</th>
				<th>CUST_NAME</th>
				<th>CUST_EMAIL</th>
				<th>CUST_MAIN_PHONE_INT</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">
				<tr>
					<c:url var="customerViewUrl" value="/customer/customerView">
						<c:param name="custId" value="${item.custId}" />
					</c:url>
					<td><a href="${customerViewUrl}">${item.custId}</a></td>
					<td>${item.custName}</td>
					<td>${item.custEmail}</td>
					<td>${item.custMainPhoneInt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<nav>
		<ul>
			<!-- // ;;Previous Button -->
			<c:if test="${customerSearchVo.startPage ne 1}">
				<li>
					<a href='#' aria-label='Previous' data-curpage='${customerSearchVo.startPage - 1}' class='prev goPage'>
						<span aria-hidden='true'>Prev</span>
					</a>
				</li>
			</c:if>

			<c:if test="${customerSearchVo.startPage eq 1}">
				<li>
					<a href='#' aria-label='Previous'>
						<span aria-hidden='true'>Prev</span>
					</a>
				</li>
			</c:if>
	
			<!-- // ;;Page Numbering -->
			<c:forEach var="i" begin="${customerSearchVo.startPage}" end="${customerSearchVo.endPage}">
				<c:choose>
					<c:when test="${i eq customerSearchVo.curPage}">
						<li class='activate'>
							<a href='#'>${i}</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class='activate'>
							<a href='#' data-curpage='${i}' class='goPage'>${i}</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
	
			<!-- // ;;Next Button-->
			<c:if test="${customerSearchVo.endPage lt customerSearchVo.totalPageCount}">
				<li>
					<a href='#' aria-label='Next' data-curpage='${customerSearchVo.endPage + 1}' class='next goPage'>
						<span aria-hidden='true'>Next</span>
					</a>
				</li>
			</c:if>
	
			<c:if test="${customerSearchVo.endPage ge customerSearchVo.totalPageCount}">
				<li>
					<a href='#' aria-label='Next'>
						<span aria-hidden='true'>Next</span>
					</a>
				</li>
			</c:if>
		</ul>
	</nav>	
</body>
</html>