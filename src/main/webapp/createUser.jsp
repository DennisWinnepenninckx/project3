<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Header -->
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="/static/css/style.css" rel="stylesheet">
    <title>Hello world!</title>
</head>
<body>

<!-- Navigation -->
<jsp:include page="sidebar.jsp"></jsp:include>

<!-- Page Content -->



</body>

<form novalidate="novalidate">
    <!-- novalidate in order to be able to run tests correctly -->
    <p><label for="firstName">First Name</label><input type="text" id="firstName" name="firstName" value=""
        required value=""/> </p>
    <p><label for="lastName">Last Name</label><input type="text" id="lastName" name="lastName" value=""
        required/> </p>
    <p><label for="email">Email</label><input type="email" id="email" name="email" value="" required/>
    </p>
    <p><input type="hidden" name="command" value="addUser"></p>
    <p><input type="submit" id="signUp" value="Add User"></p>

</form>


<!-- Footer -->
<!-- Optional JavaScript -->
<!-- jQuery first, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>