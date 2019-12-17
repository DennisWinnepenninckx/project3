<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="static/css/style.css" rel="stylesheet">
    <title>Stars</title>
</head>
<body>
<div id="container">
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
    <jsp:include page="sidebar.jsp"/>
</div>
</body>
</html>
