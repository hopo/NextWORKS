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
<title>customerChart</title>

<script type="text/javascript" defer="defer">

    function fn_chart(xaxis, yaxis) {

	    var ctx = document.getElementById("myChart").getContext('2d');
	    var myChart = new Chart(ctx, {
	        type: 'bar',
	        data: {
	            labels: xaxis,
	            datasets: [{
	                label: "#",
	                data: yaxis,
	                backgroundColor: [
	                    'rgba(255, 99, 132, 0.2)',
	                    'rgba(54, 162, 235, 0.2)',
	                    'rgba(255, 206, 86, 0.2)',
	                    'rgba(75, 192, 192, 0.2)',
	                    'rgba(153, 102, 255, 0.2)',
	                    'rgba(255, 159, 64, 0.2)',
	                    'rgba(255, 99, 132, 0.2)',
	                    'rgba(54, 162, 235, 0.2)',
	                    'rgba(255, 206, 86, 0.2)',
	                    'rgba(75, 192, 192, 0.2)',
	                    'rgba(153, 102, 255, 0.2)',
	                    'rgba(255, 159, 64, 0.2)'
	                ],
	                borderColor: [
	                    'rgba(255,99,132,1)',
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 206, 86, 1)',
	                    'rgba(75, 192, 192, 1)',
	                    'rgba(153, 102, 255, 1)',
	                    'rgba(255, 159, 64, 1)',
	                    'rgba(255,99,132,1)',
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 206, 86, 1)',
	                    'rgba(75, 192, 192, 1)',
	                    'rgba(153, 102, 255, 1)',
	                    'rgba(255, 159, 64, 1)'
	                ],
	                borderWidth: 1
	            }]
	        },
	        options: {
	            scales: {
	                yAxes: [{
	                    ticks: {
	                        beginAtZero:true
	                    }
	                }]
	            }
	        }
	    });
	}

    // ;===== for ajax jQuery ========
	$(document).ready(function() {

		$("#showChart").on("change", function(event) {
			event.preventDefault();
			//alert("@@@ Btn Click!!!");
			$("#chartDiv").empty();

			$.ajax({
				url				: '/customer/customerChartProc',
				method			: "POST",
				dataType		: 'json',
				data			: $('#chartForm').serialize(),
				success			: function(data, status, xhr) {
					//alert("###ajax success: " + JSON.stringify(data.items));
					var xaxis = [];
					var yaxis = [];
					
					for(e of data.items) {
						xaxis.push(e.xaxis);
						yaxis.push(e.count);
					}
						
					/*
					$.each(data.items, function(key, value){
						dt_labels.push(key);
						dt_data.push(value);
					});
					*/
					fn_chart(xaxis, yaxis);
				},
				error			: function(jqXhr, textStatus, errorMessage) {
					alert("@@@ ajax error");
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});
		});
	});
    // ;=================================
</script>

</head>

<body>
	<form id="chartForm">
			x-axis :
			<select id="showChart" name="fr_xaxis" class="form-control form-control-lg">
				<option value="" disabled="disabled" selected>선택하세요..</option>
				<option value="cust_income_level">고객 수입 레벨</option>
				<option value="cust_credit_limit">고객 카드 한도</option>
				<option value="cust_gender">고객 성별</option>
				<option value="cust_year_of_birth">고객 생년도</option>
			</select>
	</form>

	<canvas id="myChart" style="max-width:800px;"></canvas>
	
	<!-- // ;for chart ====== -->
    <script type="text/javascript" src="/MDB/js/popper.min.js"></script>
    <script type="text/javascript" src="/MDB/js/mdb.min.js"></script>
	<!-- ==================== -->
	
</body>
</html>