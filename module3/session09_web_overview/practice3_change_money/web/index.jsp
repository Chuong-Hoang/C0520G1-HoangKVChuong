<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25/08/2020
  Time: 9:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Conversion</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
  <h2>Currency Conversion</h2>
  <form method="get" action="convert">
    <label>Rate</label><br>
    <input type="text" name="rate" placeholder="RATE" value="23000"><br>
    <label>USD</label><br>
    <input type="text" name="usd" placeholder="USD" value="0"><br>
    <input type="submit" id="submit" value="Conversion">
  </form>
  </body>
</html>
