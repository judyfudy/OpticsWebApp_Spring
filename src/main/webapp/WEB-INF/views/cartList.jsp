<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 04.02.2020
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Корзина</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="../../resources/css/cards.css"/>">
</head>
<body>
<jsp:include page="../components/header.jsp"/>

<div style="display: inline-flex;">
    <button type="button" class="btn btn-primary" style="display:block; margin-top: 30px; margin-left: 30px"
            onclick="clearCart()">Очистити корзину
    </button>
    <button type="button" class="btn btn-primary" style="display:block; margin-top: 30px; margin-left: 30px"
            onclick="buyProducts('${personInfo.email}')">Оформити замовлення
    </button>
</div>
<hr>

<c:forEach items="${productList}" var="product">
    <div class="row" id="cartRow">
        <div class="column">
            <div id="${product.id}" class="card mt-5 ml-5 mb-5">
                <img src="../../resources/images/sticker_1.jpg" alt="Denim Jeans" width="100%" height="30%">
                <p>${product.name} ${product.brand} ${product.model}</p>
                <p class="price">Ціна: ${product.price} грн.</p>
                <p class="small">Кількість: ${product.quantity}</p>
                <button onclick="removeFromCart(${product.id})">Забрати з корзини</button>
            </div>
        </div>
    </div>
</c:forEach>
<script>
    function removeFromCart(id) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/cart?productId=" + id,
        }).done(function () {
            document.getElementById(id).remove();
            alert("ВАШ ТОВАР УСПІШНО ВИДАЛЕНО");
        }).fail(function () {
            alert("ВАШ ТОВАР НЕ ВДАЛОСЯ ВИДАЛИТИ, СПРОБУЙТЕ ЩЕ РАЗ");
        });
    }

    function clearCart() {
        $.ajax({
            type: "DELETE",
            async: false,
            url: "http://localhost:8080/order",
        }).done(function () {
            alert("ВСІ ТОВАРИ УСПІШНО ВИДАЛЕНО");
        }).fail(function () {
            alert("ЩОСЬ ПІШЛО НЕ ТАК, СПРОБУЙТЕ ЩЕ РАЗ");
        });
    }

    function buyProducts(email) {
        $.ajax({
            type: "POST",
            async: false,
            url: "/order",
            data: {
                email: email
            }
        }).done(function () {
            alert("ВАМ НА ПОЧТУ ВІДПРАВЛЕНО ДЕТАЛІ ОПЛАТИ");
        }).fail(function () {
            alert("ЩОСЬ ПІШЛО НЕ ТАК, СПРОБУЙТЕ ЩЕ РАЗ");
        });
    }
</script>
</body>
</html>
