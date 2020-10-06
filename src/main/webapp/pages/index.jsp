<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wykopalisko</title>
<link href="/pages/style.css" type="text/css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="navbar-brand">
			<div class="brand">Wykopalisko</div>
		</div>
		<c:choose>
				<c:when test="${not empty username}">
					<div class="login-info">Zalogowany jako: ${username}</div>
				</c:when>
				<c:otherwise>
					<div class="login-info">Niezalogowany</div>
				</c:otherwise>
			</c:choose>
		<div class="navbar-button">
			<a href="/"><button class="navbar-main-button">Główna</button></a>
		</div>
		<div class="navbar-button">
			<c:choose>
				<c:when test="${not empty username}">
					<a href="add"><button class="navbar-main-button">Dodaj</button></a>
				</c:when>
				<c:otherwise>
					<a href="login"><button class="navbar-main-button">Zaloguj, by dodać</button></a>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="navbar-button">
			<c:choose>
				<c:when test="${not empty username}">
					<a href="logout"><button class="navbar-main-button">Wyloguj się</button></a>
				</c:when>
				<c:otherwise>
					<a href="login"><button class="navbar-main-button">Zaloguj się</button></a>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="end"></div>
		
		<c:if test="${not empty discoveries}">
			<c:forEach var="discovery" items="${discoveries}">	
				<div class="wykopalisko">
					<div class="space"></div>
					<!--  funkcjonalność głosowania -->
					<form action="/vote-up" method="post">
						<input type="hidden" name="discovery_id" value="${discovery.discovery_id}"/>
						<button type="submit" class="up-vote">${discovery.vote_up}</button>
					</form>
					<form action="/vote-down" method="post">
						<input type="hidden" name="discovery_id" value="${discovery.discovery_id}"/>
						<button type="submit" class="down-vote" >${discovery.vote_down}</button>
					</form>
					<div class="end"></div>
					<!-- -->
					<div class="title"><c:out value="${discovery.name}" /></div>
					<div class="description">
			   			<c:out value="${discovery.description}" />
			 		</div>
					<div class="link"><a href="<c:out value="${discovery.url}" />" target="_blank">Przejdź do wykopaliska</a></div>
					<div class="space"></div>
				</div>
			</c:forEach>
		</c:if>
		
		<div class="footer">
			<p class="navbar-text">Wykopalisko - developed by Łukasz Kutyłowski | 2020</p>
		</div>
	</div>
	
</body>
</html>