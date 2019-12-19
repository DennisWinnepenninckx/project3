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
    <c:forEach items="${receivedStars}" var="star">
        <li class="star-class">
            <div>
                <img src="../static/imgs/star.png" alt="">
                <span><c:out value="${star.receiverUser.firstName}"/> <c:out value="${star.receiverUser.lastname}"/></span>
            </div>
            <div style="word-wrap: break-word;">
                <span class="sender">Sent by <c:out value="${star.senderUser.firstName}"/> <c:out value="${star.senderUser.lastname}"/></span>
                <p><c:out value="${star.description}"/></p>
                <td>
                    <ul><c:forEach items="${star.tags}" var="tag">
                        <li><b>#</b><span class="tag-name"><c:out value="${tag}"/></span></li>
                    </c:forEach></ul>
                </td>
                </tr>
            </div>
        </li>
    </c:forEach>
</ul>

