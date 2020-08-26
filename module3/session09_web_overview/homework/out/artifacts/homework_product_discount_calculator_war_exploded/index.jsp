<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25/08/2020
  Time: 10:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
  <form action="calculate" method="post">
      <label>Product Description:</label><br>
      <input type="text" name="description" value="Made in Vietnam" placeholder="Product Description:"><br>
      <label>Product Price:</label><br>
      <input type="text" name="price" value="120.00" placeholder="Product price: "><br>
      <label>Discount:</label><br>
      <input type="text" name="discount" value="5.00" placeholder="Discount (%): "><br>
      <input type="submit" id="submit" value="Calculate Discount">
  </form>
  </body>
</html>
