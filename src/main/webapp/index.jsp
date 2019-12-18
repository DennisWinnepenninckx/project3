<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="components/header.jsp"/>
<body>
<main role="main" class="container">
    <c:if test="${user!=null}">
        <jsp:include page="components/give-star.jsp"/>
        <jsp:include page="components/star_overview.jsp">
            <jsp:param name="stars" value="${stars}"/>
        </jsp:include>
    </c:if>
</main>
<jsp:include page="components/sidebar.jsp">
    <jsp:param name="page" value="home"/>
</jsp:include>
</body>
</html>
