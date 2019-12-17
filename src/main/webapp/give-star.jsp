<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 17/12/2019
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<section>
    <form action="/Controller?command=GiveStar">
        <input name="description" type="text">
        <select name="receiver" id="">
            <c:forEach items="${persons}" var="person">
                <option value="${person.email}">${person.firstname} ${person.lastname}</option>
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
    </form>
</section>
