<%--
  Created by IntelliJ IDEA.
  User: Мария
  Date: 10.03.2024
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FindByProduct</title>
</head>
<body>
<h1>Введите условия</h1>
<form method = POST action="findByProduct-servlet">
    <div class="mb-3">
        <label>Наименование продукта в заказе</label><br>
        <input type="text" name ="prod_title">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<a href="index.jsp">на главную</a><br>
</body>
</html>
