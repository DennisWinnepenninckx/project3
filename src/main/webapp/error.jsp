<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="components/header.jsp"/>
<body>
<main role="main" class="container">
    <div class="container">
        <!-- Jumbotron -->
        <div class="jumbotron">
            <h1><i class="fa fa-frown-o red"></i> 404 Not Found</h1>
            <p class="lead">We couldn't find what you're looking for.</p>
            <p><a href="/" class="btn btn-default btn-lg"><span class="green">Take Me To The Homepage</span></a></p>
        </div>
    </div>
</main>
<jsp:include page="components/sidebar.jsp"/>
</body>
</html>
