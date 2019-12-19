<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en" id="login-homepage">
<jsp:include page="components/header.jsp"/>
<body id="particles-js">
<main>

    <form class="login" novalidate action="Controller?command=Login" method="post">
        <legend  class="login">
            Login!
        </legend>

        <c:if test="${error!= null}">
        <div class="alert alert-danger">
            <p>${error}</p>
        </div>
        </c:if>
        <input type="email" id="email"  name="email" placeholder="email" value="<c:out value='${email}'/>" maxlength="55">
        <input type="password" id="password" placeholder="password" name="password" required value="">
        <button id="loginbutton" type="submit">Login</button>
    </form>
</main>
<jsp:include page="components/sidebar.jsp">
    <jsp:param name="page" value="login"/>
</jsp:include>
</body>
</html>
