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
<link href="/CSS/sticky-footer.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/JS/inputValidation.js"></script>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="language.lang" var="lang" />
<fmt:message bundle="${lang}" key="page.title" var="title" />
<fmt:message bundle="${lang}" key="text.greeting" var="greeting" />
<fmt:message bundle="${lang}" key="text.main" var="main" />
<fmt:message bundle="${lang}" key="link.signup" var="signup" />
<fmt:message bundle="${lang}" key="link.login" var="login" />
<fmt:message bundle="${lang}" key="text.closingline" var="closingline" />
<fmt:message bundle="${lang}" key="title.registration"
	var="registration" />
<fmt:message bundle="${lang}" key="field.emailnote" var="emailnote" />
<fmt:message bundle="${lang}" key="field.name" var="name" />
<fmt:message bundle="${lang}" key="field.email" var="email" />
<fmt:message bundle="${lang}" key="field.address" var="address" />
<fmt:message bundle="${lang}" key="field.phone" var="phone" />
<fmt:message bundle="${lang}" key="field.repassword" var="repassword" />
<fmt:message bundle="${lang}" key="field.password" var="password" />
<fmt:message bundle="${lang}" key="btn.register" var="register" />
<fmt:message bundle="${lang}" key="title.logination" var="logination" />
<title><c:out value="${title}" /></title>
</head>
<body marginheight="175px" bgcolor="">

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="bikes?action=go_to_guest_welcome_page">${title}</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a data-toggle="modal" data-target="#registerModal"
					style="cursor: pointer;"><span class="glyphicon glyphicon-user"></span>
						${signup}</a></li>
				<li><a data-toggle="modal" data-target="#loginModal"
					style="cursor: pointer;"><span
						class="glyphicon glyphicon-log-in"></span> ${login}</a></li>
			</ul>
		</div>
	</nav>

	<!-- Register Modal -->
	<div id="registerModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">${registration}</h4>
				</div>
				<div class="modal-body">
					<form action="bikes" method="post">
						<input type="hidden" name="action" value="register" />
						<div class="form-group">
							<label for="email">${emailnote}</label> <input type="email"
								class="form-control" name="new_user_login">
						</div>
						<div class="form-group">
							<label for="pwd">${password}</label> <input type="password"
								class="form-control" name="new_user_password" id="pass">
						</div>
						<div class="form-group">
							<label for="pwd">${repassword}</label> <input type="password"
								class="form-control" name="new_user_repassword" id="repPass">
						</div>
						<div id="errorBlock"></div>
						<div class="form-group">
							<label for="name">${name}</label> <input type="text"
								class="form-control" name="new_user_name">
						</div>
						<div class="form-group">
							<label for="name">${address}</label> <input type="text"
								class="form-control" name="new_user_address">
						</div>
						<div class="form-group">
							<label for="name">${phone}</label> <input type="tel"
								class="form-control" name="new_user_phone">
						</div>
						<button type="submit" class="btn btn-default">${register}</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Login Modal -->
	<div id="loginModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">${logination}</h4>
				</div>
				<div class="modal-body">
					<form action="bikes" method="post">
						<input type="hidden" name="action" value="login" />
						<div class="form-group">
							<label for="email">${email}</label> <input type="email"
								class="form-control" name="user_login">
						</div>
						<div class="form-group">
							<label for="pwd">${password}</label> <input type="password"
								class="form-control" name="user_password">
						</div>
						<button type="submit" class="btn btn-default">${login}</button>
					</form>
				</div>
			</div>

		</div>
	</div>

	<div class="container">
		<h3>${greeting}</h3>
		<p>${main}</p>
		<p>${closingline}</p>
	</div>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="IMG/happy3.jpg" alt="Chicago" style="width: 100%;">
			</div>
			<div class="item">
				<img src="IMG/happy4.jpg" alt="New York" style="width: 100%;">
			</div>
			<div class="item">
				<img src="IMG/happy5.jpg" alt="New York" style="width: 100%;">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
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