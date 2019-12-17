<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 17/12/2019
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section>
    <c:forEach items="${stars}" var="star">
        <table>
            <tr>
                <th>Sender</th>
                <th>Receiver</th>
                <th>Description</th>
                <th>Tags</th>
            </tr>
            <tr>
                <td>${star.sender}</td>
                <td>${star.receiver}</td>
                <td>${star.description}</td>

                <td>
                    <ul><c:forEach items="${star.tags}" var="tag">
                        <li>${tag}</li>
                    </c:forEach></ul>
                </td>
            </tr>
        </table>
    </c:forEach>
</section>
