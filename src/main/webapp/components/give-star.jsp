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
<section>
    <form action="Controller">
        <input type="hidden" name="command" value="GiveStar">
        <input name="description" type="text">
        <select name="receiver">
            <c:forEach items="${receivers}" var="receiver">
                <option value="${receiver.email}">${receiver.firstName} ${receiver.lastname}</option>
            </c:forEach>
        </select>
        <select name="tag1">
            <c:forEach items="${tags}" var="tag">
                <option value="${tag}">${tag}</option>
            </c:forEach>
        </select>
        <select name="tag2">
            <c:forEach items="${tags}" var="tag">
                <option value="${tag}">${tag}</option>
            </c:forEach>
        </select>
        <select name="tag3">
            <c:forEach items="${tags}" var="tag">
                <option value="${tag}">${tag}</option>
            </c:forEach>
        </select>
        <select name="tag4">
            <c:forEach items="${tags}" var="tag">
                <option value="${tag}">${tag}</option>
            </c:forEach>
        </select>
        <button type="submit">Give Star!</button>
    </form>
</section>
