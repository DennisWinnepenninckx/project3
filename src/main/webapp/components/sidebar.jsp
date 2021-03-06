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
                <img class="profile-pic" src="Controller?command=GetImage&fileName=${user.profilepic}" alt="profile_pic">
                <div id="change-pic" class="material-icons">camera_alt</div>
                <h3>${user.firstName} ${user.lastname}</h3>
            </section>
        </a>
        <div id="starsGaveAway" ${user.superUser ? 'class="superuserstars"':''}>
            <c:choose>
                <c:when test="${starsGave >= 3}">
                    <span class="material-icons">star_border</span>
                </c:when>
                <c:otherwise>
                    <span class="material-icons">star</span>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${starsGave >= 2}">
                    <span class="material-icons">star_border</span>
                </c:when>
                <c:otherwise>
                    <span class="material-icons">star</span>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${starsGave >= 1}">
                    <span class="material-icons">star_border</span>
                </c:when>
                <c:otherwise>
                    <span class="material-icons">star</span>
                </c:otherwise>
            </c:choose>
        </div>
    </c:if>
    <ul>
        <c:if test="${user!=null}">
            <li class="link-nav" id="give-star-button">
                <a href="#" onclick="return false;"><span class="material-icons">star</span><span>Give Star</span></a>
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

<form id="imageForm" action="Controller?command=Image" method="post" enctype="multipart/form-data">
    <span class="material-icons close" id="close2">close</span>
    <label for="file">Image</label>
    <input type="file" name="file" id="file" accept="image/*" multiple>
    <button type="submit">upload</button>
</form>

<script>
    window.addEventListener("load", initPage, false);

    function initPage() {
        let button = document.getElementById("give-star-button");
        button.addEventListener("click", onGiveStar, false);
        let b2 = document.getElementById("change-pic");
        b2.addEventListener("click", onChangePic, false);

        $('#change-pic').click(function(e) {
            e.stopPropagation();
            e.preventDefault();
        });
    }

    function onChangePic() {
        let form = document.getElementById("imageForm");
        form.classList.add("appear");
    }

    function onGiveStar() {
        let form = document.getElementById("give-star");
        form.classList.add("appear");
    }

    window.addEventListener("load", bla2, false);

    function bla2() {
        let close = document.getElementById("close2");
        close.addEventListener("click", onClose2, false);
    }

    function onClose2() {
        let form = document.getElementById("imageForm");
        form.classList.remove("appear");
    }
</script>
