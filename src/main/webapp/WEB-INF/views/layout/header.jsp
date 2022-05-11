<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous"
	referrerpolicy="no-referrer"></script>
<script src="https://unpkg.com/vue@next"></script>
<script src="https://unpkg.com/vuex"></script>
<title>sbjpa</title>
</head>
<body>
	<div>
		<nav>
			<a href="/">index</a> <span> | </span>

			<c:choose>
				<c:when test="${!empty sessionScope.principal }">
					<span>로그인 : ${sessionScope.principal.userName }</span>
					<span> | </span>
					<a href="/logout">logout</a>
				</c:when>
				<c:otherwise>
					<a href="/login">log in</a>
					<span> | </span>
					<a href="/signup">sign up</a>
					<span> | </span>
				</c:otherwise>
			</c:choose>

			<a href="/index2">index2</a>

		</nav>
	</div>