<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 17/12/2019
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <c:if test="${user!=null}">
        <section class="profile">
            <img class="profile-pic" src="../static/imgs/profile.png" alt="profile_pic">
            <div>
                <ul>
                    <li>${user.firstName} ${user.lastname}</li>
                    <li>${user.email}</li>
                </ul>
            </div>
        </section>
    </c:if>
    <ul>
        <li>
            <a class="nav-link" href="Controller?command=Index">Home <span
                    class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Controller?command=Users">Users</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Controller?command=ToCreateUser">Create user</a>
        </li>
        <c:if test="${user==null}">
            <li class="nav-item">
                <a class="nav-link" href="Controller?command=ToLogin">Login</a>
            </li>
        </c:if>
        <c:if test="${user!=null}">
            <li class="nav-item">
                <a class="nav-link" href="Controller?command=Logout">Log out</a>
            </li>
        </c:if>
    </ul>
</nav>
