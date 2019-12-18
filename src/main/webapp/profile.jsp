<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 18/12/2019
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="components/header.jsp"/>
<body>
<main>
    <c:choose>
        <c:when test="${amountOfStars eq null}">
            <h2>Stars left this month: ∞ </h2>
        </c:when>
        <c:otherwise>
            <h2>Stars left this month: ${amountOfStars}</h2>
        </c:otherwise>
    </c:choose>
    <h2>Received Stars</h2>
<jsp:include page="components/received-stars.jsp"/>
    <h2>Given Stars</h2>
<jsp:include page="components/given-stars.jsp"/>
</main>

<jsp:include page="components/sidebar.jsp">
    <jsp:param name="page" value="profile"/>
</jsp:include>
</body>
</html>
