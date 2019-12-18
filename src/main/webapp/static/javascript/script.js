document.addEventListener("DOMContentLoaded", function (event) {
    // This function will get executed after the page is loaded and all scripts are loaded

    // Jquery can also be used
});

function getAllStars(id) {
    $.ajax({
        type: 'POST',
        data: {"op": "stars"},
        url: 'Controller?command=JsonController',
        success: function (result) {
            result = $.parseJSON(result);
            buildStars(result, id);
        }
    });
}

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

function searchStars(searchTerm, id) {
    $.ajax({
        type: 'POST',
        data: {"op": "searchStars", searchTerm: searchTerm},
        url: 'Controller?command=JsonController',
        success: function (result) {
            result = $.parseJSON(result);
            buildStars(result, id);
        }
    });
}

function buildStars(stars, id) {
    let parent = document.getElementById(id);
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
    let list = stars.map(star => {
        return buildStar(star);
    });
    for (let i = 0; i < list.length; i++) {
        parent.appendChild(list[i]);
    }
}

function buildStar(star) {
    let copy = document.getElementById("copy").cloneNode(true);
    copy.style.display = "block";
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