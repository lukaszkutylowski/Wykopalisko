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
			<a href="/">Główna</a>
		</div>
		<div class="navbar-button">
			<c:choose>
				<c:when test="${not empty username}">
					<a href="add">Dodaj</a>
				</c:when>
				<c:otherwise>
					<a href="login">Zaloguj, by dodać</a>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="navbar-button">
			<c:choose>
				<c:when test="${not empty username}">
					<a href="logout">Wyloguj się</a>
				</c:when>
				<c:otherwise>
					<a href="login">Zaloguj się</a>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="end"></div>
		
		<c:if test="${not empty discoveries}">
			<c:forEach var="discovery" items="${discoveries}">	
				<div class="wykopalisko">
					<div class="space"></div>
					<!--  funkcjonalność głosowania -->
					
					<c:choose>
						<c:when test="${not empty username}">
							<form action="/vote-up" method="post">
								<input type="hidden" name="discovery_id" value="${discovery.discovery_id}"/>
								<button type="submit" class="up-vote">Mocne: ${discovery.vote_up}</button>
							</form>
						</c:when>
						<c:otherwise>
							<a href="login"><button type="submit" class="up-vote">Mocne: ${discovery.vote_up}</button></a>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${not empty username}">
							<form action="/vote-down" method="post">
								<input type="hidden" name="discovery_id" value="${discovery.discovery_id}"/>
								<button type="submit" class="down-vote" >Słabe: ${discovery.vote_down}</button>
							</form>
						</c:when>
						<c:otherwise>
							<a href="login"><button type="submit" class="down-vote">Słabe: ${discovery.vote_down}</button></a>
						</c:otherwise>
					</c:choose>
					
					<div class="end"></div>
					<!-- koniec funkcjonalności -->
					<div class="title"><c:out value="${discovery.name}" /></div>
					<div class="description">
			   			<c:out value="${discovery.description}" />
			 		</div>
					<div class="link"><a href="<c:out value="${discovery.url}" />" target="_blank">${discovery.url}</a></div>
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