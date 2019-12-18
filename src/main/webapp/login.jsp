<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="components/header.jsp"/>
<body>
<main>

    <form id="login" novalidate action="Controller?command=Login" method="post">
        <legend>
            Login!
        </legend>

        <c:if test="${error!= null}">
        <div class="alert alert-danger">
            <p>${error}</p>
        </div>
        </c:if>

        <label for="email">email</label>
        <input type="email" id="email" name="email" value="<c:out value='${email}'/>" maxlength="55" required>
        <label for="password">password</label>
        <input type="password" id="password" name="password" required value="">
        <button type="submit">Login!</button>

    </form>
</main>
<jsp:include page="components/sidebar.jsp">
    <jsp:param name="page" value="login"/>
</jsp:include>
</body>
</html>
