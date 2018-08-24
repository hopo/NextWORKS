<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>About</title>
<style type="text/css">
	body { background-image: url("/css/wall.jpg"); }
</style>
</head>

<body>
    <div id='container'>
        <!--
    * Daum 지도 - 약도서비스
    * 한 페이지 내에 약도를 2개 이상 넣을 경우에는
    * 약도의 수 만큼 소스를 새로 생성, 삽입해야 합니다.
    -->
        <!-- 1. 약도 노드 -->
        <div id="daumRoughmapContainer1527207676344" class="root_daum_roughmap root_daum_roughmap_landing"></div>
        <!-- 2. 설치 스크립트 -->
        <script charset="UTF-8" class="daum_roughmap_loader_script" src="http://dmaps.daum.net/map_js_init/roughmapLoader.js"></script>
        <!-- 3. 실행 스크립트 -->
        <script charset="UTF-8">
        new daum.roughmap.Lander({
            "timestamp": "1527207676344",
            "key": "oapo",
            "mapWidth": "800",
            "mapHeight": "400"
        }).render();
        </script>
    </div>
</body>
</html>
