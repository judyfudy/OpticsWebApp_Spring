<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 02.02.2020
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Товари</title>
    <link href="<c:url value="../../resources/css/cards.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../components/header.jsp"/>

<select onchange="showProductsByOption(value)" class="custom-select ml-5 mt-5" style="width: 15%">
    <option selected hidden>Каталог</option>
    <c:forEach items="${productTypes}" var="productType">
        <option value="${productType.id}">${productType.name}</option>
    </c:forEach>
</select>

<div id="productsContainer"></div>

<script>
    function addToCart(id) {
        $.ajax({
            type: "POST",
            async: false,
            url: "/cart",
            data: {
                productId: id
            }
        }).done(function () {
            alert("ВАШ ТОВАР УСПІШНО ДОДАНО");
        }).fail(function () {
            alert("ВАШ ТОВАР НЕ ДОДАНО, СПРОБУЙТЕ ЩЕ РАЗ");
        });
    }

    function showProductsByOption(id) {
        $.ajax({
                type: "GET",
                async: false,
                url: "/getProductsByType",
                data: {
                    typeId: id
                },
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                success: function (data)  {
                    document.getElementById("productsContainer").innerHTML = "";
                    data.forEach(function (element) {
                        document.getElementById("productsContainer").innerHTML +=
                            ${sessionScope.user == null} ? '<div class="card mt-5 ml-5 mb-5" style="display: inline-block;">'
                            + '<img src="../../resources/images/sticker_1.jpg" width="100%" height="30%">' /* + element.photo */
                            + '<p>' + element.name + ' ' + element.brand + ' ' + element.model + '</p>'
                            + '<p class="price">Ціна: ' + element.price + ' грн.</p>'
                            + '<p class="small">Кількість:' + element.quantity + '</p>'
                            + '<a href="/login" class="button">Увійдіть, щоб добавити в корзину</a>'
                            + '</div>'
                            :
                            '<div class="card mt-5 ml-5 mb-5" style="display: inline-block;">'
                            + '<img src="../../resources/images/sticker_1.jpg" width="100%" height="30%">' /* + element.photo */
                            + '<p>' + element.name + ' ' + element.brand + ' ' + element.model + '</p>'
                            + '<p class="price">Ціна: ' + element.price + ' грн.</p>'
                            + '<p class="small">Кількість:' + element.quantity + '</p>'
                            + '<button onclick="addToCart(' + element.id + ')">Добавити в корзину' + '</button>'
                            + '</div>';
                    });
                }
            }
        );
    }
</script>

</body>
</html>
