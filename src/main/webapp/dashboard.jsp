<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="main">
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="Dashboard"></jsp:param>
        </jsp:include>

            <div>
                <main>
                <c:choose>
                    <c:when test="${not empty user}">
                        <p>User id: ${user.userid}</p>
                        <p>Email: ${user.email}</p>
                        <p>First name: ${user.firstName}</p>
                        <p>Last name: ${user.lastName}</p>

                        <br>

                    <div class="container">
                        <form method="POST" action="Controller?command=ChangePasswordForm">
                            <p><input type="submit" id="changePassword" value="Change your password"></p>
                        </form>
                        <form method="POST" action="Controller?command=DeleteAccountConfirmation">
                            <p><input type="submit" id="deleteAccount" value="Delete your account"></p>
                        </form>
                    </div>

                        <br>

                        <p>Registered on: ${user.getRegisterDateTimeToString()}</p>
                        <p>Last logged in on: ${user.getlastLoginDateTimeToString()}</p>
                        <p>Amount of times logged in: ${user.amountOfTimesLoggedIn}</p>
                    </c:when>
                    <c:otherwise>
                        <p>You are not logged in!</p>
                    </c:otherwise>
                </c:choose>
        </main>
    </div>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>