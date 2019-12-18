<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 17/12/2019
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="static/dist/tagify.js"></script>
<script src="static/javascript/tagify.min.js"></script>
<link href="static/css/tagify.css" rel="stylesheet">

<section id="give-star">
    <span class="material-icons close" id="close">close</span>
    <form action="Controller">
        <legend>
            Give someone a Star!
        </legend>
        <input type="hidden" name="command" value="GiveStar">
        <textarea name="description" placeholder="Why do I deserve a star?" maxlength="128"></textarea>
        <input class="names-input" name="receiver" placeholder="Send star to">
        <input class="tags-input" name='tags' placeholder='Tags'>
        <button type="submit">Give Star!</button>
    </form>
</section>
<script>
    let input = document.querySelector("input[name=tags]");
    let tagify = new Tagify(input, {
        enforceWhitelist: true,
        whitelist: ["Integrity", "Curiosity", "Collaboration", "Client first", "Entrepreneurship", "Move faster", "Act smarter", "Go further", "Be sure", "Team spirit", "Office spirit"],
        maxTags: 4,
        autoComplete: true,
        transformTag: transformTag,
        dropdown: {
            enabled: 0,
            maxItems: 20,
        }
    });

    window.addEventListener("load", bla, false);

    function bla() {
        let close = document.getElementById("close");
        close.addEventListener("click", onClose, false);
    }

    function onClose() {
        let form = document.getElementById("give-star");
        form.classList.remove("appear");
    }

    $.ajax({
        type: 'POST',
        data: {"op":"emails"},
        url: 'Controller?command=JsonController',
        success: function (result) {
            result = JSON.parse(result);
            let input2 = document.querySelector(".names-input");
            let tagify2 = new Tagify(input2, {
                enforceWhitelist: true,
                whitelist: result,
                maxTags: 1,
                autoComplete: true,
                transformTag: transformTag,
                dropdown: {
                    enabled: 0,
                    maxItems: 20,
                }
            });

            tagify2.on('add', onAddTag)
                .on('remove', onRemoveTag)
                .on('input', onInput)
                .on('edit', onTagEdit)
                .on('invalid', onInvalidTag)
                .on('click', onTagClick)
                .on('focus', onTagifyFocusBlur)
                .on('blur', onTagifyFocusBlur)
                .on('dropdown:show', onDropdownShow)
                .on('dropdown:hide', onDropdownHide)
                .on('dropdown:select', onDropdownSelect)
        }
    });

    function transformTag( tagData ){
        tagData.style = "--tag-bg:" + "#3595f6";
    }

    tagify.on('add', onAddTag)
        .on('remove', onRemoveTag)
        .on('input', onInput)
        .on('edit', onTagEdit)
        .on('invalid', onInvalidTag)
        .on('click', onTagClick)
        .on('focus', onTagifyFocusBlur)
        .on('blur', onTagifyFocusBlur)
        .on('dropdown:show', onDropdownShow)
        .on('dropdown:hide', onDropdownHide)
        .on('dropdown:select', onDropdownSelect)

</script>
