<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="components/header.jsp"/>
<body>
<main>
    <c:if test="${not empty errors}">
        <div class="alert alert-danger">
            <ul>
                <c:forEach var="error" items="${errors}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <form id="login" novalidate="novalidate" action="Controller?command=Login" method="post">
        <p>
            <label for="email">email</label>
            <input type="email" id="email" name="email" value="<c:out value='${email}'/>" required>
        </p>
        <p><label for="password">password</label>
            <input type="password" id="password" name="password" required value="">
        </p>
        <p><input type="submit" id="signUp" value="Login"></p>
    </form>
</main>
<jsp:include page="components/sidebar.jsp"/>
</body>
</html>
