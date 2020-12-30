<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="scripts/app.js" defer></script>
</head>
<body>
<div id="main">
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="Dashboard"/>
        </jsp:include>

        <main>
                <p>User id: <c:out value="${user.userid}"/></p>
                <p>Email: <c:out value="${user.email}"/></p>
                <p>First name: <c:out value="${user.firstName}"/></p>
                <p>Last name: <c:out value="${user.lastName}"/></p>
                <p>Role: <c:out value="${user.role}"/></p>

                <br>

                <form method="POST" action="Controller?command=ChangePasswordForm">
                    <p><input type="submit" id="changePassword" value="Change your password"></p>
                </form>
                <c:if test="${user.role ne 'ADMIN'}">
                    <form method="POST" action="Controller?command=DeleteAccountConfirmation&userId=<c:out value="${user.userid}"/>">
                        <p><input type="submit" id="deleteAccount" value="Delete your account"></p>
                    </form>
                </c:if>

                <br>

                <p>Registered on: <fmt:formatDate pattern="dd/MM/yyyy, HH:mm:ss" value="${user.register}"/></p>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>