<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 17/12/2019
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>

<li style="display: none" id="copy" class="this-is-a-star">
    <div class="star-class">
        <div>
            <img class="ppicture" src="">
            <span class="receiver"></span>
        </div>
        <div style="word-wrap: break-word;">
            <span class="sender">Sent by </span>
            <p class="description"></p>
            <p class="datetime">
            </p>
            <ul class="tag-list">
            </ul>
        </div>
    </div>
    <form class="new-comment" method="post" action="Controller">
        <input type="hidden" name="command" value="MakeComment">
        <input class="star-id" type="hidden" name="star" value="">
        <input type="text" name="comment" placeholder="Comment on this star">
        <button type="submit" class="material-icons">add_circle</button>
    </form>
    <ul style="display: none" class="comments content-list">
    </ul>
</li>

<li id="comment" class="comment" style="display: none">
    <p>
        <b class="comment-sender"></b><span class="comment-comment"></span>
    </p>
</li>

<li id="tag-el" style="display: none" class="tag-el"><b>#</b><span class="tag-name"></span></li>
<div class="star-class" id="sorry" style="display: none;">
    no matches found, be the first!
</div>
<script>

</script>

