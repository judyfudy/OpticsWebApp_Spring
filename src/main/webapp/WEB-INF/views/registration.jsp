<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 26.01.2020
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Реєстрація</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link href="<c:url value="../../resources/css/registration.css"/>" rel="stylesheet" type="text/css">

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js">
    </script>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/login" onsubmit="return validateCredentials()">
    <div class="container mt-3">
        <h1 class="title">Реєстрація</h1>
        <hr>
        <input type="text" placeholder="Ім'я" name="firstName" id="firstName" required>
        <input type="text" placeholder="Прізвище" name="lastName" id="lastName" required>
        <input type="text" placeholder="Ім'я користувача" name="username" id="username" required>
        <input type="text" placeholder="Почта" name="email" id="email" required>
        <input type="password" placeholder="Пароль" name="password" id="password" required>
        <input type="password" placeholder="Введіть пароль ще раз" name="passwordConfirm" id="passwordConfirm" required>
        <hr>
        <div class="signin">
            <button type="submit" class="registerbtn">Зареєструватись</button>
            <p>
            <div class="divider"></div>
            Вже зареєстровані ? <a href="/login">Увійти</a>.
            </p>
        </div>
    </div>
</form>
<script>
    function validateCredentials() {
        var firstName = document.getElementById("firstName").value;
        var lastName = document.getElementById("lastName").value;
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var email = document.getElementById("email").value;
        var passwordConfirm = document.getElementById("passwordConfirm").value;

        if (password !== passwordConfirm) {
            alert("Passwords don't match");
            return false;
        }

        let success = false;
        $.ajax({
            type: "POST",
            async: false,
            url: "/registration",
            data: {
                firstName: firstName,
                lastName: lastName,
                username: username,
                password: password,
                email: email
            }
        }).done(function (response) {
            console.log(response);
            success = true;
        }).fail(function (response) {
            success = false;

            if (response.status === 403) {
                alert("КОРИСТУВАЧ З ТАКИМ НІКНЕЙМОМ ВЖЕ ІСНУЄ!");
            }
        });

        return success;
    }
</script>
</body>
</html>
