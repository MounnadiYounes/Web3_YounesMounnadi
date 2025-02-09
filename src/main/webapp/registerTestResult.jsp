<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Register test result</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="scripts/app.js" defer></script>
    <script src="scripts/formValidation.js" defer></script>
</head>
<body>
<div id="main">
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="Register test result"/>
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

            <c:if test="${not empty testResult}">
                <p>Your last positive Covid-19 test has been registered on: <fmt:formatDate pattern="dd/MM/yyyy" value="${testResult.date}"/></p>
                <br>
            </c:if>

            <div class="container">
                <form method="POST" action="Controller?command=AddTestResult">
                    <div><p><label for="date">Date</label><input type="date" id="date" name="date" value="<c:out value="${currentDate}"/>" required></p></div>
                    <p><input type="submit" id="registerTestResult" value="Register new positive test result"></p>
                </form>
            </div>

    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>