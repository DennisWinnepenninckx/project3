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

<section>
    <form action="Controller">
        <legend>
            Give someone a Star!
        </legend>
        <input type="hidden" name="command" value="GiveStar">
        <textarea name="description"></textarea>
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

    let input2 = document.querySelector(".names-input");
    let tagify2 = new Tagify(input2, {
        enforceWhitelist: true,
        whitelist: [<c:forEach items="${receivers}" var="receiver">
            <c:if test="${user.email != receiver.email}">
            "${receiver.email}",</c:if>
            </c:forEach>],
        maxTags: 1,
        autoComplete: true,
        transformTag: transformTag,
        dropdown: {
            enabled: 0,
            maxItems: 20,
        }
    });

    function transformTag( tagData ){
        tagData.style = "--tag-bg:" + "#3595f6";

        if( tagData.value.toLowerCase() == 'shit' )
            tagData.value = 's✲✲t'
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
</script>
