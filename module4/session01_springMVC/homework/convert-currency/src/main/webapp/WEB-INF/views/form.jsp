<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16/09/2020
  Time: 3:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form input</title>
</head>
<body>
<form method="post" action="/form">
    <label>USD: </label>
    <input type="text" name="usd" placeholder="usd value..." value="${usd}"><br>
    <br>
    <label>Rate:</label>
    <input type="text" name="rate" placeholder="rate is..." value="${rate}"><br>
    <br>
    <input type="submit" value="convert"><br>
    <br>
    <label>VND:</label>
    <input type="text" name="result" placeholder="result.." value="${result}"><br>
</form>
</body>
</html>
