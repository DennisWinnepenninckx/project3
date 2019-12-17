<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="components/header.jsp"/>
<body>
<jsp:include page="components/sidebar.jsp"></jsp:include>

<form novalidate="novalidate">
    <!-- novalidate in order to be able to run tests correctly -->
    <p><label for="firstName">First Name</label><input type="text" id="firstName" name="firstName" value=""
                                                       required value=""/></p>
    <p><label for="lastName">Last Name</label><input type="text" id="lastName" name="lastName" value=""
                                                     required/></p>
    <p><label for="email">Email</label><input type="email" id="email" name="email" value="" required/>
    </p>
    <p><input type="hidden" name="command" value="addUser"></p>
    <p><input type="submit" id="signUp" value="Add User"></p>
</form>
</body>
</html>