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
<hr>
<div class="row" id="rowrow">
    <div class="column">
        <a href="/consultation">
            <img src="<c:url value="../../resources/images/consulatation_descr.jpg"/>" alt="Sample photo" width="100%">
        </a>
    </div>
    <div class="column">
        <a href="/diagnostic">
            <img src="<c:url value="../../resources/images/girl_test_descr.jpg"/>" alt="Sample photo" width="100%">
        </a>
    </div>
    <div class="column">
        <a href="/repair">
            <img src="<c:url value="../../resources/images/glasses_descr.jpg"/>" alt="Sample photo" width="100%">
        </a>
    </div>
</div>
</body>
</html>
