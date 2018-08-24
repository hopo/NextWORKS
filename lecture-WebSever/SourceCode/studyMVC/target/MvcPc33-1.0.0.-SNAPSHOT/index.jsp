<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>studyMVC</title>
</head>

<body>
	<div class="row">
		<div class="col-sm-12 blog-main">
			<div id="opening"></div>
		</div>
	</div>
	<script>
		"use strict"
		var openingDiv = document.querySelector('#opening');
		var text = 'all work and no play makes jack a dull boy';
		var textArr = text.split(' ');
		var num = 0;
		var bound = 20;

		function opening() {
			if (num == textArr.length) {
				num = 0;
				bound--;
				if (bound < 0) {
					openingDiv.textContent = '';
					bound = 10;
				}
			}
			var each = textArr[num++] + ' ';
			var text = document.createTextNode(each);
			openingDiv.appendChild(text);

			setTimeout(opening, 70);
		}
		opening();
	</script>
</body>
</html>
