<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ignateva.myshop.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: Мария
  Date: 08.03.2024
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AllProducts</title>
</head>
<body>
<h1>Магазин</h1>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Наименование</th>
        <th scope="col">Описание</th>
        <th scope="col">Цена</th>
    </tr>
    </thead>
    <tbody>

    <%request.getAttribute("res");%>
    <p>
        <c:forEach items="res" varStatus="loop">
            <td> </td>
            <td>Otto</td>
            <td>@mdo</td>
        </c:forEach>
    </p>
        <tr>
        <th scope="row">1</th>
        <td></td>
        <td>Otto</td>
        <td>@mdo</td>
    </tr>

    <tr>
        <th scope="row">1</th>
        <td>Smith</td>
        <td>Otto</td>
        <td>@mdo</td>
    </tr>
    <tr>
        <th scope="row">2</th>
        <td>Jacob</td>
        <td>Thornton</td>
        <td>@fat</td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td colspan="2">Larry the Bird</td>
        <td>@twitter</td>
    </tr>
    </tbody>
</table>

</body>
</html>
