<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<fmt:setBundle basename="language.lang" var="lang" />
<fmt:setLocale value="${sessionScope.locale}" />
<title></title>
</head>
<body>
	<nav class="navbar navbar-fixed-bottom navbar-inverse">
		<div class="container-fluid">
			<p class="text-muted" align="right">© 2018 Pedaly.by</p>
			<form action="bikes" method="post"
				style="float: right; margin-right: 5px;">
				<input type="hidden" name="action" value="change_language" /> <input
					type="hidden" name="lang" value="en" /> <input type="image"
					src="IMG/flag_en.gif">
			</form>
			<form action="bikes" method="post"
				style="float: right; margin-right: 5px;">
				<input type="hidden" name="action" value="change_language" /> <input
					type="hidden" name="lang" value="ru" /> <input type="image"
					src="IMG/flag_ru.png">
			</form>
			<form action="bikes" method="post"
				style="float: right; margin-right: 5px;">
				<input type="hidden" name="action" value="change_language" /> <input
					type="hidden" name="lang" value="be" /> <input type="image"
					src="IMG/flag_by.png">
			</form>
		</div>
	</nav>
</body>
</html>