<%--
  Created by IntelliJ IDEA.
  User: Мария
  Date: 09.03.2024
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FindOrder</title>
</head>
<body>
<h1>Enter Order number (1254,2685,3564)</h1>
<form method = POST action="findOrder-servlet">
    <div class="mb-3">
        <label>Order number</label><br>
        <input type="number" name ="number1">
    </div>
</form>


<a href="index.jsp">на главную</a><br>
</body>
</html>
