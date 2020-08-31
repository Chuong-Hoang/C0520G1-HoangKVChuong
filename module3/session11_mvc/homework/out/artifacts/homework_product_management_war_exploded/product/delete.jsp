<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28/08/2020
  Time: 11:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Element</title>
</head>
<body>
<h2>Delete Element</h2>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <h3>Do you really want to delete this product?</h3>
    <fieldset>
        <legend>Element Information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${product.name}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${product.price}</td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>${product.desc}</td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td>${product.producer}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete Element"></td>
                <td><a href="/products">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
