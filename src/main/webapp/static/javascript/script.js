document.addEventListener("DOMContentLoaded", function (event) {
    // This function will get executed after the page is loaded and all scripts are loaded

    // Jquery can also be used
});

function getReceivedStars(id, receiver) {
    $.ajax({
        type: 'POST',
        data: {"op": "stars", receiver: receiver},
        url: 'Controller?command=JsonController',
        success: function (result) {
            result = $.parseJSON(result);
            buildStars(result, id);
        }
    });
}

function getSenderStars(id, sender) {
    $.ajax({
        type: 'POST',
        data: {"op": "stars", sender: sender},
        url: 'Controller?command=JsonController',
        success: function (result) {
            result = $.parseJSON(result);
            buildStars(result, id);
        }
    });
}

let stars = [];
let starSet = new Set();
let searchTerm = "";

function searchStars(id) {
    $.ajax({
        type: 'POST',
        data: {"op": "stars", searchTerm: searchTerm, start: 0, stop: 10},
        url: 'Controller?command=JsonController',
        success: function (result) {
            result = $.parseJSON(result);
            clearStarsArray(result);
            buildStars(result, id);
            document.getElementById("spinner").style.display = "none";
        }
    });
}


function addToListSearch(id) {
    $.ajax({
        type: 'POST',
        data: {"op": "stars", searchTerm: searchTerm, start: stars.length, stop: stars.length + 10},
        url: 'Controller?command=JsonController',
        success: function (result) {
            result = $.parseJSON(result);
            addToStars(changeStarsArray(result), id);
            document.getElementById("spinner").style.display = "none";
        }
    });
}
function clearStarsArray(sterretjes) {
    stars = sterretjes;
    starSet = new Set();
    for (let i = 0; i < stars.length; i++) {
        starSet.add(stars[i].id);
    }
}


function changeStarsArray(result) {
    let st = [];
    for (let i = 0; i < result.length; i++) {
        if (!starSet.has(result[i].id)) {
            starSet.add(result[i].id);
            st.push(result[i]);
            stars.push(result[i]);
        }
    }
    return st;
}

function addToStars(stars, id) {
    let parent = document.getElementById(id);
    let list = stars.map(star => {
        return buildStar(star);
    });
    for (let i = 0; i < list.length; i++) {
        parent.appendChild(list[i]);
    }
}

function buildStars(stars, id) {
    let parent = document.getElementById(id);
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
    addToStars(stars, id);
}

function buildStar(star) {
    let copy = document.getElementById("copy").cloneNode(true);
    copy.style.display = "block";
    let ppic = copy.getElementsByClassName("ppicture")[0];
    ppic.src = "Controller?command=GetImage&fileName=" + star.receiverPic;
    let datetime = copy.getElementsByClassName("datetime")[0];
    datetime.innerText = star.date;
    let receiver = copy.getElementsByClassName("receiver")[0];
    receiver.innerText = star.receiverUserFirstname + " " + star.receiverUserLastname;
    let sender = copy.getElementsByClassName("sender")[0];
    sender.innerText = "Sent by " + star.senderUserFirstname + " " + star.senderUserLastname;
    let description = copy.getElementsByClassName("description")[0];
    description.innerText = star.description;
    let taglist = copy.getElementsByClassName("tag-list")[0];
    for (let i = 0; i < star.tags.length; i++) {
        taglist.appendChild(buildTag(star.tags[i]));
    }
    let starid = copy.getElementsByClassName("star-id")[0];
    starid.value = star.id;
    let comments = copy.getElementsByClassName("comments")[0];
    comments.style.display = "block";
    for (let i = 0; i < star.comments.length; i++) {
        comments.appendChild(buildComment(star.comments[i]));
    }
    return copy;
}

function buildComment(comment) {
    let commentEl = document.getElementById("comment").cloneNode(true);
    let sender = commentEl.getElementsByClassName("comment-sender")[0];
    sender.innerText = comment.user_firstname + " " + comment.user_lastname;
    let content = commentEl.getElementsByClassName("comment-comment")[0];
    content.innerText = comment.comment;
    return commentEl;
}

function buildTag(tag) {
    let tagEl = document.getElementById("tag-el").cloneNode(true);
    tagEl.style.display = "block";
    let tagVal = tagEl.getElementsByClassName("tag-name")[0];
    tagVal.innerText = tag;
    return tagEl;
}