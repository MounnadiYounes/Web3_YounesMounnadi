<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="scripts/app.js" defer></script>
    <script src="scripts/formValidation.js" defer></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
    <script src="scripts/passwordStrengthMeter.js" defer></script>
</head>
<body>
<div id="main">
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="Register"></jsp:param>
        </jsp:include>

            <c:if test="${not empty errors}">
                <div id="alert-danger">
                    <ul>
                        <c:forEach var="error" items="${errors}">
                            <li><c:out value="${error}"/></li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>

        <div class="container">
            <form method="POST" action="Controller?command=Add" novalidate="novalidate">
                <div><p><label for="userId">User id</label><input type="text" id="userId" name="userId" value="<c:out value="${userIdPrevious}"/>" required></p></div>
                <div><p><label for="firstName">First Name</label><input type="text" id="firstName" name="firstName" value="<c:out value="${firstNamePrevious}"/>" required></p></div>
                <div><p><label for="lastName">Last Name</label><input type="text" id="lastName" name="lastName" value="<c:out value="${lastNamePrevious}"/>" required></p></div>
                <div><p><label for="email">Email</label><input type="email" id="email" name="email" value="<c:out value="${emailPrevious}"/>" required></p></div>
                <div><p><label for="password">Password</label><input type="password" id="password" name="password" value="<c:out value="${passwordPrevious}"/>" required></p></div>
                <p>Password strength: <span id="password-strength-text">please enter a password</span></p>
                <meter max="4" id="password-strength-meter"></meter>

                <p><input type="submit" id="signUp" value="Sign Up"></p>
            </form>
        </div>
    <footer>&copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>
