<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 30.01.2020
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Послуги</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="../../resources/css/services.css"/>">
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<h3 align="center" style="margin-top: 10px">Послуги</h3>
<div class="grid">
    <div class="container">
        <img src="<c:url value="../../resources/images/consulatation.jfif"/>" alt="Sample photo" style="width: 100%;">
        <div class="text-block">
            <h3>Консультація офтальмолога</h3>
        </div>
        <div class="overlay">
            <div class="text"><a href="/consultation">Детальніше</a></div>
        </div>
    </div>
    <div class="container">
        <img src="<c:url value="../../resources/images/girl_test.jfif"/>" alt="Sample photo" style="width: 100%;">
        <div class="text-block">
            <h3>Діагностика зору</h3>
        </div>
        <div class="overlay">
            <div class="text"><a href="/diagnostic">Детальніше</a></div>
        </div>
    </div>
    <div class="container">
        <img src="<c:url value="../../resources/images/glasses.jfif"/>" alt="Sample photo" style="width: 100%;">
        <div class="text-block">
            <h3>Виготовлення та ремонт окулярів</h3>
        </div>
        <div class="overlay">
            <div class="text"><a href="/repair">Детальніше</a></div>
        </div>
    </div>
</div>
</div>
</body>
</html>
