<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script src="scripts/app.js" defer></script>
</head>
<body>
<div id="main">
	<jsp:include page="header.jsp">
		<jsp:param name="page" value="Home"></jsp:param>
	</jsp:include>

		<c:if test="${not empty error}">
			<div id="alert-danger">
				<ul>
					<li><c:out value="${error}"/></li>
				</ul>
			</div>
		</c:if>

		<c:if test="${not empty success}">
			<div id="alert-success">
				<ul>
					<li><c:out value="${success}"/></li>
				</ul>
			</div>
		</c:if>

		<c:choose>
			<c:when test="${not empty user}">
				<p>Welcome, <c:out value="${user.userid}"/>!</p>
				<br>
				<form action="Controller?command=Logout" method="POST">
					<p><input type="submit" id="logout" value="Log out"></p>
				</form>
			</c:when>
			<c:otherwise>
				<form action="Controller?command=Login" method="POST">
					<p><label for="userId">Your user id</label><input type="text" id="userId" name="userId" value="<c:out value="${userIdPrevious}"/>" required></p>
					<p><label for="password">Your password</label><input type="password" id="password" name="password" required></p>
					<p><input type="submit" id="login" value="Log in"></p>
				</form>
			</c:otherwise>
		</c:choose>
	<footer>&copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>