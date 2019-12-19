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
            <td><c:out value='${user.firstName}'/></td>
            <td><c:out value='${user.lastname}'/></td>
            <td><c:out value='${user.email}'/></td>
            <td>
            <form action="Controller" method="post" class="geenMargin">
                <input type="hidden" name="command" value="DeleteConfirmationUser">
                <input type="hidden" name="email" value="<c:out value='${user.email}'/>">
                <input type="hidden" name="firstName" value="<c:out value='${user.firstName}'/>">
                <input type="hidden" name="lastname" value="<c:out value='${user.lastname}'/>">
                <button type="submit">Delete Person</button>
            </form>
            </td>
        </tr>
        </c:forEach>
    </table>
</main>
<jsp:include page="components/sidebar.jsp">
    <jsp:param name="page" value="users"/>
</jsp:include>
</body>
</html>