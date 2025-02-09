<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Users overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="scripts/app.js" defer></script>
</head>
<body>
<div id="main">
    <jsp:include page="header.jsp">
        <jsp:param name="page" value="Users overview"></jsp:param>
    </jsp:include>

        <c:if test="${not empty success}">
            <div id="alert-success">
                <ul>
                    <li><c:out value="${success}"/></li>
                </ul>
            </div>
        </c:if>

        <c:choose>
            <c:when test="${people.size() <= 0}">
                <p id="error">No users in the database.</p>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>User id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>E-mail</th>
                    </tr>
                    <c:forEach var="person" items="${people}">
                        <tr>
                            <td id="<c:out value="${person.userid}"/>"><c:out value="${person.userid}"/></td>
                            <td><c:out value="${person.firstName}"/></td>
                            <td><c:out value="${person.lastName}"/></td>
                            <td><c:out value="${person.email}"/></td>

                            <c:if test="${user.userid eq 'admin'}">
                                <td>
                                    <form method="POST" action="Controller?command=DeleteAccountConfirmation&userId=<c:out value="${person.userid}"/>">
                                        <input class="img" type="image" id="removeButton" src="images/delete-button.svg" alt="Delete user submit">
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    <caption>Users Overview</caption>
                </table>
            </c:otherwise>
        </c:choose>

        <c:if test="${empty user}">
            <form method="POST" action="Controller?command=Register">
                <p><input type="submit" id="register" value="Register new user"></p>
            </form>
        </c:if>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>