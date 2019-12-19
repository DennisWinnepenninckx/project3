<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 18/12/2019
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="components/header.jsp"/>
<body>
<main>

    <form id="imageForm" action="Controller?command=Image" method="post" enctype="multipart/form-data">
        <label for="file">Image</label>
        <input type="file" name="file" id="file" accept="image/*" multiple>
        <button type="submit">upload</button>
    </form>

    <h2>Received Stars</h2>
    <jsp:include page="components/star_overview.jsp"/>
    <ul class="content-list" id="received">
    </ul>
    <h2>Given Stars</h2>
    <jsp:include page="components/star_overview.jsp"/>
    <ul class="content-list" id="sent">
    </ul>
</main>

<jsp:include page="components/sidebar.jsp">
    <jsp:param name="page" value="profile"/>
</jsp:include>
</body>

<script>
    let email = "${my_email}";
    getReceivedStars("received", email);
    getSenderStars("sent", email);
</script>
</html>
