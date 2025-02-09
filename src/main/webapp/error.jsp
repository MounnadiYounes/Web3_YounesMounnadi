<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="scripts/app.js" defer></script>
</head>
<body>
    <div id="main">
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="Error"/>
        </jsp:include>

        <main>
            <c:if test="${not empty error}">
                <p id="alert-danger"><c:out value="${error}"/></p>
            </c:if>

            <c:if test="${not empty pageContext.exception}">
                <p id="alert-danger">You caused a <c:out value="${pageContext.exception}"/> on the server!</p>
            </c:if>
        </main>

        <footer>&copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
    </div>
</body>
</html>