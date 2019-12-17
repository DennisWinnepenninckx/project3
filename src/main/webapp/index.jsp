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
        <jsp:include page="components/star_overview.jsp"/>
    </c:if>
</main>
<jsp:include page="components/sidebar.jsp"/>
</body>
</html>
