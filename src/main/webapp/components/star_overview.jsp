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
        <li>
            <div class="star-class">
                <div>
                    <img src="../static/imgs/star.png" alt="">
                    <span><c:out value="${star.receiverUser.firstName}"/> <c:out
                            value="${star.receiverUser.lastname}"/></span>
                </div>
                <div>
                <span class="sender">Sent by <c:out value="${star.senderUser.firstName}"/> <c:out
                        value="${star.senderUser.lastname}"/></span>
                    <p><c:out value="${star.description}"/></p>
                    <td>
                        <ul>
                            <c:forEach items="${star.tags}" var="tag">
                                <li><b>#</b><span class="tag-name"><c:out value="${tag}"/></span></li>
                            </c:forEach>
                        </ul>
                    </td>
                    </tr>
                </div>
            </div>
            <div class="comments">
                <c:forEach items="${star.comments}" var="comment">
                    <p>
                        <c:out value="${comment.user.firstName}"/> <c:out value="${comment.user.lastname}"/>
                    </p>
                    <p>
                        <c:out value="${comment.comment}"/>
                    </p>
                </c:forEach>
            </div>
        </li>
    </c:forEach>
</ul>
