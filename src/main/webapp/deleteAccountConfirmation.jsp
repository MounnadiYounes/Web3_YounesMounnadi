<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Change password</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="main">
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="Delete account"></jsp:param>
        </jsp:include>

        <div class="container">
            <p>Are you sure you want to change your password?</p>
            <br>
            <form method="POST" action="Controller?command=DeleteAccount">
                <p><input type="submit" id="no" value="No, take me to the homepage!"></p>
                <p><input type="submit" id="yes" name="yes" value="Yes, delete my account"></p>
            </form>
        </div>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>