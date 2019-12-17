<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <main>

        <form novalidate="novalidate" action="Servlet?command=Login" method="post">
            <!-- novalidate in order to be able to run tests correctly -->
            <p><label for="email">email</label><input type="hidden" id="email" name="email" value="${email}"
                                                         required></p>
            <p><label for="password">password</label><input type="password" id="password" name="password"
                                                            required value=""> </p>

            <p><input type="submit" id="signUp" value="Login"></p>

        </form>
    </main>
</div>
</body>
</html>
