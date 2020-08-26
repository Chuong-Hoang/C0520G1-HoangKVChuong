<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26/08/2020
  Time: 4:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Product Discount Calculator</h1>
  <form method="post" action="/calculate">
    <label>Product Description:</label><br>
    <input type="text" name="description"><br>
    <label>Price:</label><br>
    <input type="text" name="price"><br>
    <label>Discount:</label><br>
    <input type="text" name="discount"><br>
    <input type="submit" value="Calculate Discount">
  </form>
  </body>
</html>
