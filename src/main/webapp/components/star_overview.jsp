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
<ul class="content-list">
    <c:forEach items="${stars}" var="star">
        <li class="star-class">
            <div>
                <img src="../static/imgs/star.png" alt="">
                <span>${star.receiverUser.firstName} ${star.receiverUser.lastname}</span>
            </div>
            <div>
                <span class="sender">Sent by ${star.senderUser.firstName} ${star.senderUser.lastname}</span>
                <p>${star.date}</p>
                <p>${star.description}</p>
                <td>
                    <ul><c:forEach items="${star.tags}" var="tag">
                        <li><b>#</b><span class="tag-name">${tag}</span></li>
                    </c:forEach></ul>
                </td>
                </tr>
            </div>
        </li>
    </c:forEach>
</ul>
