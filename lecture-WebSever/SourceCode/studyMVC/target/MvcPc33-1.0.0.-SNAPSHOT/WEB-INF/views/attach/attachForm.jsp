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
<title>Insert title here</title>

<script type="text/javascript">
	$(document).ready(function() {
		
		$('.btn_file_new').on('click', function(){
			var fileView = '';
			fileView = '<div>';
			fileView += '<input type="file" name="attachFiles">';
			fileView += '<input type="button" class="btn_file_remove form-control" value="삭제">';
			fileView += '</div>';
			
			$('.file_area').append(fileView);
		});
		
		// ;new file remove
		$('.file_area').on('click', '.btn_file_remove', function() {
			$(this).parent().remove();
		});

	});
	
	
	// ;sol01)
	$('#idBoardForm').on('submit', function() {
		if (!/[\w가-힇]+/.test($('input[name="boTitle"]').val())) {
			alert("제목은 최소 한글자 이상 입력");
			return false;
		}
		
		if (!/^[가-힇]+$/.test($('input[name="boWriter"]').val())) {
			alert("작성자는 한글만 입력");
			return false;
		}

		return true;
	});


	/*
	// ;sol02) no using jQuery
	function checkForm(frm) {
		if (!/[\w가-힇]+/.test($('input[name="boTitle"]').val())) {
			alert("제목은 최소 한글자 이상 입력");
			return false;
		}
		
		if (!/^[가-힇]+$/.test($('input[name="boWriter"]').val())) {
			alert("작성자는 한글만 입력");
			return false;
		}

		return true;
	}
	*/
</script>
</head>

<body>

	<div>
		<blockquote>
			<form:form commandName="idBoardForm" action="/attach/attachProc" method="post" enctype="multipart/form-data"> <!-- upload: method와 enctype 중요 -->
			<%-- <form:form commandName="idBoardForm" action="/attach/attachProc" method="post" enctype="multipart/form-data" onsubmit="return checkForm(this); return false;"> --%>
				<table class="table">
					<colgroup>
						<col style="width: 20%;" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th>제목</th>
							<td><input name="boTitle" size="60" value="${postItem.title}"></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td><input name="boWriter" size="15" value="${postItem.name}"></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td>
								<div class="file_area">
									<div>
										<input type="button" class="btn_file_new form-control" value="추가">
									</div>
									<div>
										<input type="file" name="attachFiles" class="form-control">
										<input type="button" class="btn_file_remove form-control" value="삭제">
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button type="submit" id="btn_submit">파일업로드</button>
							</td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</blockquote>
	</div>
</body>
</html>