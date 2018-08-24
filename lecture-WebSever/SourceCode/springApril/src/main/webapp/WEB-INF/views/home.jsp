<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>The time on the server is ${serverTime}</title>
<style type="text/css">
	body { background-image: url("/css/wall2.jpg"); }
</style>
</head>

<body>
	<div class="row">
		<div class="col-sm-12 blog-main">
			<div id="opening" style="font-size:2em; color: white;"></div>
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
