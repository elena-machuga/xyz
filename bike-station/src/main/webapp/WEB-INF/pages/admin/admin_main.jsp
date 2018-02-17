<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<body>
<%@ include file="admin_header.jsp"%>

</body>
</html>