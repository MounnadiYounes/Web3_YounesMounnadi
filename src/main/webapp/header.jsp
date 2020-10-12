<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <h1>Contact Tracing App</h1>
    <nav>
        <ul class="flex">
                <li class="drukletter notactive"><a href="Controller?command=Home">CTA</a></li>
            <li ${param.page eq 'Home'?'class="active"':'class="notactive"'}><a href="Controller?command=Home">Home</a></li>
            <li ${param.page eq 'People overview'?'class="active"':'class="notactive"'}><a href="Controller?command=Overview">Overview</a></li>
            <li ${param.page eq 'Register'?'class="active"':'class="notactive"'}><a href="Controller?command=Register">Register</a></li>

            <c:if test="${not empty user}">
                <li ${param.page eq 'Dashboard'?'class="active"':'class="notactive"'}><a href="Controller?command=Dashboard">Dashboard</a></li>
            </c:if>
        </ul>
    </nav>
</header>
<h2>${param.page}</h2>