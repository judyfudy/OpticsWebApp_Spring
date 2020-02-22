<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 26.01.2020
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Оптика</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="author" content="colorlib.com">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous">
    </script>

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous">
    </script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous">
    </script>

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500" rel="stylesheet"/>

    <link type="text/css" rel="stylesheet" href="<c:url value="../../resources/css/header.css"/>">
</head>
<body onload="startTime()">
<nav class="navbar navbar-expand-lg bg-dark navbar-dark" style="font-size: 15px">
    <a class="navbar-brand" href="<c:url value="/"/>" style="margin-bottom: 10px"><b>ОПТИКА</b></a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/workerList"><b>Про нас</b></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/services"><b>Послуги</b></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/products"><b>Товари</b></a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"><b>bubniyo@gmail.com</b></a>
            </li>
            <li class="nav-item" style="margin-left: 50px; margin-top: 8px">
                <a href="https://instagram.com/dan4oooos"><i class="fa fa-instagram"></i></a>
                <a href="https://www.facebook.com/bubnsy"><i class="fa fa-facebook"></i></a>
            </li>
            <li style="margin-left: 50px; margin-top: 8px">
                <p id="txt" style="color: white"></p>
            </li>
        </ul>
        <div class="navbar-nav ml-auto mb-auto">
            <c:if test="${empty sessionScope.user}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login"><b>Увійти</b></a>
                </li>
            </c:if>
            <c:if test="${empty sessionScope.user == false}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/cart"><b>Корзина</b></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/profile"><b>Профіль</b></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout"><b>Вийти</b></a>
                </li>
            </c:if>
        </div>
    </div>
</nav>
<jsp:include page="../components/footer.jsp"/>

<script type="text/javascript">
    function startTime() {
        var tm = new Date();
        var h = tm.getHours();
        var m = tm.getMinutes();
        var s = tm.getSeconds();
        m = checkTime(m);
        s = checkTime(s);
        document.getElementById('txt').innerHTML = h + ":" + m + ":" + s;
        t = setTimeout('startTime()', 500);
    }

    function checkTime(i) {
        if (i < 10) {
            i = "0" + i;
        }
        return i;
    }
</script>
</body>
</html>
