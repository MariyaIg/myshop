<%--
  Created by IntelliJ IDEA.
  User: Мария
  Date: 10.03.2024
  Time: 6:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findByAmount</title>
</head>
<body>
<h1>Введите условия</h1>
<form method = POST action="amount-servlet">
    <div class="mb-3">
        <label>Максимальная сумма заказа (от 1680)</label><br>
        <input type="number" name ="number1">
    </div>
    <div class="mb-3">
        <label>количество товаров в заказе(доступно 6 и 3)</label><br>
        <input type="number" name ="number2">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<a href="index.jsp">на главную</a><br>
</body>
</html>
