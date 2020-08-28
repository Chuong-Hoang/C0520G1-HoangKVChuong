<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/08/2020
  Time: 9:35 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Conversion</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
  <h3>Currency Conversion</h3>
  <form method="post" action="conversion.jsp">
    <label>Rate:</label><br>
    <input type="text" name="rate" placeholder="RATE" value="23000"><br>
    <label>USD: </label><br>
    <input type="text" name="usd" placeholder="USD" value="5"><br>
    <br>
    <input type="submit" id="submit" value="Converse">
  </form>
  </body>
</html>
