<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wykopalisko</title>
<link href="/pages/style.css" type="text/css" rel="stylesheet">
<body>

	<div class="container">
		<div class="navbar-brand">
			<div class="brand">Wykopalisko</div>
		</div>
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
	
	
		<div class="login-register-bar">
			<h2>Zarejestruj się</h2>
			<form action="register-form" method="post">
				<input name="username" type="text" class="form-control"
					placeholder="Nazwa użytkownika..." required="required">
				<input name="password" type="password" class="form-control"
					placeholder="Hasło..." required="required">
				<button class="apply-button" type="submit">Zarejestruj</button> 
				<a href="login" style="color: red;">Zaloguj</a>
			</form>
		</div>
		
		<div class="footer">
			<p class="navbar-text">Wykopalisko - developed by Łukasz Kutyłowski | 2020</p>
		</div>
	</div>

</body>
</html>