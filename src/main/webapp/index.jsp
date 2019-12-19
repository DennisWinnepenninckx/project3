<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="components/header.jsp"/>
<body>
<main role="main" class="container">
    <c:if test="${user!=null}">
        <c:if test="${errors!= null}">
            <div class="alert alert-danger">
                <p>${errors}</p>
            </div>
        </c:if>
        <jsp:include page="components/star_overview.jsp"/>
        <form id="searchBar" action="#" style="display: flex" onsubmit="return false;">
            <span class="material-icons">search</span>
            <input type="text" style=" border-radius: 5px" width="50%" id="starSearch">
        </form>
        <ul class="content-list" id="all">
        </ul>
        <div id="spinner" style="display: none" class="loader"></div>

    </c:if>
</main>
<jsp:include page="components/sidebar.jsp">
    <jsp:param name="page" value="home"/>
</jsp:include>
</body>
</html>

<script>
    let searchBar = document.getElementById("searchBar");
    searchBar.addEventListener("submit", searchSomething, false);

    document.getElementById("spinner").style.display = "block";
    searchStars("all");

    function searchSomething() {
        document.getElementById("spinner").style.display = "block";
        let searchWord = document.getElementById("starSearch");
        searchTerm = searchWord.value;
        searchStars("all");
    }

    window.onscroll = function() {
        let d = document.documentElement;
        let offset = d.scrollTop + window.innerHeight;
        let height = d.offsetHeight;

        if (offset === height) {
            addToListSearch("all")
            document.getElementById("spinner").style.display = "block";
        }
    };

</script>