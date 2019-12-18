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
<form action="#">
    <input type="text" style=" border-radius: 5px" ; width="50%" id="starSearch" placeholder="search">
</form>
<script>
    let inputStarSearch = document.getElementById("starSearch");

    inputStarSearch.addEventListener('input', function () {
        let searchQuery = inputStarSearch.value.toLowerCase();
        let classes = document.getElementsByClassName("Star");

        if (searchQuery.toLowerCase().includes("receiver:")) {
            searchQuery= searchQuery.replace("receiver:","").trim();
            for (let index = 0; index < classes.length; index++) {
                let txt = classes[index].children[0].children[0].children[1].innerHTML;
                if (txt.toLowerCase().includes(searchQuery)) {
                    classes[index].style.display = "block";
                } else {
                    classes[index].style.display = "none";
                }
            }
        } else if (searchQuery.toLowerCase().includes("sender:")) {
            searchQuery= searchQuery.replace("sender:","").trim();
            for (let index = 0; index < classes.length; index++) {
                let txt = classes[index].children[0].children[1].children[0].innerHTML;
                if (txt.toLowerCase().includes(searchQuery)) {
                    classes[index].style.display = "block";
                } else {
                    classes[index].style.display = "none";
                }
            }
        } else if(searchQuery.toLowerCase().includes("tag:")){
            searchQuery= searchQuery.replace("tag:","").trim();
            for (let index = 0; index < classes.length; index++) {
                let txt = classes[index].children[0].children[1].children[2].innerHTML;
                if (txt.toLowerCase().includes(searchQuery)) {
                    classes[index].style.display = "block";
                } else {
                    classes[index].style.display = "none";
                }
            }
        }
        if (searchQuery == ""){
            for (let index = 0; index < classes.length; index++) {
                classes[index].style.display = "block";
            }
        }

    });


</script>
<ul class="content-list">
    <c:forEach items="${stars}" var="star">
        <li class="Star">
            <div class="star-class">
                <div>
                    <img src="../static/imgs/star.png" alt="">
                    <span class="receiver"><c:out value="${star.receiverUser.firstName}"/> <c:out
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
