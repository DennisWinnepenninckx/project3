<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<jsp:include page="components/header.jsp"/>
<body>
<main>
    <h1>User Overview</h1>
    <table>
        <tr>
            <th class="yeet">First Name</th>
            <th class="yeet">Last Name</th>
            <th class="yeet">E-mail</th>
        </tr>
        <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastname}</td>
            <td>${user.email}</td>
        </tr>
        </c:forEach>
    </table>
</main>
<jsp:include page="components/sidebar.jsp">
    <jsp:param name="page" value="users"/>
</jsp:include>
</body>
</html>