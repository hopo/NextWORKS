<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">
				<p>
					<img src="/css/favicon.ico" height="28">&nbsp;&nbsp;&nbsp;NextIT Customer Manager
				</p>
			</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${loginInfo eq null}">
						<li>
							<a href="/about">About</a>
						</li>
					</c:when>

					<c:when test="${loginInfo ne null}">

						<c:if test="${loginInfo.privilCode eq 'S' || loginInfo.privilCode eq 'A' }">
							<li>
								<span class="dropdown blog-nav-item">
			  						<a class="dropdown-toggle blog-nav-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
			    						MEMBER<span class="caret"></span>
			  						</a>
									<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu4">
									  <li role="presentation">
									  	<a role="menuitem" tabindex="-1" href="/member/memberList">회원 목록</a>
									  </li>
									  <li role="presentation">
									  	<a role="menuitem" tabindex="-1" href="/member/memberCreate">회원 등록</a>
									  </li>
									</ul>
								</span>
							</li>
						</c:if>

						<li>
							<span class="dropdown blog-nav-item">
		  						<a class="dropdown-toggle blog-nav-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
		    						CUSTOMER<span class="caret"></span>
		  						</a>
								<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu4">
								  <li role="presentation">
								  	<a role="menuitem" tabindex="-1" href="/customer/customerList">고객 목록</a>
								  </li>
								  <li role="presentation">
								  	<a role="menuitem" tabindex="-1" href="/customer/customerChart">고객 차트</a>
								  </li>
								</ul>
							</span>
						</li>

						<li>
							<span class="dropdown blog-nav-item">
		  						<a class="dropdown-toggle blog-nav-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
		    						${loginInfo.memId}<span class="glyphicon glyphicon-option-vertical" aria-hidden="true"></span>
		  						</a>
								<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu4">
								 	<li role="presentation">
								  		<a role="menuitem" tabindex="-1" href="/session/loginInfo">접속자 정보</a>
								  	</li>
								  	<li role="presentation" class="disabled">
								  		<a role="menuitem" tabindex="-1" href="#">지구폭파</a>
								  	</li>
								  	<li role="presentation" class="divider"></li>
								 	 <li role="presentation">
								 	 	<a role="menuitem" tabindex="-1" href="/session/logout">로그아웃</a>
								  </li>
								</ul>
							</span>
						</li>
					</c:when>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>