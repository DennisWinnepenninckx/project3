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
            <section  ${param.page eq "profile" ? "id=current":""} class="account-banner">
                <img class="profile-pic" src="../static/imgs/profile.png" alt="profile_pic">
                <h3>${user.firstName} ${user.lastname}</h3>
            </section>
        </a>
    </c:if>
    <ul>
        <c:if test="${user!=null}">
            <li class="link-nav" id="give-star-button">
                <a href="#"><span class="material-icons">star</span><span>Give Star</span></a>
            </li>
            <li ${param.page eq "home" ? "id=current":""} class="link-nav">
                <a href="Controller?command=Index"><span class="material-icons">home</span><span>Home</span></a>
            </li>
            <c:if test="${user.admin}">
                <li ${param.page eq "users" ? "id=current":""} class="link-nav">
                    <a href="Controller?command=Users"><span
                            class="material-icons">supervisor_account</span><span>Users</span></a>
                </li>
                <li ${param.page eq "createUser" ? "id=current":""} class="link-nav">
                    <a href="Controller?command=ToCreateUser"><span class="material-icons">person_add</span><span>Create User</span></a>
                </li>
            </c:if>
        </c:if>
        <c:choose>
            <c:when test="${user==null}">
                <li ${param.page eq "login" ? "id=current":""} class="link-nav">
                    <a href="Controller?command=ToLogin"><span
                            class="material-icons">exit_to_app</span><span>Login</span></a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="link-nav">
                    <a href="Controller?command=Logout"><span
                            class="material-icons">exit_to_app</span><span>Logout</span></a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>
<div id="nav-placeholder">
</div>
<jsp:include page="give-star.jsp"/>

<script>
    window.addEventListener("load", initPage, false);

    function initPage() {
        let button = document.getElementById("give-star-button");
        button.addEventListener("click", onGiveStar, false);
    }

    function onGiveStar() {
        let form = document.getElementById("give-star");
        form.classList.add("appear");
    }
</script>
