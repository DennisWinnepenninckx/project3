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
        <a href="Controller?command=Profile">
        <section class="account-banner">
            <img class="profile-pic" src="../static/imgs/profile.png" alt="profile_pic">
            <h3>${user.firstName} ${user.lastname}</h3>
        </section>
        </a>
    </c:if>
    <ul>
        <li class="link-nav">
            <a href="Controller?command=Index"><span class="material-icons">home</span><span>Home</span></a>
        </li>
        <li class="link-nav">
            <a href="Controller?command=Users"><span class="material-icons">supervisor_account</span><span>Users</span></a>
        </li>
        <li class="link-nav">
            <a href="Controller?command=ToCreateUser"><span class="material-icons">person_add</span><span>Create User</span></a>
        </li>
        <c:if test="${user==null}">
            <li class="link-nav">
                <a href="Controller?command=ToLogin"><span class="material-icons">exit_to_app</span><span>Login</span></a>
            </li>
        </c:if>
        <c:if test="${user!=null}">
            <li class="link-nav">
                <a href="Controller?command=Logout"><span class="material-icons">exit_to_app</span><span>Logout</span></a>
            </li>
        </c:if>
    </ul>
</nav>
<div id="nav-placeholder">
</div>
