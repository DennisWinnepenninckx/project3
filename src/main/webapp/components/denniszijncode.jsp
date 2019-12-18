
/*
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

*/