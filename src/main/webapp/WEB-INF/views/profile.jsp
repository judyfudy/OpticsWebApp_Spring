<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 05.02.2020
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Профіль</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="../../resources/css/profile.css"/>">
</head>
<body>
<jsp:include page="../components/header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-6 img">
            <img src="<c:url value="../../resources/images/sticker_1.jpg"/>" width="50%" height="100%" class="img-rounded">
        </div>
        <div class="col-md-6 details">
            <blockquote>
                <h5>${personInfo.firstName} ${personInfo.lastName}</h5>
                <small><cite title="Source Title">Lviv, Ukraine  <i class="icon-map-marker"></i></cite></small>
            </blockquote>
            <p>
                ${personInfo.email} <br>
                April 22, 2001
            </p>
        </div>
    </div>
</div>
</body>
</html>
