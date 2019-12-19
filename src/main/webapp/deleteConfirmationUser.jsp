<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="components/header.jsp"/>
<body class="noflex">
<main>
<p>Bent u zeker dat u <c:out value='${param.firstName}'/> <c:out value='${param.lastname}'/> wilt verwijderen?</p>
<form method="post" action="Controller?command=DeleteUser">
    <input type="hidden" id="email" name="email" value="${param.email}">
    <button type="submit">Verwijder User</button>
</form>
<form method="post" action="Controller?command=Users">
    <button type="submit">Annuleren</button>
</form>
</main>
<jsp:include page="components/sidebar.jsp">
    <jsp:param name="page" value="Delete User"/>
</jsp:include>
</body>
</html>
