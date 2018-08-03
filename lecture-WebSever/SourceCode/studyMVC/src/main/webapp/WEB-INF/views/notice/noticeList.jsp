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
<title>공지사항 리스트</title>

<script type="text/javascript" defer='defer'>
	// ;;;java script tag attribure 'defer'

	// !paging
	$(document).ready(function() {
		$frm = $('#noticeSearchVo');

		// ;;서브밋 버튼 클릭시
		$('button[type=submit]', $frm).click(function(e) {
			e.preventDefault();
			$('input[name=curPage]', $frm).val(1);
			$frm.submit();
		});

		// ;;페이지 네비 버튼 클릭시
		$('.goPage').click(function() {
			var curPage = $(this).data('curpage');
			$('#curPage').val(curPage);
			$frm.submit();
		});
	});
</script>
</head>

<body>

	<form:form commandName="noticeSearchVo" method="post">
		<form:hidden path="curPage" />
		<form:hidden path="screenSize" />

		<table class="table">
			<tr>
				<th>조회 조건(search): 타입</th>
				<td><form:select path="searchType" cssClass="form-control">
						<form:option value="title">제목</form:option>
						<form:option value="board_type">게시판타입</form:option>
						<form:option value="reg_user">등록자</form:option>
					</form:select></td>
				<td><form:input path="searchText" cssClass="form-control" /></td>
				<td><form:button type="submit" cssClass="form-control">SEARCH</form:button></td>
			</tr>
		</table>
	</form:form>






	<table class="table">
		<thead>
			<tr>
				<th>순번</th>
				<th>게시판타입</th>
				<th>등록자</th>
				<th>제목</th>
				<th>조회수</th>
				<th>등록일</th>
				<th>수정일</th>
			</tr>
		</thead>

		<c:forEach var="item" items="${result}">
			<tbody>
				<tr>
					<c:url value="/notice/noticeView" var="noticeViewUrl">
						<c:param name="idx" value="${item.idx}" />
						<c:param name="curPage" value="${noticeSearchVo.curPage}" />
					</c:url>
					<td><a href="${noticeViewUrl}">${item.rnum}</a></td>
					<td>${item.boardType}</td>
					<td>${item.regUser}</td>
					<td><a href="${noticeViewUrl}">${item.title}</a></td>
					<td>${item.readCount}</td>
					<td>${item.regDate}</td>
					<td>${item.upDate}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>



	<nav>
	<ul class='pagination pagination-lg'>

		<!-- // ;;Previous button -->
		<c:if test="${noticeSearchVo.startPage ne 1}">
			<li><a href='#' aria-label='Previous' data-curpage='${noticeSearchVo.startPage - 1}' class='prev goPage'> <span aria-hidden='true'>Prev</span>
			</a></li>
		</c:if>

		<c:if test="${noticeSearchVo.startPage eq 1}">
			<li><a href='#' aria-label='Previous'> <span aria-hidden='true'>Prev</span>
			</a></li>
		</c:if>

		<!-- // ;;Page numbering -->
		<c:forEach var="i" begin="${noticeSearchVo.startPage}" end="${noticeSearchVo.endPage}">
			<c:choose>
				<c:when test="${i eq noticeSearchVo.curPage}">
					<li class='activate'><a href='#'>${i}</a></li>
				</c:when>
				<c:otherwise>
					<li class='activate'><a href='#' data-curpage='${i}' class='goPage'>${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<!-- // ;;Next button-->
		<c:if test="${noticeSearchVo.endPage lt noticeSearchVo.totalPageCount}">
			<li><a href='#' aria-label='Next' data-curpage='${noticeSearchVo.endPage + 1}' class='next goPage'> <span aria-hidden='true'>Next</span>
			</a></li>
		</c:if>

		<c:if test="${noticeSearchVo.endPage ge noticeSearchVo.totalPageCount}">
			<li><a href='#' aria-label='Next'> <span aria-hidden='true'>Next</span>
			</a></li>
		</c:if>

	</ul>
	</nav>

</body>
</html>