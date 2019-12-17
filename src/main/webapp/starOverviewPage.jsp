<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <main>
        <c:choose>
            <c:when test="${starList==null or empty starList}">
                <p>No stars to show</p>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>E-mail</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>delete</th>
                        <th>login</th>
                        <th>role</th>
                    </tr>
                    <c:forEach var="star" items="${starList}">
                    <% System.out.println(request.getAttribute("personList").toString()); %>
                    <tr>
                        <td>"<c:out value="${star.description}"/>"
                        </td>
                        <td>"<c:out value="${bla.sender}"/>"
                        </td>
                        <td>"<c:out value="${bla.receiver}"/>"
                        </td>
                    <tr>
                        </c:forEach>
                </table>

            </c:otherwise>
        </c:choose>
    </main>
</div>
</body>
</html>