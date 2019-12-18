<c:forEach items="${stars}" var="star">
    <li id="copy">
        <div class="star-class">
            <div>
                <img src="../static/imgs/profile.png">
                <span class="receiver"><c:out value="${star.receiverUser.firstName}"/> <c:out
                        value="${star.receiverUser.lastname}"/></span>
            </div>
            <div>
                <span class="sender">Sent by <c:out value="${star.senderUser.firstName}"/> <c:out
                        value="${star.senderUser.lastname}"/></span>
                <p class="description"><c:out value="${star.description}"/></p>
                <ul class="tag-list">
                    <c:forEach items="${star.tags}" var="tag">
                        <li><b>#</b><span class="tag-name"><c:out value="${tag}"/></span></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <form class="new-comment" method="post" action="Controller">
            <button type="submit" class="material-icons">add_circle</button>
            <input type="hidden" name="command" value="MakeComment">
            <input class="star-id" type="hidden" name="star" value="${star.id}">
            <input type="text" name="comment" placeholder="Comment on this star">
        </form>
        <ul class="comments content-list">
            <c:forEach items="${star.comments}" var="comment">
                <li class="comment">
                    <p>
                        <b class="comment-sender"><c:out value="${comment.user.firstName}"/> <c:out
                                value="${comment.user.lastname}"/></b>
                    </p>
                    <p class="comment-comment">
                        <c:out value="${comment.comment}"/>
                    </p>
                </li>
            </c:forEach>
        </ul>
    </li>
</c:forEach>