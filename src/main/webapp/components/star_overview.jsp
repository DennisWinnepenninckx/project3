<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 17/12/2019
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<form action="#">
    <input type="text" style=" border-radius: 5px" width="50%" id="starSearch" placeholder="search">
</form>

<li style="display: none" id="copy">
    <div class="star-class">
        <div>
            <img src="../static/imgs/profile.png">
            <span class="receiver"></span>
        </div>
        <div>
            <span class="sender">Sent by </span>
            <p class="description"></p>
            <ul class="tag-list">
            </ul>
        </div>
    </div>
    <form class="new-comment" method="post" action="Controller">
        <button type="submit" class="material-icons">add_circle</button>
        <input type="hidden" name="command" value="MakeComment">
        <input class="star-id" type="hidden" name="star" value="">
        <input type="text" name="comment" placeholder="Comment on this star">
    </form>
    <ul style="display: none" class="comments content-list">
    </ul>
</li>

<li id="comment" class="comment">
    <p>
        <b class="comment-sender"></b>
    </p>
    <p class="comment-comment">

    </p>
</li>
<div class="star-class" id="sorry" style="display: none;">
    no matches found, be the first!
</div>
<script>
    let inputStarSearch = document.getElementById("starSearch");

    inputStarSearch.addEventListener('input', function () {
        let searchQuery = inputStarSearch.value.toLowerCase();
        let classes = document.getElementsByClassName("Star");

        if (searchQuery.toLowerCase().includes("receiver:")) {
            searchQuery = searchQuery.replace("receiver:", "").trim();
            if (!searchQuery || /^\s*$/.test(searchQuery)) {
                for (let index = 0; index < classes.length; index++) {
                    classes[index].style.display = "block";
                }
            }
            for (let index = 0; index < classes.length; index++) {
                let txt = classes[index].children[0].children[0].children[1].innerHTML;
                if (txt.toLowerCase().includes(searchQuery)) {
                    classes[index].style.display = "block";
                } else {
                    classes[index].style.display = "none";
                }
            }
        } else if (searchQuery.toLowerCase().includes("sender:")) {
            searchQuery = searchQuery.replace("sender:", "").trim();
            if (!searchQuery || /^\s*$/.test(searchQuery)) {
                for (let index = 0; index < classes.length; index++) {
                    classes[index].style.display = "block";
                }
            }
            for (let index = 0; index < classes.length; index++) {
                let txt = classes[index].children[0].children[1].children[0].innerHTML;
                if (txt.toLowerCase().includes(searchQuery)) {
                    classes[index].style.display = "block";
                } else {
                    classes[index].style.display = "none";
                }
            }
        } else if (searchQuery.toLowerCase().includes("tag:")) {
            searchQuery = searchQuery.replace("tag:", "").trim();
            if (!searchQuery || /^\s*$/.test(searchQuery)) {
                for (let index = 0; index < classes.length; index++) {
                    classes[index].style.display = "block";
                }
            }
            for (let index = 0; index < classes.length; index++) {
                let txt = classes[index].children[0].children[1].children[2].innerHTML;
                if (txt.toLowerCase().includes(searchQuery)) {
                    classes[index].style.display = "block";
                } else {
                    classes[index].style.display = "none";
                }
            }
        }else{
            for (let index = 0; index < classes.length; index++) {
                let txt = classes[index].children[0].innerHTML;
                if (txt.toLowerCase().includes(searchQuery)) {
                    classes[index].style.display = "block";
                } else {
                    classes[index].style.display = "none";
                }
            }
        }
        if (!searchQuery || /^\s*$/.test(searchQuery)) {
            for (let index = 0; index < classes.length; index++) {
                classes[index].style.display = "block";
            }
        }
        let counter = 0;
        for (let index = 0; index < classes.length; index++) {
            if (classes[index].style.display == "none") {
                counter++;
            }
            if (counter == classes.length) {
                document.getElementById("sorry").style.display = "block";
            } else {
                document.getElementById("sorry").style.display = "none";
            }
        }
    });

</script>

