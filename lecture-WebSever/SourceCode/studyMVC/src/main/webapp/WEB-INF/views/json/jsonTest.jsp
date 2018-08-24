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
<title>jsonTest.jsp</title>

<script type="text/javascript">

	$(document).ready(function() {
		
		// ;검색폼 저장 클릭(on submit) using JSON
		// ;;Ref) https://github.com/jquery-form/form	
		$('#idBoardForm').on('submit', function(evt) {
			evt.preventDefault(); // ;;;이벤트 전파막기

			$(this).ajaxSubmit({
				type: 'POST',
				url : '/json/attachProc',
				data : $('#idBoardForm').serialize(),
				success : function(msg) {
					alert(JSON.stringify(msg));
				},
				error : function(jqXhr, textStatus, errorMessage) {
					alert(errorMessage);	
				}
			});

			return false;
		});
		
		// ;'.btn_file_new' on clic k => 파입업로드 원 세트 추가
		$('.btn_file_new').on('click', function(){
			var fileView = '';
			fileView = '<div>';
			fileView += '<input type="file" name="attachFiles">';
			fileView += '<input type="button" class="btn_file_remove form-control" value="삭제">';
			fileView += '</div>';
			
			$('.file_area').append(fileView);
		});
		
		// ;'.file_area' on click => 파입업로드 원 세트 삭제
		$('.file_area').on('click', '.btn_file_remove', function() {
			$(this).parent().remove();
		});

		
		

		// ;test1
		$('#btn_responseEntity').on('click', function() {
			var params = $("#idBoardForm").serialize();
			
			$.ajax('/json/responseEntity', {
				method : "POST",
				dataType: 'json', // ;;;type of response data
				data : params,
				success :  function(data, status, xhr) { // ;;;success callback function
					$("input[name=boTitle]").val(data.memName);
					console.log('responseEntity', data);
					//console.log(statuus);
					//console.log(xhr);
					//alert(JSON.stringify(data));
				},
				error : function(jqXhr, textStatus, errorMessage) { // ;;;error callback
					alert(errorMessage);
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});

			return false;
		});

		// ;test2
		$('#btn_responseEntity2').on('click', function() {
			
			$.ajax('/json/responseEntity2', {
				method : "POST",
				dataType: 'json',
				data : $("#idBoardForm").serialize(),
				success :  function(data, status, xhr) {
					$("input[name=boTitle]").val(data.memName);
					console.log('responseEntity2', data);
				},
				error : function(jqXhr, textStatus, errorMessage) {
					alert(errorMessage);
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});

			return false;
		});

		// ;test3
		$('#btn_responseEntity3').on('click', function() {
			$.ajax('/json/responseEntity3', {
				method : "POST",
				dataType: 'json',
				data : $('#idBoardForm').serialize(),
				success :  function(data, status, xhr) {
					console.log('responseEntity3', data);
				
					$('#testDisplay').empty();
					
					$.each(data, function(key, value){
						console.log(value)
						
						var rs = '';
						rs += '<tr>';
						rs += '<th>' + key + '</th>';
						rs += '<th>' + value.memName + '</th>';
						rs += '</tr>';
							
						$('#testDisplay').append(rs);
					});
				},
				error : function(jqXhr, textStatus, errorMessage) {
					alert(errorMessage);
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});

			return false;
		});

		// ;test4. 가장 많이 사용하는 케이스 HashMap<String, Object>
		$('#btn_responseEntity4').on('click', function() {
			$.ajax('/json/selectList', {
				method : "POST",
				dataType: 'json',
				data : $('#idBoardForm').serialize(),
				success :  function(data, status, xhr) {
					console.log('responseEntity4', data);
					alert("true? false? : " + data.result);

					if (data.result) {
						$('#testDisplay').empty();
						$.each(data.resultList, function(key, value){
							console.log(value)

							var rs = '';
							rs += '<tr>';
							rs += '<th>' + key + '</th>';
							rs += '<th>' + value.memName + '</th>';
							rs += '</tr>';
								
							$('#testDisplay').append(rs);
						});
						
					} else {
						console.log("NO RECORD")
					}
					
				},
				error : function(jqXhr, textStatus, errorMessage) {
					alert(errorMessage);
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});

			return false;
		});

	});
</script>
</head>

<body>
	<div>
		<blockquote>
	
		<table>
			<tbody>
				<tr>
					<th><button id="btn_responseEntity">TEST-responseEntity</button></th>
					<th><button id="btn_responseEntity2">TEST-responseEntity2</button></th>
					<th><button id="btn_responseEntity3">TEST-responseEntity3</button></th>
					<th><button id="btn_responseEntity4">TEST-responseEntity4</button></th>
				</tr>
			</tbody>
		</table>	
		
		
		<table class="table">
			<tbody id="testDisplay">
				
			</tbody>			
		</table>
	
			<!-- // ;파일 upload 시: method와 enctype 중요 -->
			<form:form commandName="idBoardForm" action="/attach/attachProc" method="post" enctype="multipart/form-data">
				<table class="table">
					<colgroup>
						<col style="width: 20%;" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th>제목</th>
							<td><input name="boTitle" size="60"></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td><input name="boWriter" size="15"></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td>
								<div class="file_area">
									<div>
										<input type="button" class="btn_file_new form-control" value="추가">
									</div>
									<div>
										<input type="file" name="attachFiles" class="form-control"> <input type="button" class="btn_file_remove form-control" value="삭제">
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
