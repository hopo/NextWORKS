<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberList</title>

<script>

	// ; tern eclipse 플러그인 설치 하세요
	$(document).ready(function() {
		$frm = $('#searchFrm');
		
		// ;;서브밋 버튼 클릭시
		$('button[type=submit]', $frm).click(function(event){
			event.preventDefault();	// ;;;이벤트 전파 막기
			$('input[name=curPage]', $frm).val(1);
			$frm.submit();
			
		});
		
		// ;;페이지 네비 버튼 클릭시
		$('.goPage').click(function(){
			var curPage = $(this).data("curpage");
			$('#curPage').val(curPage);
			$frm.submit();
		});

	});

</script>


</head>

<body>

	<div class="row">
		<div class="col-sm-12 blog-main">
		<blockquote>

			<c:url var="searchUrl" value="/member/memberList.do"/>

			<form name="searchFrm" id="searchFrm" action="${searchUrl}" method="post">

			curPage: <input name="curPage" id="curPage" value="${search.curPage}">
			screenSize: <input name="screenSize" id="screenSize" value="${search.screenSize}">

			<table class="table">
				<tr>
					<th>조회 조건 : 타입</th>
					<td>
						<select name="searchType" class="form-control">
							<option value="mem_id" ${param.searchType eq 'mem_id' ? 'selected' : ''}>아이디</option>
  							<option value="mem_pwd" ${param.searchType eq 'mem_pwd' ? 'selected' : ''}>비밀번호</option>
   							<option value="mem_name" ${param.searchType eq 'mem_name' ? 'selected' : ''}>회원명</option>
 							<option value="mem_phone" ${param.searchType eq 'mem_phone' ? 'selected' : ''}>전번</option>
						</select>
					</td>
					<td><input name="searchText" value="${param.searchText}"></td>
					<td><input type="submit" value="SEARCH"></td>
				</tr>
			</table>
			</form>

			<table class="table">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>이메일</th>
						<th>가입일</th>
						<th>접속아이피</th>
						<th>탈퇴여부</th>
					</tr>
				</thead>

				<c:forEach var="item" items="${result}">
					<tbody>
						<tr>
							<!-- ;a tag url에 parameter value 붙이기 -->
							<c:url value="/member/memberView.do" var="memberViewUrl">
								<c:param name="memId" value="${item.memId}" />
								<c:param name="curPage" value="${search.curPage}" />
							</c:url>
							<td><a href="${memberViewUrl}">${item.memId}</a></td>
							<td>${item.memName}</td>
							<td>${item.memPhone}</td>
							<td>${item.memEmail}</td>
							<td>${item.regDate}</td>
							<td>${item.memIp}</td>
							<td>${item.delAt}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
			
			<div class="paging">
				<!-- // 이전 button -->	
				<c:if test="${search.startPage ne 1}">
					<a href="#" data-curpage="${search.startPage - 1}" class="prev goPage">PREV</a>
				</c:if>
				
				<!-- // 넘버링 -->	
				<c:forEach var="i" begin="${search.startPage}" end="${search.endPage}">
					<c:if test="${i eq search.curPage}">${i}</c:if>
					<c:if test="${i ne search.curPage}">
						<a href="#" data-curpage="${i}" class="goPage">${i}</a>		
					</c:if>
				</c:forEach>

				<!-- // 다음 button -->	
				<c:if test="${search.endPage lt search.totalPageCount}">
					<a href="#" data-curpage="${search.endPage + 1}" class="next goPage">NEXT</a>
				</c:if>
				<c:if test="${search.endPage >= search.totalPageCount}">
					NEXT
				</c:if>
			</div>

		</blockquote>
		</div>
	</div>

</body>
</html>