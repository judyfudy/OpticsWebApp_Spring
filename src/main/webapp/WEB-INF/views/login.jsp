<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 26.01.2020
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Увійти</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link href="<c:url value="../../resources/css/login.css"/>" rel="stylesheet" type="text/css">

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js">
    </script>
</head>

<body>
<form method="post" action="${pageContext.request.contextPath}/home" onsubmit="return validateCredentials()">
    <div class="container mt-3">
        <h1 class="title">Вхід</h1>
        <hr>
        <input type="text" placeholder="Ім'я користувача" name="username" id="username" required>
        <input type="password" placeholder="Пароль" name="password" id="password" required>
        <hr>
        <div class="signin">
            <button type="submit" class="registerbtn">Увійти</button>
            <p>
                Вперше на сайті ? <a href="/registration">Зареєструйтесь</a>.
            </p>
        </div>
    </div>
</form>
<script>
    function validateCredentials() {

        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;

        let success = false;

        $.ajax({
            type: "POST",
            async: false,
            url: "/login",
            data: {
                username: username,
                password: password
            }
        }).done(function (response) {
            console.log(response);
            success = true;
        }).fail(function (response) {
            success = false;

            if (response.status === 401) {
                alert("НЕВІРНИЙ ПАРОЛЬ");
            } else if (response.status === 403) {
                alert("КОРИСТУВАЧА З ТАКИМ НІКНЕЙМОМ НЕ ІСНУЄ. БУДЬ ЛАСКА, ЗАРЕЄСТРУЙТЕСЬ!")
            }
        });

        return success;
    }
</script>
</body>
</html>
