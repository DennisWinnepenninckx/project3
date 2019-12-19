<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="components/header.jsp"/>
<body>
<main>
    <form method="post" action="Controller?command=AddUser">
        <legend>
            Create a User!
        </legend>
        <c:if test="${useralreadyexists != null}">
            <div class="alert alert-danger">
                <p>${useralreadyexists}</p>
            </div>
        </c:if>
        <label for="firstName">First Name</label><input type="text" id="firstName" name="firstName" maxlength="20" value=""
                                                        required />
        <label for="lastName">Last Name</label><input type="text" id="lastName" maxlength="20" name="lastName" value=""
                                                      required/>
        <label for="email">Email</label><input type="email" id="email" name="email" maxlength="55" value="" required/>
        <p>
            <input class="checkbox" type="checkbox" name="superuser" value="superuser" id="superuser"> <label
                for="superuser">Superuser</label>
            <input class="checkbox" type="checkbox" name="admin" value="admin" id="admin"><label
                for="admin">Admin</label>
            <input class="checkbox" type="checkbox" name="manager" value="manager" id="manager"> <label
                for="manager">Manager</label>
        <button type="submit">Create User!</button>
    </form>
</main>
<jsp:include page="components/sidebar.jsp">
    <jsp:param name="page" value="createUser"/>
</jsp:include>
</body>
</html>