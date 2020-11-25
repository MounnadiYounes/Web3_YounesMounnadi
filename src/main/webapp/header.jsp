<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <h1>Contact Tracing App</h1>
    <nav>
        <ul class="flex">
            <li class="drukletter notactive"><a href="Controller?command=Home">CTA</a></li>
            <li ${param.page eq 'Home'?'class="active"':'class="notactive"'}><a href="Controller?command=Home">Home</a></li>
            <li ${param.page eq 'Users overview'?'class="active"':'class="notactive"'}><a href="Controller?command=UsersOverview">Users</a></li>

                <c:if test="${not empty user}">
            <li ${param.page eq 'Contacts overview'?'class="active"':'class="notactive"'}><a href="Controller?command=ContactsOverview">Contacts</a></li>

                <c:choose>
                    <c:when test="${user.role eq 'ADMIN'}">
            <li ${param.page eq 'Admin search'?'class="active"':'class="notactive"'}><a href="Controller?command=AdminSearch">Admin search</a></li>
                    </c:when>
                <c:otherwise>
            <li ${param.page eq 'Register test result'?'class="active"':'class="notactive"'}><a href="Controller?command=RegisterTestResult">Register test result</a></li>
            <li ${param.page eq 'Search'?'class="active"':'class="notactive"'}><a href="Controller?command=TestResultsSearch">Search</a></li>
                </c:otherwise>
                </c:choose>

                <li ${param.page eq 'Dashboard'?'class="active"':'class="notactive"'}><a href="Controller?command=Dashboard">Dashboard</a></li>
            </c:if>
        </ul>
    </nav>
</header>
<h2>${param.page}</h2>