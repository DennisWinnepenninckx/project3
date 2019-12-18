<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 18/12/2019
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="content-list">
    <c:forEach items="${givenStars}" var="star">
        <li class="star-class">
            <img src="../static/imgs/star.png" alt="">
            <div>
                <table>
                    <tr>
                        <th>Sender</th>
                        <td>${star.sender}</td>
                    </tr>
                    <tr>
                        <th>Receiver</th>
                        <td>${star.receiver}</td>
                    </tr>
                </table>
                <p>${star.description}</p>
                <td>
                    <ul><c:forEach items="${star.tags}" var="tag">
                        <li>${tag}</li>
                    </c:forEach></ul>
                </td>
                </tr>
            </div>
        </li>
    </c:forEach>
</ul>
