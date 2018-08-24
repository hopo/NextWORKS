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
<title>mberJoinForm</title>

<script type="text/javascript">
	$(document).ready(function() {

		$("button[name=joinIdCheck]").on("click", function(e) {
			e.preventDefault();

			$.ajax({
				url			: '/mber/joinIdCheck',
				method		: "POST",
				dataType	: 'json',	// ;resp 데이터
				data		: $('#joinFrm').serialize(),
				success		: function(data, status, xhr) { 	// ;성공시 콜백함수
					console.log(data);
					console.log(data.message);
					if (data.result) {
						var checkId = $("input[name=memId]").val();
						$('input[name=idAt]').val(checkId);
					}
				},
				error		: function(jqXhr, textStatus, errorMessage) { // ;에러 콜백함수
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});
		});
		

		/*
		// ;solA)
		$("#joinFrm").on("click", function(e) {
			e.preventDefault();
			console.log("@@@ 제이슨 이벤트 발생");

			$.ajax({
				url			: '/mber/joinMberProc',
				method		: "POST",
				dataType	: 'json',
				data		: $('#joinFrm').serialize(),
				success		: function(data, status, xhr) {
					console.log("@@@", data);
					console.log("@@@", data.message);
				},
				error		: function(jqXhr, textStatus, errorMessage) {
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});
		});
		*/
		

		// ;solB) ajaxSubmit file(multipart) 가능, plugin
		$("#joinFrm").on("submit", function(e) {

			e.preventDefault();
			alert("@@@ 제이슨 이벤트 발생");

			if ($("input[name=memId]").val() == "") {
				if ($("input[name=memId]").val() != $("input[name=idAt]").val()) {
					alert("@@@ 아이디 중복 확인 해주라")
				}
				return false;
			}

			$("#joinFrm").ajaxSubmit({
				url 			: '/mber/joinMberProc',
				type			: 'POST',
				dataType		: 'json',
				processData 	: false,
				contentType 	: false,
				success 		: function(data, status, $form) {	// jQuery 1.4+ signature
					console.log("@@@", data);
					alert("@@@" + JSON.stringify(data));
					if(data.result) {
						$("input[name=idAt]").val("");
					}
				}
			});
		});
	});
</script>


</head>

<body>

	<div class="row">
		<div class="col-sm-12 blog-main">

			<form id="joinFrm" name="joinFrm" method="post" enctype="multipart/form-data">
				<input name="idAt">
				<input name="flag" type="hidden" value="insert">

				<table class="table">
					<tr>
						<th>아이디</th>
						<td>
							<input name='memId' class="form-control">
							<button type="button" name="joinIdCheck">중복체크</button>
						</td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input name='memPwd' type='password' value='1111' class="form-control"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input name='memName' value='nameTest' class="form-control"></td>
					</tr>
					<tr>
						<th>전화</th>
						<td><input name='memPhone' value='02-2222-2222' class="form-control"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input name='memEmail' type='email' value='test@email.com' class="form-control"></td>
					</tr>
					<tr>
						<th>증명사진</th>
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
							<input type='submit' class="form-control">
						</td>
					</tr>
				</table>
			</form>

		</div>
	</div>
</body>
</html>