<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wykopalisko - dodaj nowe treści</title>
<link href="/pages/style.css" type="text/css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="navbar-brand">
			<div class="brand">Wykopalisko</div>
		</div>
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
	
	
		<div class="login-register-bar">
			<form action="add-form" method="post">
				<h2>Dodaj nowe znalezisko</h2>
				<input name="inputName" type="text" class="form-control"
					placeholder="Co dodajesz?" required="required">
				<input name="inputUrl" type="text" class="form-control"
					placeholder="URL" required="required">
				<textarea name="inputDescription" rows="5" class="form-control"
					placeholder="Opis" required="required"></textarea>
				<button class="apply-button" type="submit">Dodaj!</button>
			</form>
		</div>
		
		<div class="footer">
			<p class="navbar-text">Wykopalisko - developed by Łukasz Kutyłowski | 2020</p>
		</div>
	</div>

</body>
</html>