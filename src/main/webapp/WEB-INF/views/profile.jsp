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


<div class="card" id="profileCard">
    <img src="<c:url value="../../resources/images/sticker_1.jpg"/>" width="100%">
    <h1>${personInfo.firstName} ${personInfo.lastName}</h1>
    <p class="title">CEO & Founder, Example</p>
    <p>${personInfo.email}</p>
    <ul>
    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
    </ul>
</div>


</body>
</html>
