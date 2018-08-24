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
			<a class="navbar-brand" href="/home">
				<span style="font-size:1.5em;">NEXTIT CUSTOMER MANAGER</span>
			</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${loginInfo eq null}">
						<li>
							<a href="#">About</a>
						</li>
					</c:when>
					<c:when test="${loginInfo ne null}">
						<li>
							<a href="/member/memberList">memberList</a>
						</li>
						<li>
							<a href="/member/memberCreate">memberCreate</a>
						</li>
						<li>
							<a href="/customer/customerList">customerList</a>
						</li>
						<li>
							<span class="dropdown blog-nav-item">
		  						<a class="dropdown-toggle blog-nav-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
		    						Account<span class="caret"></span>
		  						</a>
								<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu4">
								  <li role="presentation">
								  	<a role="menuitem" tabindex="-1" href="/session/loginInfo">Login Info</a>
								  </li>
								  <li role="presentation" class="disabled">
								  	<a role="menuitem" tabindex="-1" href="#">Disabled link</a>
								  </li>
								  <li role="presentation" class="divider"></li>
								  <li role="presentation">
								  	<a role="menuitem" tabindex="-1" href="/session/logout">Logout</a>
								  </li>
								</ul>
							</span>
						</li>
					</c:when>
				</c:choose>
			</ul>
			<%--
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
 			--%>
		</div>
	</div>
</nav>



<!--
<div id="navi" class="blog-masthead">
	<div class="container">
		<nav class="blog-nav">
		
			<del>*** springApril ***</del>
			<div>${loginInfo ne null ? loginInfo.memId : '-' } - ${loginInfo.privilCode}</div>
			
			<a href="/home">home</a>
			<a href="/member/memberList">memberList</a>
			<a href="/member/memberCreate">memberCreate</a>
			<a href="/customer/customerList">customerList</a>
			<c:choose>
				<c:when test="${loginInfo eq null}">
					<a href="/session/login">Login</a>
				</c:when>
				<c:when test="${loginInfo ne null}">
					<a href="/session/logout">Logout</a>
				</c:when>
			</c:choose>
		</nav>
	</div>
</div>
<hr>
 -->