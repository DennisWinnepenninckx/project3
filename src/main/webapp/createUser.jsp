<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="components/header.jsp"/>
<body>
<main>
    <form method="post" action="Controller?command=AddUser">
        <p><label for="firstName">First Name</label><input type="text" id="firstName" name="firstName" value=""
                                                           required value=""/></p>
        <p><label for="lastName">Last Name</label><input type="text" id="lastName" name="lastName" value=""
                                                         required/></p>
        <p><label for="email">Email</label><input type="email" id="email" name="email" value="" required/>
        </p>
        <p>
            <input type="checkbox" name="superuser" value="superuser">superuser
            <input type="checkbox" name="admin" value="admin">admin
        </p>
        <select name="role" id="role">
            <option value="user">USER</option>
            <option value="superuser">SUPERUSER</option>
            <option value="admin">ADMIN</option>
        </select>
        <p><input type="submit" id="signUp" value="Add User"></p>
    </form>
</main>
<jsp:include page="components/sidebar.jsp">
    <jsp:param name="page" value="createUser"/>
</jsp:include>
</body>
</html>