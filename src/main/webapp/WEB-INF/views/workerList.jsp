<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 26.01.2020
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Про нас</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="../../resources/css/workerList.css"/>">
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<div class="container" style="margin-top: 10px">
    <div class="content">
        <h1 style="font-family: 'Times New Roman',serif" align="center">Про нас</h1>
        <hr><p style="text-align: center; font-family: 'Times New Roman',serif ">Ми найбільша українська мережа оптик, де ви можете отримати професійну консультацію лікаря-офтальмолога,
            допомогу в підборі і придбанні сучасних і зручних оптичних оправ,
            виготовлення і ремонт окулярів, гарантійне і післягарантійне обслуговування.</p><hr>
    </div>
    <img src="<c:url value="../../resources/images/glass_on_yellow.jfif"/>" alt="Notebook" style="width:50%; margin-left: 300px">
</div>

<hr><h3 style="text-align: center; font-family: 'Times New Roman',serif">Наші Лікарі</h3><hr>
<c:forEach items="${workers}" var="worker">
    <div class="card mt-5 mb-5" style="display: inline-block; margin-left: 300px">
        <img src="data:image/jpg;base64,${worker.photo}" alt="" style="width:100%">
        <h3>${worker.firstName} ${worker.middleName}</h3>
        <p class="title">Лікар-офтальмолог</p>
        <p>${worker.email}, вік: ${worker.age}</p>
        <p>Опис: ${worker.description}</p>
    </div>
</c:forEach>

</body>
</html>
